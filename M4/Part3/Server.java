package M4.Part3;

import java.util.Random;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Server {
    private Random rand = new Random(); //Yash Mandal - ym299 - 10/15/2023 - Added a Random instance variable to generate random numbers 
    int port = 3001;
    // connected clients
    private List<ServerThread> clients = new ArrayList<ServerThread>();

    private void start(int port) {
        this.port = port;
        // server listening
        try (ServerSocket serverSocket = new ServerSocket(port);) {
            Socket incoming_client = null;
            System.out.println("Server is listening on port " + port);
            do {
                System.out.println("waiting for next client");
                if (incoming_client != null) {
                    System.out.println("Client connected");
                    ServerThread sClient = new ServerThread(incoming_client, this);
                    
                    clients.add(sClient);
                    sClient.start();
                    incoming_client = null;
                    
                }
            } while ((incoming_client = serverSocket.accept()) != null);
        } catch (IOException e) {
            System.err.println("Error accepting connection");
            e.printStackTrace();
        } finally {
            System.out.println("closing server socket");
        }
    }
    protected synchronized void disconnect(ServerThread client) {
		long id = client.getId();
        client.disconnect();
		broadcast("Disconnected", id);
	}
    
    protected synchronized void broadcast(String message, long id) {
        if(processCommand(message, id)){

            return;
        }
        // let's temporarily use the thread id as the client identifier to
        // show in all client's chat. This isn't good practice since it's subject to
        // change as clients connect/disconnect
        message = String.format("User[%d]: %s", id, message);
        // end temp identifier
        
        // loop over clients and send out the message
        Iterator<ServerThread> it = clients.iterator();
        while (it.hasNext()) {
            ServerThread client = it.next();
            boolean wasSuccessful = client.send(message);
            if (!wasSuccessful) {
                System.out.println(String.format("Removing disconnected client[%s] from list", client.getId()));
                it.remove();
                broadcast("Disconnected", id);
            }
        }
    }

    private boolean processCommand(String message, long clientId){
        System.out.println("Checking command: " + message);

        //Yash Mandal - ym299 - 10/15/2023 - Implemented coin toss feature
        if(message.equalsIgnoreCase("flip") || message.equalsIgnoreCase("toss")){
            boolean isHeads = rand.nextBoolean();
            String result = String.format("User[%d] flipped a coin and got %s", clientId, isHeads ? "heads" : "tails");
            broadcast(result, clientId);
            return true;
          }

        //Yash Mandal - ym299 - 10/15/2023 - Implemented dice roll feature
        else if(message.matches("roll \\d+d\\d+")) { //regex handles roll #d# pattern 
            String[] parts = message.split(" "); //splits roll and #d#
            int numDice = Integer.parseInt(parts[1].substring(0, parts[1].indexOf("d"))); //gets this "#"d# as int
            int numSides = Integer.parseInt(parts[1].substring(parts[1].indexOf("d") + 1)); //gets this #d"#"" as int
            
            int total = 0;
            for(int i = 0; i < numDice; i++) { //Loop for the # of dice, generating a random number from 1 to # sides for each die
                total += rand.nextInt(numSides) + 1;
            }
            
            String result = String.format("User[%d] rolled %s and got %d", clientId, parts[1], total);
                
            broadcast(result, clientId); //broadcast formatted string (format "User[clientId] rolled #d# and got 'result'") to all clients
            return true;
        }
        else if (message.equalsIgnoreCase("disconnect")){
            Iterator<ServerThread> it = clients.iterator();
            while (it.hasNext()) {
                ServerThread client = it.next();
                if(client.getId() == clientId){
                    it.remove();
                    disconnect(client);
                    
                    break;
                }
            }
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println("Starting Server");
        Server server = new Server();
        int port = 3000;
        try {
            port = Integer.parseInt(args[0]);
        } catch (Exception e) {
            // can ignore, will either be index out of bounds or type mismatch
            // will default to the defined value prior to the try/catch
        }
        server.start(port);
        System.out.println("Server Stopped");
    }
}
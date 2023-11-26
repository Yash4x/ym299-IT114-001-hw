package Project.server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Logger;

import Project.common.Constants;

public class Room implements AutoCloseable {
    // server is a singleton now so we don't need this
    // protected static Server server;// used to refer to accessible server
    // functions
    private Random rand = new Random();
    private String name;
    private List<ServerThread> clients = new ArrayList<ServerThread>();
    private boolean isRunning = false;
    // Commands
    //private final String BOLD = "*";
    //private final String ITALICS = "_";
    //private final String UNDERLINE = "+";
    private Map<Long, List<Long>> mutedUsers = new HashMap<>(); ///////////////////////////////
    private final static String COMMAND_TRIGGER = "/";
    private final static String CREATE_ROOM = "createroom";
    private final static String JOIN_ROOM = "joinroom";
    private final static String DISCONNECT = "disconnect";
    private final static String LOGOUT = "logout";
    private final static String LOGOFF = "logoff";
    private static Logger logger = Logger.getLogger(Room.class.getName());

        // New helper method
    private long getClientIdFromName(String name) {
        for(ServerThread client : clients) {
            if(client.getClientName().equals(name)) {
                return client.getClientId();
            } 
        }
        return -1; 
    }///////////////////////




    public Room(String name) {
        this.name = name;
        isRunning = true;
    }

    public String getName() {
        return name;
    }

    public boolean isRunning() {
        return isRunning;
    }

    protected synchronized void addClient(ServerThread client) {
        if (!isRunning) {
            return;
        }
        client.setCurrentRoom(this);
        if (clients.indexOf(client) > -1) {
            logger.warning("Attempting to add client that already exists in room");
        } else {
            clients.add(client);
            client.sendResetUserList();
            syncCurrentUsers(client);
            sendConnectionStatus(client, true);
        }
    }

    protected synchronized void removeClient(ServerThread client) {
        if (!isRunning) {
            return;
        }
        // attempt to remove client from room
        try {
            clients.remove(client);
        } catch (Exception e) {
            logger.severe(String.format("Error removing client from room %s", e.getMessage()));
            e.printStackTrace();
        }
        // if there are still clients tell them this person left
        if (clients.size() > 0) {
            sendConnectionStatus(client, false);
        }
        checkClients();
    }

    private void syncCurrentUsers(ServerThread client) {
        Iterator<ServerThread> iter = clients.iterator();
        while (iter.hasNext()) {
            ServerThread existingClient = iter.next();
            if (existingClient.getClientId() == client.getClientId()) {
                continue;// don't sync ourselves
            }
            boolean messageSent = client.sendExistingClient(existingClient.getClientId(),
                    existingClient.getClientName());
            if (!messageSent) {
                handleDisconnect(iter, existingClient);
                break;// since it's only 1 client receiving all the data, break if any 1 send fails
            }
        }
    }

    /***
     * Checks the number of clients.
     * If zero, begins the cleanup process to dispose of the room
     */
    private void checkClients() {
        // Cleanup if room is empty and not lobby
        if (!name.equalsIgnoreCase(Constants.LOBBY) && (clients == null || clients.size() == 0)) {
            close();
        }
    }

    /***
     * Helper function to process messages to trigger different functionality.
     * 
     * @param message The original message being sent
     * @param client  The sender of the message (since they'll be the ones
     *                triggering the actions)
     */
    @Deprecated // not used in my project as of this lesson, keeping it here in case things
                // change

    // Yash Mandal  ym299 11/11/2023
  private String formatText(String text) {
    String formatted = "";

    // Bold
    formatted = text.replaceAll("\\*(.+?)\\*", "<b>$1</b>");

    // Italics
    formatted = formatted.replaceAll("-(.+?)-", "<i>$1</i>"); 

    // Underline
    formatted = formatted.replaceAll("_(.+?)_", "<u>$1</u>");

    // Red
    formatted = formatted.replaceAll("#r(.+?)r#", "<font color=red>$1</font>");

    // Green
    formatted = formatted.replaceAll("#g(.+?)g#", "<font color=green>$1</font>");

    // Blue
    formatted = formatted.replaceAll("#b(.+?)b#", "<font color=blue>$1</font>");

    return formatted;
  }

    private boolean processCommands(String message, ServerThread client) {
        boolean wasCommand = false;
        try {

            if(message.startsWith("/mute")) {///////////////
                String target = message.split(" ")[1];
                long toMute = getClientIdFromName(target); 
                mutedUsers.computeIfAbsent(client.getClientId(), k -> new ArrayList<>()).add(toMute);
                return true;
              }
              
              if(message.startsWith("/unmute")) {
                String target = message.split(" ")[1];  
                long toUnmute = getClientIdFromName(target);
                List<Long> muted = mutedUsers.get(client.getClientId());
                if(muted != null) {
                  muted.remove(toUnmute);
                }
                return true;
              }///////////////////
            // ROLL AND FLIP METHODS- Yash Mandal - ym299 - 11/9/2023
			if(message.startsWith("/roll")) {

				String[] parts = message.split(" ");
			
				if(parts.length == 2 && parts[1].contains("d")) {
			
				  // format: /roll #d#
				  String[] dice = parts[1].split("d");
				  int numDice = Integer.parseInt(dice[0]);
				  int numSides = Integer.parseInt(dice[1]);
			
				  int total = 0;
				  for(int i=0; i<numDice; i++) {
					total += rand.nextInt(numSides) + 1;
				  }
			
				  sendMessage(client, client.getClientName() + " rolled " + total + " using " + parts[1] + "/roll29x3728O");
				  return true;
			
				} 
				
				else if(parts.length == 2) {
			
				  // format: /roll #   (start at 1 for rolls)

                  int max = Integer.parseInt(parts[1]);
                  int roll = (int)(Math.random() * max) + 1;
			
				  sendMessage(client, client.getClientName() + " rolled " + roll + " using " + message + "/roll29x3728O");
				  return true;
			
				} 
				
				else {
				  // invalid format
				  sendMessage(client, "Invalid roll format. Use '/roll x-y' or '/roll #d#'"); 
				  return true;
				}
			
			
			  } 
			  
			  else if(message.startsWith("/flip")) { // Flip ym299 Yash Mandal 11/11/2023
			
				int flip = rand.nextInt(2);
				String result = flip == 0 ? "heads" : "tails";
			
				sendMessage(client, client.getClientName() + " flipped " + result + "/flip29x3728O");
			
				return true;
			
			  }
            if (message.startsWith(COMMAND_TRIGGER)) {
                String[] comm = message.split(COMMAND_TRIGGER);
                String part1 = comm[1];
                String[] comm2 = part1.split(" ");
                String command = comm2[0];
                String roomName;
                wasCommand = true;
                switch (command) {
                    case CREATE_ROOM:
                        roomName = comm2[1];
                        Room.createRoom(roomName, client);
                        break;
                    case JOIN_ROOM:
                        roomName = comm2[1];
                        Room.joinRoom(roomName, client);
                        break;
                    case DISCONNECT:
                    case LOGOUT:
                    case LOGOFF:
                        Room.disconnectClient(client, this);
                        break;
                    default:
                        wasCommand = false;
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return wasCommand;
    }

    // Command helper methods
    protected static void getRooms(String query, ServerThread client) {
        String[] rooms = Server.INSTANCE.getRooms(query).toArray(new String[0]);
        client.sendRoomsList(rooms,
                (rooms != null && rooms.length == 0) ? "No rooms found containing your query string" : null);
    }

    protected static void createRoom(String roomName, ServerThread client) {
        if (Server.INSTANCE.createNewRoom(roomName)) {
            Room.joinRoom(roomName, client);
        } else {
            client.sendMessage(Constants.DEFAULT_CLIENT_ID, String.format("Room %s already exists", roomName));
        }
    }

    /**
     * Will cause the client to leave the current room and be moved to the new room
     * if applicable
     * 
     * @param roomName
     * @param client
     */
    protected static void joinRoom(String roomName, ServerThread client) {
        if (!Server.INSTANCE.joinRoom(roomName, client)) {
            client.sendMessage(Constants.DEFAULT_CLIENT_ID, String.format("Room %s doesn't exist", roomName));
        }
    }

    protected static void disconnectClient(ServerThread client, Room room) {
        client.disconnect();
        room.removeClient(client);
    }
    // end command helper methods

    private ServerThread getClientByName(String recipient) { // Gets client name Yash Mandal ym299 11/15/2023
        for(ServerThread client : clients) {
          if(client.getClientName().equals(recipient)) {
            return client;
          }
        }
        return null;
      }
    
    /***
     * Takes a sender and a message and broadcasts the message to all clients in
     * this room. Client is mostly passed for command purposes but we can also use
     * it to extract other client info.
     * 
     * @param sender  The client sending the message
     * @param message The message to broadcast inside the room
     */
    protected synchronized void sendMessage(ServerThread sender, String message) {

        if (!isRunning) {
            return;
        }

        
        message = formatText(message); // format message command Yash Mandal ym299 11/11/2023

        if(message.startsWith("@")) { // @username sends message privately Yash Mandal ym299 11/15/2023

            // Extract recipient name
            String[] split = message.split(" ", 2);
            String recipient = split[0].substring(1);
            
            // Get recipient client 
            ServerThread recipientClient = getClientByName(recipient); 
            Iterator<ServerThread> iter = clients.iterator();
            // Send private message
            
                ServerThread client = iter.next();
                if(mutedUsers.containsKey(client.getClientId()) && mutedUsers.get(client.getClientId()).contains(sender.getClientId())) {//////////////////
                    return; // skip sending message to this client
                }
            ///////////
                else if(clients.contains(recipientClient)) {
                
                    recipientClient.sendMessage(sender.getClientId(), message);
                    sender.sendMessage(sender.getClientId(),message);
          
                }

                else {
                    sender.sendMessage(sender.getClientId(),"This person is not in this room.");
                }
            
          
            // Don't broadcast 
            return;
          
        }

        logger.info(String.format("Sending message to %s clients", clients.size()));
        if (sender != null && processCommands(message, sender)) {
            // it was a command, don't broadcast
            return;
        }

        if(message.endsWith("/flip29x3728O")){ // Format result to show lobby name for flip result Yash Mandal ym299 11/11/2023
			String s = getName();
            long from = sender == null ? Constants.DEFAULT_CLIENT_ID : sender.getClientId();

			// Remove command  
			message = message.replaceFirst("/flip29x3728O$", "");
			Iterator<ServerThread> iter = clients.iterator();
			while (iter.hasNext()) {
				ServerThread client = iter.next();
				boolean messageSent = client.sendMessage(from, message + " in room " + s);
				if (!messageSent) {
					handleDisconnect(iter, client);
				}
			}
			return;
		}

		if(message.endsWith("/roll29x3728O")){ // Format result to show lobby name for flip result Yash Mandal ym299 11/11/2023
			String s = getName();
            long from = sender == null ? Constants.DEFAULT_CLIENT_ID : sender.getClientId();

			// Remove command  
			message = message.replaceFirst("/roll29x3728O$", "");
			Iterator<ServerThread> iter = clients.iterator();
			while (iter.hasNext()) {
				ServerThread client = iter.next();
				boolean messageSent = client.sendMessage(from, message + " in room " + s);
				if (!messageSent) {
					handleDisconnect(iter, client);
				}
			}
			return;
		}
        long from = sender == null ? Constants.DEFAULT_CLIENT_ID : sender.getClientId();
        Iterator<ServerThread> iter = clients.iterator();
        while (iter.hasNext()) {
            ServerThread client = iter.next();
            if(mutedUsers.containsKey(client.getClientId()) && mutedUsers.get(client.getClientId()).contains(sender.getClientId())) {//////////////////
                continue; // skip sending message to this client
            }
            ///////////
            boolean messageSent = client.sendMessage(from, message);
            if (!messageSent) {
                handleDisconnect(iter, client);
            }
        }
    }

    protected synchronized void sendConnectionStatus(ServerThread sender, boolean isConnected) {
        Iterator<ServerThread> iter = clients.iterator();
        while (iter.hasNext()) {
            ServerThread receivingClient = iter.next();
            boolean messageSent = receivingClient.sendConnectionStatus(
                    sender.getClientId(),
                    sender.getClientName(),
                    isConnected);
            if (!messageSent) {
                handleDisconnect(iter, receivingClient);
            }
        }
    }

    private void handleDisconnect(Iterator<ServerThread> iter, ServerThread client) {
        iter.remove();
        logger.info(String.format("Removed client %s", client.getClientName()));
        sendMessage(null, client.getClientName() + " disconnected");
        checkClients();
    }

    public void close() {
        Server.INSTANCE.removeRoom(this);
        isRunning = false;
        clients.clear();
    }
}

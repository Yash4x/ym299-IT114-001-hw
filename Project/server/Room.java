package Project.server;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
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
    //private final String UNDERLINE = "+";                      // Yash Mandal ym299 12/9/2023
    private Map<Long, List<Long>> mutedUsers = new HashMap<>(); // Map to track which users have muted which other users, Key = user id of muter, Value = list of muted user ids
    private List <Long> mutedMessage = new ArrayList<>(); // created string lists to track which users are muted to avoid spam
    private List <Long> unmutedMessage = new ArrayList<>();// created string lists to track which users are unmuted to avoid spam
    Map<String, List<String>> mutedUsersByUsername = new HashMap<>();// created Map to basically convert the mutedUsers map with ids to usernames
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

    private void convertMutedUsernamesToIds() { // Convert mutedUsersByUsername map from usernames to ids // Yash Mandal ym299 12/9/2023

        for(Map.Entry<String, List<String>> entry : mutedUsersByUsername.entrySet()) { // Iterate through each entry in mutedUsersByUsername map
      
          String muterUsername = entry.getKey(); // Get muter username 
          
          List<Long> mutedIds = new ArrayList<>(); // List to store muted ids
      
          for(String mutedUsername : entry.getValue()) { // Iterate through muted usernames list for this muting user 
      
            long mutedId = getClientIdFromName(mutedUsername);// Get muted user id from username
            mutedIds.add(mutedId);   // Add muted id to list 
      
          }
      
          long muterId = getClientIdFromName(muterUsername); // Get muter user id from username
      
          // Add list of muted ids under muter id to main mutedUsers map
          mutedUsers.put(muterId, mutedIds);
      
        }
      
    }
    private void readSavedMutedUsersFile(ServerThread client) { // Read saved muted users from CSV // Yash Mandal ym299 12/9/2023

        String filename = client.getClientName() + "_muted_users.csv"; // Load saved CSV file for this user

        try {

            // Open file for reading
            File file = new File(filename);
            Scanner scanner = new Scanner(file);

            // Read lines 
            while(scanner.hasNextLine()) {

            String line = scanner.nextLine();
            
            // Split line on comma
            String[] parts = line.split(",");

            if(parts.length != 2) {
                continue; // skip line if not 2 parts
            }

            // Get muting user and muted users list 
            String mutingUser = parts[0];
            String mutedUsersString = parts[1];

            if(mutedUsersString.isEmpty()) {
                continue; // skip if second part is empty
            }

            // Split muted users string 
            String[] mutedUsernames = mutedUsersString.split("\\|");

            // Add to map
            List<String> mutedUsernameList = Arrays.asList(mutedUsernames);
            mutedUsersByUsername.put(mutingUser, mutedUsernameList);

            }

            scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void saveMutedUsers(ServerThread client) { // Save muted users to CSV file // Yash Mandal ym299 12/9/2023

        try {
                
            String mutingUser = client.getClientName(); // Get muting user name
                
            List<String> mutedUsers = mutedUsersByUsername.getOrDefault(mutingUser, new ArrayList<>()); // Get list of muted usernames for this user

            if(mutedUsers == null || mutedUsers.isEmpty()) {
                // No muted users, skip saving
                return;
            }
                
            String fileName = mutingUser + "_muted_users.csv"; // Construct file name 
                
            File file = new File(fileName); // Open file for writing
                
            FileWriter fileWriter = new FileWriter(file);
                
            String record = mutingUser + "," + String.join("|", mutedUsers); // Create CSV record             
            fileWriter.write(record + "\n"); // Write to the file  
            fileWriter.close();
                
        } catch (IOException e) {
            e.printStackTrace();
        }
    
    }

    private void convertMutedUsersToUsernames() { // Convert ids back to usernames // Yash Mandal ym299 12/9/2023
 
        for (Map.Entry<Long, List<Long>> entry : mutedUsers.entrySet()) { // Loop through main mutedUsers map
    
          String muterUsername = getUsernameById(entry.getKey());   // Get muting user id and username 
    
          List<String> mutedUsernames = new ArrayList<>(); // List to store muted usernames  
        
          for (Long mutedId : entry.getValue()) { // Loop through muted ids list
            String mutedUsername = getUsernameById(mutedId);  // Convert id to username
            mutedUsernames.add(mutedUsername);   // Add to list 
          }
    
          mutedUsersByUsername.put(muterUsername, mutedUsernames); // Add entry to mutedUsersByUsername map
    
        }
    
      }

      private String getUsernameById(long id) {

        for(ServerThread client : clients) {
          if(client.getClientId() == id) {
            return client.getClientName();
          }
        }
      
        return null;
      
      }




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

            // create a new file for client to check if they already have one with their name. // Yash Mandal ym299 12/9/2023
            String fileName = client.getClientName() + "_muted_users.csv";
            File file = new File(fileName);
            if(file.exists()) { // if the file exists, read the file, and convert the muted usernames to Ids.
                readSavedMutedUsersFile(client);
                convertMutedUsernamesToIds();
            }
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

            if(message.startsWith("/mute")) {// Handle /mute command YASH MANDAL ym299 11/15/23
                String target = message.split(" ")[1]; // Get target user name
                long toMute = getClientIdFromName(target);  // Get target user id
                Iterator<ServerThread> iter = clients.iterator();
                ServerThread recipientClient = getClientByName(target);
                while(iter.hasNext()){  // Check each client
                    if(clients.contains(recipientClient)) {// Check if target user is in room
                        mutedUsers.computeIfAbsent(client.getClientId(), k -> new ArrayList<>()).add(toMute); // If yes, add target user id to muter's muted list
                        // Check if muted message already sent
                        if (!mutedMessage.contains(recipientClient.getClientId()) && mutedUsersByUsername.containsKey(client.getClientName())){ 
                            unmutedMessage.remove(recipientClient.getClientId()); // Remove from unmuted list if needed
                            mutedMessage.add(recipientClient.getClientId()); // Add user id to muted message list
                            client.sendMessage(client.getClientId(),"You muted " + target); // Send confirmation to muting user   
                            recipientClient.sendMessage(recipientClient.getClientId(), client.getClientName() + " muted you."); // Tell target user they were muted
                            convertMutedUsersToUsernames(); // Convert main muted users map back to usernames
                            saveMutedUsers(client); // Save muted users on client file
                            break;
                        }

                        else {break;}
                    }

                    else { // // If no, send error that target not in room
                        client.sendMessage(client.getClientId(), target + " is not in this room.");
                        break;
                    }
            
                }
                return true;
              }
              
              if(message.startsWith("/unmute")) { // Handle /unmute command YASH MANDAL ym299 11/15/23
                String target = message.split(" ")[1];  // Get target user name
                long toUnmute = getClientIdFromName(target); // Get target user id
                List<Long> muted = mutedUsers.get(client.getClientId());
                List<String> mutedString = mutedUsersByUsername.get(client.getClientName());
                if(muted != null) { //if muted list is not empty: 
                  muted.remove(toUnmute); // Remove target user id from muter's muted list if exists                         
                  Iterator<ServerThread> iter = clients.iterator();
                  ServerThread recipientClient = getClientByName(target);
                  while(iter.hasNext()){  // Check each client
                    if(clients.contains(recipientClient)) {// Check if target user is in room
                        if (!unmutedMessage.contains(recipientClient.getClientId()) && mutedString != null){ // Check if unmute message already sent
                            mutedMessage.remove(recipientClient.getClientId()); // Remove user id from muted messages since unmute message was not yet sent
                            unmutedMessage.add(recipientClient.getClientId()); // add user id to unmuted messages since unmute message was not yet sent
                            client.sendMessage(client.getClientId(),"You unmuted " + target);  // Tell muting user unmute succeeded
                            recipientClient.sendMessage(recipientClient.getClientId(), client.getClientName() + " unmuted you.");  // Tell target they were unmuted
                            //check if the client and its muted user is in mutedUsersByUsername List
                            if (mutedUsersByUsername.containsKey(client.getClientName()) && mutedUsersByUsername.get(client.getClientName()).equals(target)) {
                                mutedUsersByUsername.remove(target); // If yes, remove them.
                                saveMutedUsers(client); //save the client file.
                            }
                            else{
                                convertMutedUsersToUsernames(); // if for some reason the if statement was false, convert the muted users list to usernames and save it.
                                saveMutedUsers(client);// then save the client file.
                            }
                            break;
                        }

                        else {break;}
                    }

                    else { // If no, send error that target not in room
                        client.sendMessage(client.getClientId(), target + " is not in this room.");
                        break;
                    }
            
                  }
                }
                return true;
              }
            // ROLL AND FLIP METHODS- Yash Mandal - ym299 - 11/9/2023
			if(message.startsWith("/roll")) {
				String[] parts = message.split(" "); // Split message Yash Mandal - ym299 - 11/9/2023
			
				if(parts.length == 2 && parts[1].contains("d")) { // Check format #d# Yash Mandal - ym299 - 11/9/2023
				  // Split on letter d and parse dice as int to the left and right of the letter d Yash Mandal - ym299 - 11/9/2023 
				  String[] dice = parts[1].split("d");
				  int numDice = Integer.parseInt(dice[0]);
				  int numSides = Integer.parseInt(dice[1]);
                    
                  // Generate rolls Yash Mandal - ym299 - 11/9/2023
				  int total = 0;
				  for(int i=0; i<numDice; i++) {
					total += rand.nextInt(numSides) + 1;
				  }
			
				  sendMessage(client, client.getClientName() + " rolled " + total + " using " + parts[1] + "/roll29x3728O"); // Send message Yash Mandal - ym299 - 11/9/2023
				  return true;
			
				} 
				else if(parts.length == 2) {
			
				  // format: /roll #   (start at 1 for rolls) Yash Mandal - ym299 - 11/9/2023
                  int max = Integer.parseInt(parts[1]);
                  int roll = (int)(Math.random() * max) + 1;
			
				  sendMessage(client, client.getClientName() + " rolled " + roll + " using " + message + "/roll29x3728O"); // Send message Yash Mandal - ym299 - 11/9/2023
				  return true;
			
				} 
				else {
				  // invalid format Yash Mandal - ym299 - 11/9/2023
				  sendMessage(client, "Invalid roll format. Use '/roll x-y' or '/roll #d#'"); 
				  return true;
				}
			
			  } 
			  
			  else if(message.startsWith("/flip")) { // Flip ym299 Yash Mandal 11/11/2023
                
				int flip = rand.nextInt(2); // Generate random 0 or 1 ym299 Yash Mandal 11/11/2023 
				String result = flip == 0 ? "heads" : "tails"; // Convert to string result ym299 Yash Mandal 11/11/2023
			
				sendMessage(client, client.getClientName() + " flipped " + result + "/flip29x3728O"); // Send initial result message ym299 Yash Mandal 11/11/2023 
			
				return true; // Return true because command was processed ym299 Yash Mandal 11/11/2023
			
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

            // Get recipient name after '@' symbol
            String[] split = message.split(" ", 2);
            String recipient = split[0].substring(1);
            
            // Get recipient client object
            ServerThread recipientClient = getClientByName(recipient); // Iterate through connected clients 
            Iterator<ServerThread> iter = clients.iterator();
           
            while(iter.hasNext()){  // Check each client
                ServerThread client = iter.next();
                if(mutedUsers.containsKey(client.getClientId()) && mutedUsers.get(client.getClientId()).contains(sender.getClientId())) {///// Check if sender is muted
                    sender.sendMessage(sender.getClientId(),"This person has you muted.");
                    break; // skip sending message to this client
                }

                else if(clients.contains(recipientClient)) {// if not muted && recepient is in the same room, send private message to sender and receiver
                
                    recipientClient.sendMessage(sender.getClientId(), message);
                    sender.sendMessage(sender.getClientId(),message);
                    break;
                }

                else { // else client is not in room
                    sender.sendMessage(sender.getClientId(),"This person is not in this room.");
                    break;
                }
            
            }
            // Don't broadcast message
            return;
          
        }

        logger.info(String.format("Sending message to %s clients", clients.size()));
        if (sender != null && processCommands(message, sender)) {
            // it was a command, don't broadcast
            return;
        }

        if(message.endsWith("/flip29x3728O")){ // Format result to show lobby name for flip result Yash Mandal ym299 11/11/2023
			String s = getName(); // Get room name Yash Mandal ym299 11/11/2023
            long from = sender == null ? Constants.DEFAULT_CLIENT_ID : sender.getClientId(); // Get client ID Yash Mandal ym299 11/11/2023 

			// Remove appended string
			message = message.replaceFirst("/flip29x3728O$", "");
			Iterator<ServerThread> iter = clients.iterator(); // Iterate over clients Yash Mandal ym299 11/11/2023
			while (iter.hasNext()) { // Send message to each client Yash Mandal ym299 11/11/2023
				ServerThread client = iter.next(); // Get next client Yash Mandal ym299 11/11/2023
				boolean messageSent = client.sendMessage(from, "<b>" + message + " in room " + s + "</b>"); // Send formatted message with room name Yash Mandal ym299 11/11/2023  
				if (!messageSent) { // Check for disconnect Yash Mandal ym299 11/11/2023
					handleDisconnect(iter, client);
				}
			}
			return;
		}

		if(message.endsWith("/roll29x3728O")){ // Format result to show lobby name for flip result Yash Mandal ym299 11/11/2023
			String s = getName(); // Get room name Yash Mandal ym299 11/11/2023
            long from = sender == null ? Constants.DEFAULT_CLIENT_ID : sender.getClientId(); // Get client ID Yash Mandal ym299 11/11/2023

			// Remove appended string  
			message = message.replaceFirst("/roll29x3728O$", "");
			Iterator<ServerThread> iter = clients.iterator(); // Iterate over clients Yash Mandal ym299 11/11/2023
			while (iter.hasNext()) { // Send message to each client Yash Mandal ym299 11/11/2023
				ServerThread client = iter.next(); // Get next client Yash Mandal ym299 11/11/2023
				boolean messageSent = client.sendMessage(from, "<b>" + message + " in room " + s + "</b>"); // Send formatted message with room name Yash Mandal ym299 11/11/2023
				if (!messageSent) { // Check for disconnect Yash Mandal ym299 11/11/2023
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

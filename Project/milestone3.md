<table><tr><td> <em>Assignment: </em> IT114 Chatroom Milestone3</td></tr>
<tr><td> <em>Student: </em> Yash Mandal (ym299)</td></tr>
<tr><td> <em>Generated: </em> 11/26/2023 6:21:33 PM</td></tr>
<tr><td> <em>Grading Link: </em> <a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-001-F23/it114-chatroom-milestone3/grade/ym299" target="_blank">Grading</a></td></tr></table>
<table><tr><td> <em>Instructions: </em> <p>Implement the features from Milestone3 from the proposal document:&nbsp;&nbsp;<a href="https://docs.google.com/document/d/1ONmvEvel97GTFPGfVwwQC96xSsobbSbk56145XizQG4/view">https://docs.google.com/document/d/1ONmvEvel97GTFPGfVwwQC96xSsobbSbk56145XizQG4/view</a></p>
</td></tr></table>
<table><tr><td> <em>Deliverable 1: </em> Connection Screens </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshots showing the screens with the following data</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fym299%2F2023-11-26T20.39.22image.png.webp?alt=media&token=90a2c04e-3b3b-4991-88f1-bfb0451a3177"/></td></tr>
<tr><td> <em>Caption:</em> <p>showing host and port screen<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fym299%2F2023-11-26T20.39.54image.png.webp?alt=media&token=5799603a-5a58-4569-a1cc-070e6c41a8ed"/></td></tr>
<tr><td> <em>Caption:</em> <p>showing username screen<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Briefly explain the code for each step of the process</td></tr>
<tr><td> <em>Response:</em> <div><ul><li><li>Gets host, port, username from client GUI</li><li>Creates socket to server using host and<br>port</li><li>Send CONNECT payload with username</li><li>Server registers connection</li><li>Server replies CONNECTED payload</li><li>Client can now communicate<br>over socket streams</li></li></ul></div><div><br></div><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 2: </em> Chatroom view </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshots showing the related UI</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fym299%2F2023-11-26T20.59.27image.png.webp?alt=media&token=a7d12b6d-fca0-4f78-8208-63835aa08fee"/></td></tr>
<tr><td> <em>Caption:</em> <p>Showing list of users in the room for two different clients. Showing the<br>chat message area with chat history. And, showing create message area with send<br>button<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fym299%2F2023-11-26T21.02.16image.png.webp?alt=media&token=c56079b6-6644-4099-8c6e-d93c004eb4ec"/></td></tr>
<tr><td> <em>Caption:</em> <p>Showing code snippet for the code that lets the enter key send the<br>message.<br></p>
</td></tr>
</table></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 3: </em> Chat Activities </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Show screenshots of the result of the following commands</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fym299%2F2023-11-26T21.08.54image.png.webp?alt=media&token=0f78a49a-36aa-4b53-9925-e2502b6fb3df"/></td></tr>
<tr><td> <em>Caption:</em> <p>Showing /flip and /roll with who triggered it and with what command in<br>bold text.<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Show the code snippets for each command</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fym299%2F2023-11-26T21.33.54image.png.webp?alt=media&token=2573f485-c7da-4d39-9ba3-f54ea0b959cc"/></td></tr>
<tr><td> <em>Caption:</em> <p>showing flip and roll commands processing in processCommands() method in Room.java (server side)<br>with ucid and date.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fym299%2F2023-11-26T21.36.35image.png.webp?alt=media&token=52553d29-24ee-4bcb-b559-9b1c4cc9fbdf"/></td></tr>
<tr><td> <em>Caption:</em> <p>showing flip and roll command message format for the result before sending it<br>in sendMessage() method in Room.java(server side) with ucid and date.<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain the code flow of each command</td></tr>
<tr><td> <em>Response:</em> <div>Roll and Flip Logic:</div><div><br></div><div><ul><li>The logic starts when the client sends a message to<br>the server that begins with "/roll" or "/flip"</li><li>The server detects this is a<br>command by checking the first characters of the message</li><li>For /roll, it parses out<br>the roll parameters (number of dice, sides per die)</li><li>It then uses Java's Random<br>class to simulate rolling dice and totals the result</li><li>For /flip, it just generates<br>a random 0 or 1 and maps it to "heads" or "tails"</li><li>The raw<br>roll/flip result is sent back to the originating client</li><li>The server appends a special<br>string like "/roll29x3728O" to the message</li><li>When sendMessage() detects this appended string, it formats<br>the message by:</li><li>Extracting the room name</li><li>Removing the appended string</li><li>Adding formatted HTML tags and<br>room name</li><li>Sends formatted message to all connected clients</li></ul></div><div><div>/roll specific logic:</div><div><ul><li>This first checks the<br>format of the /roll command to determine how to handle it. There are<br>two supported formats:</li></ul></div><div>/roll xdY</div><div><ul><li>This will roll x number of dice with Y sides<br>each.</li><li>It splits the input on "d" into two parts, parses them to ints</li><li>Loops<br>x times, generating a random int from 1 to Y</li><li>Sums all the rolls<br>and sends the total</li></ul></div><div>/roll X</div><div><ul><li>This will generate a random int from 1 to<br>X</li><li>Parses X to an int</li><li>Generates random int from 1 to X</li><li>Sends the single<br>roll value</li><li>If invalid format, it sends an error message.</li></ul></div></div><div><br></div><div><br></div><div>Client -&gt; Server -&gt; Client<br>Flow:</div><div><br></div><div><ul><li>Client sends a chat message to the server (may contain a command)</li><li>Server receives<br>the message</li><li>Server detects if it's a command and processes it if so</li><li>For roll/flip<br>this involves generating a result</li><li>Server sends raw command result back to originating client</li><li>Server<br>appends a formatting string to message</li><li>Server sendMessage() detects formatting string</li><li>Formatted message is sent<br>to all clients (including original sender)</li><li>Clients receive the formatted message containing the command<br>result</li></ul></div><div><br></div><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 4: </em> Custom Text </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Screenshots of examples</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fym299%2F2023-11-26T21.45.56image.png.webp?alt=media&token=7cbf754b-caea-48a9-8522-36ee9339ca45"/></td></tr>
<tr><td> <em>Caption:</em> <p>showing input and output of bold, italics, underline, and colored texts in one<br>large message.<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Briefly explain how you got the UI side to render the text accordingly</td></tr>
<tr><td> <em>Response:</em> <p>For the UI side to render html tags, chatPanel&#39;s jeditorPanel needed to accept<br>html tags as an input. This was simply done by changing the type<br>of text it accepts in the parameter for the jeditorpane object from plain<br>text to html text which looks like this:&nbsp;JEditorPane textContainer = new JEditorPane(&quot;text/html&quot;, text);<br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 5: </em> Whisper </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshots showing a demo of whisper commands</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fym299%2F2023-11-26T21.52.21image.png.webp?alt=media&token=919bbf4d-04ca-43de-a0fa-31a32410c046"/></td></tr>
<tr><td> <em>Caption:</em> <p>showing command triggered by @username and private message is only visible to the<br>sender and receiver amongst three different clients in the same lobby.<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Show the server-side code snippets of how this feature works</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fym299%2F2023-11-26T22.51.09image.png.webp?alt=media&token=7b84687e-8e10-4cd0-b0e7-354d0e4ad264"/></td></tr>
<tr><td> <em>Caption:</em> <p>showing @username command processing in sendMessage() method in room.java. Note that it also<br>does not allow users to send messages to other users who have them<br>muted.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fym299%2F2023-11-26T22.52.53image.png.webp?alt=media&token=aafaeb4a-19cd-4a61-9ac1-a570b3c68b3e"/></td></tr>
<tr><td> <em>Caption:</em> <p>added a getClientByName method to check for the client&#39;s name in the clients<br>pool from a string and return the client.<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain the code logic of how this was achieved</td></tr>
<tr><td> <em>Response:</em> <div><ul><li>Check if message starts with @</li><li>If so, split to get recipient name after<br>@</li><li>Lookup recipient client object by name</li><li>Loop through all connected clients</li><li>Check if sender is<br>muted by this client</li><li>&nbsp; &nbsp; &nbsp; &nbsp;If so, skip sending</li><li>Check if recipient client<br>is in room</li><li>&nbsp;If yes:</li><li>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;Send private message to recipient</li><li>&nbsp;<br>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;Confirm message sent back to sender</li><li>If no:</li><li>&nbsp; &nbsp; &nbsp;<br>&nbsp; &nbsp; &nbsp;Send error to sender that user not found</li><li>Return without broadcasting original<br>message</li></ul></div><div><br></div><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 6: </em> Mute/Unmute </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshots demoing this feature</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fym299%2F2023-11-26T22.26.20image.png.webp?alt=media&token=e663157b-32e4-4e52-b668-3248c0268f59"/></td></tr>
<tr><td> <em>Caption:</em> <p>showing the before and after of using the /mute and /unmute commands in<br>the same room.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fym299%2F2023-11-26T22.55.18image.png.webp?alt=media&token=838a9afb-3970-4d6f-bb9f-6949ef0dc318"/></td></tr>
<tr><td> <em>Caption:</em> <p>showing the user is unable to mute another user in different rooms.<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Add screenshots of the code snippets that achieve this feature</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fym299%2F2023-11-26T23.02.01image.png.webp?alt=media&token=5f599775-3ac6-4d3c-81c0-37055725ac27"/></td></tr>
<tr><td> <em>Caption:</em> <p>created hash Map to track which users have muted which other users<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fym299%2F2023-11-26T23.08.51image.png.webp?alt=media&token=a4a18ec1-1b99-4eb7-a86c-7c7e9ca215d6"/></td></tr>
<tr><td> <em>Caption:</em> <p>Showing /mute and /unmute commands being handled in processCommands() method in Room.java.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fym299%2F2023-11-26T23.10.06image.png.webp?alt=media&token=0b5226c0-2ec8-4df9-a8a6-4342f962dde2"/></td></tr>
<tr><td> <em>Caption:</em> <p>check to see if user is on muted list when sending private messages<br>in sendMessage() when using the @username command in Room.java.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fym299%2F2023-11-26T23.16.58image.png.webp?alt=media&token=32a29dc1-dd04-4261-9212-5a3405bc948d"/></td></tr>
<tr><td> <em>Caption:</em> <p>if user in muted list, skip sending messages to them command. This code<br>is at the end of of after every if statement in sendMessage() method<br>in Room.java.<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain the code logic of how this was achieved</td></tr>
<tr><td> <em>Response:</em> <div>Muting logic</div><div><br></div><div><ul><li>When /mute command is sent, get the target user to mute from<br>the command</li><li>Look up the target user's ID using their name</li><li>Check if the target<br>user is in the same room as the sender</li><li>If yes: Add the target<br>user's ID to a map with key = sender's ID, value = list<br>of muted user IDs</li><li>Send confirmation message to sender</li><li>If no: Send error message that<br>target user is not in the room</li></ul>Unmuting logic</div><div><ul><li>When /unmute command is sent, get<br>the target user to unmute from the command</li><li>Look up the target user's ID<br>using their name</li><li>Check if the sender has the target user muted by looking<br>up the muted users map while in the same room as them</li><li>If found:<br>Remove the target user's ID from the sender's muted list</li><li>Send confirmation message to<br>sender</li><li>If not found: Send error that target user is not muted</li></ul></div><div><br></div><div>Muted messages logic</div><div><ul><li>When<br>user tries to send a private message to another user&nbsp; using @username command<br>that has them muted : skip sending the message.</li><li>else: Check if the sender<br>is in the receiver's muted list<li>If muted: Send error message to sender that<br>they are muted</li><li>Skip sending the actual message</li></li></ul></div><div><br></div><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 7: </em> Misc </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Pull request from milestone3 to main</td></tr>
<tr><td> <a rel="noreferrer noopener" target="_blank" href="https://github.com/Yash4x/ym299-IT114-001-hw/pull/12">https://github.com/Yash4x/ym299-IT114-001-hw/pull/12</a> </td></tr>
</table></td></tr>
<table><tr><td><em>Grading Link: </em><a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-001-F23/it114-chatroom-milestone3/grade/ym299" target="_blank">Grading</a></td></tr></table>
<table><tr><td> <em>Assignment: </em> IT114 Chatroom Milestone4</td></tr>
<tr><td> <em>Student: </em> Yash Mandal (ym299)</td></tr>
<tr><td> <em>Generated: </em> 12/12/2023 4:34:06 PM</td></tr>
<tr><td> <em>Grading Link: </em> <a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-001-F23/it114-chatroom-milestone4/grade/ym299" target="_blank">Grading</a></td></tr></table>
<table><tr><td> <em>Instructions: </em> <p>Implement the features from Milestone3 from the proposal document:&nbsp;&nbsp;<a href="https://docs.google.com/document/d/1ONmvEvel97GTFPGfVwwQC96xSsobbSbk56145XizQG4/view">https://docs.google.com/document/d/1ONmvEvel97GTFPGfVwwQC96xSsobbSbk56145XizQG4/view</a></p>
</td></tr></table>
<table><tr><td> <em>Deliverable 1: </em> Client can export chat history of their current session (client-side) </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshot of related UI</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fym299%2F2023-12-12T20.32.55image.png.webp?alt=media&token=563c27cd-c74d-4f07-8ef6-5c660a74ccb9"/></td></tr>
<tr><td> <em>Caption:</em> <p>showing UI button<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Add screenshot of exported data</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fym299%2F2023-12-12T20.34.29image.png.webp?alt=media&token=c7dc1f4a-7f20-4343-a3b7-1b1f3caa524f"/></td></tr>
<tr><td> <em>Caption:</em> <p>Showing the exported data from the previous screenshot&#39;s conversation<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fym299%2F2023-12-12T20.38.03image.png.webp?alt=media&token=375ad4a8-b2f4-4079-b58c-9870ae3234bb"/></td></tr>
<tr><td> <em>Caption:</em> <p>showing export button variable<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fym299%2F2023-12-12T20.38.41image.png.webp?alt=media&token=c30b5d82-de59-494a-a620-afdb4ecbecc4"/></td></tr>
<tr><td> <em>Caption:</em> <p>showing how export button is triggered<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fym299%2F2023-12-12T20.39.11image.png.webp?alt=media&token=385031d5-3867-4283-bf43-e3db0c1ee9c7"/></td></tr>
<tr><td> <em>Caption:</em> <p>showing exportChatTranscript() method that exports the chat.<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain how you implemented this</td></tr>
<tr><td> <em>Response:</em> <div><ul><li>An export button component is created and added to the client side UI<br>(chatPanel)</li><li>When the export button is clicked, it triggers the exportChatTranscript() method</li><li>The exportChatTranscript() method:</li><li>Creates<br>an HTML file to write the transcript to</li><li>Opens a PrintWriter to write to<br>the file</li><li>Writes opening HTML tags</li><li>Loops through all UI components</li><li>Checks if each component is<br>a chat message pane</li><li>If yes, writes the chat text to the file</li><li>Writes closing<br>HTML tags when done</li><li>Closes the PrintWriter</li><li>Prints out the file location to console</li><li>This allows<br>the user to save a transcript of the chat messages to an HTML<br>file by clicking the export button</li><li>The file contains the chat messages formatted with<br>HTML tags</li></ul></div><div><br></div><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 2: </em> Client's mute list will persist across sessions (server-side) </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add a screenshot of how the mute list is stored</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fym299%2F2023-12-12T20.40.26image.png.webp?alt=media&token=f65ed01f-b9ca-4cb6-8b7e-57b4e0c67ade"/></td></tr>
<tr><td> <em>Caption:</em> <p>showing the file is saved as a CSV file.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fym299%2F2023-12-12T20.41.11image.png.webp?alt=media&token=46b8b7c4-db69-406a-ace9-931052b86c01"/></td></tr>
<tr><td> <em>Caption:</em> <p>showing the contents of the file.<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Add a screenshot of the code saving/loading mute list</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fym299%2F2023-12-12T20.42.55image.png.webp?alt=media&token=e2340025-dc39-4447-a33b-59a22cd2f44a"/></td></tr>
<tr><td> <em>Caption:</em> <p>highlighted: created a mutedUsersByUsername map to simplify the saving and loading of the<br>mute list since I handled mute and unmute commands based on IDs before.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fym299%2F2023-12-12T20.44.36image.png.webp?alt=media&token=78575300-18bb-4452-a63a-e64abb90364d"/></td></tr>
<tr><td> <em>Caption:</em> <p>showing convertMutedUsernameToIds method that converts the mutedUsersByUsername to ids and sets it equal<br>to mutedUsers List that contains those Ids.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fym299%2F2023-12-12T20.46.06image.png.webp?alt=media&token=03e5e5d2-ce7b-4c55-84e0-1a6851112f34"/></td></tr>
<tr><td> <em>Caption:</em> <p>showing readSavedMutedUsersFile that reads the saved muted user file upon client&#39;s initial connection.<br><br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fym299%2F2023-12-12T20.47.25image.png.webp?alt=media&token=5ae57c20-3b95-415e-9e23-c38e8d5b93f5"/></td></tr>
<tr><td> <em>Caption:</em> <p>showing savedMutedUsers method that saves the client&#39;s mutedusers list.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fym299%2F2023-12-12T20.48.11image.png.webp?alt=media&token=d54e64e7-5eb9-42fb-bfeb-67ea34fcafa2"/></td></tr>
<tr><td> <em>Caption:</em> <p>showing convertMutedUsersToUsername method that converts mutedUsers list of IDs to usernames.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fym299%2F2023-12-12T20.49.10image.png.webp?alt=media&token=566b2d03-de8b-4be1-9bb9-771ee9771a02"/></td></tr>
<tr><td> <em>Caption:</em> <p>showing addClient changes: upon user&#39;s initial connection, check to see if they have<br>a file, if yes, read it and convert it to muted user ids.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fym299%2F2023-12-12T20.50.32image.png.webp?alt=media&token=3e89697b-5c3b-401c-8d1e-3314815da73d"/></td></tr>
<tr><td> <em>Caption:</em> <p>showing how mute is handled and file is saved: if a user mutes<br>a client ID, it gets converted to usernames list and saved in a<br>file for that specific client.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fym299%2F2023-12-12T20.51.41image.png.webp?alt=media&token=edd7f645-0165-47ca-bd8f-4f686efe1509"/></td></tr>
<tr><td> <em>Caption:</em> <p>showing how unmute is handled and file is saved: if a user unmutes<br>a client ID, the name corresponding to the ID is removed from the<br>username list and saved in a file for that specific client.<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain how you implemented this</td></tr>
<tr><td> <em>Response:</em> <div><div><div>/mute Command:</div><div><ul><li>When /mute command is sent, get the target username to be muted</li><li>Convert<br>target username to id</li><li>Add the target user id to muting user's muted list</li><li>Send<br>muted confirmation message to muting user and target user</li><li>Convert main muted users map<br>from ids back to usernames</li><li>Save updated muted users to muting user's CSV file</li></ul></div></div><div><br></div><div>/unmute<br>Command:</div><div><ul><li>When /unmute command is sent, get the target username that should be unmuted</li><li>Convert<br>the target username to its id</li><li>Retrieve the muting user's muted list based on<br>their id</li><li>Check if the target user id exists in the muted list</li><li>If yes,<br>remove the target's id from the muted list</li><li>Send unmute confirmation messages to the<br>muting user and previously muted target user</li><li>Convert main muted users map from id<br>back to usernames</li><li>Save updated muted users to muting user's CSV file</li></ul></div></div><div><br></div><div>Saving Muted Users:</div><div><ul><li>Muted<br>users map uses ids which aren't serializable</li><li>So it's converted to a map with<br>usernames for saving</li><li>Map is saved to muting user's CSV file when muted/unmuted</li></ul></div><div>Reading Muted<br>Users:</div><div><ul><li>On login, client's muted users CSV is read if exists</li><li>File is parsed and<br>loaded into muted users map by username</li></ul></div><div>Converting Maps:</div><div><ul><li>Need to convert username map to<br>id map for muting to work</li><li>Helper methods handle conversion between the maps</li><li>Called when<br>loading, muting, and unmuting users</li></ul></div><div><br></div><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 3: </em> Client's will receive a message when they get muted/unmuted by another user </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add a screenshot showing the related chat messages</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fym299%2F2023-12-12T21.18.34image.png.webp?alt=media&token=41ebad76-3270-4583-9cc3-f66c8ef0f6a0"/></td></tr>
<tr><td> <em>Caption:</em> <p>showing the that the muted user is informed that the muting user muted/<br>unmuted them.<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Add a screenshot of the related code snippets</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fym299%2F2023-12-12T21.22.15image.png.webp?alt=media&token=bf015499-6518-4567-a415-0f0d0bc8f935"/></td></tr>
<tr><td> <em>Caption:</em> <p>showing how and when the muted users receives the muted message. Note: I<br>removed possibilities of users being spammed with this feature<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fym299%2F2023-12-12T21.23.18image.png.webp?alt=media&token=f3a85c69-6ec1-4358-8357-61592b70d56a"/></td></tr>
<tr><td> <em>Caption:</em> <p>showing how and when the unmuted users receives the muted message. Note: I<br>removed possibilities of users being spammed with this feature<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain how you implemented this</td></tr>
<tr><td> <em>Response:</em> <div>Muting Messages:</div><div><br></div><div><ul><li>When a user is muted, a message is sent to:</li><li>&nbsp; &nbsp; &nbsp;<br>&nbsp; &nbsp; The muting user confirming the mute</li><li>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; The<br>muted user alerting them</li></ul></div><div>Similarly when unmuted:</div><div><ul><li>Unmuting user gets unmuted confirmation</li><li>Previously muted user told<br>they can now chat</li></ul></div><div>Preventing Spam:</div><div><ul><li>Lists track which client ids have sent and received<br>muted/unmuted messages</li><li>Messages only sent once per user to prevent spamming the notification</li><li>Before broadcasting<br>a sender's message:</li><li>&nbsp; &nbsp; &nbsp; &nbsp;Check if sending user is muted by receiving<br>user</li><li>&nbsp; &nbsp; &nbsp; &nbsp;If yes, do not broadcast message</li></ul></div><div>This achieves:</div><div><ul><li>Confirmation messages to clients<br>when mute status changes</li><li>Ensures clients only notified once per change of state</li><li>Verification before<br>broadcasting to block muted users</li></ul></div><div>So muting notifications are sent only once, while users<br>who mute others do not receive any messages from those muted users.</div><div><br></div><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 4: </em> User list should update per the status of each user </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707834-bf5a5b13-ec36-4597-9741-aa830c195be2.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshot for Muted users by the client should appear grayed out</td></tr>
<tr><td><table><tr><td>Missing Image</td></tr>
<tr><td> <em>Caption:</em> <p>-<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Add screenshot for Last person to send a message gets highlighted</td></tr>
<tr><td><table><tr><td>Missing Image</td></tr>
<tr><td> <em>Caption:</em> <p>-<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain how you implemented this</td></tr>
<tr><td> <em>Response:</em> <p>-<br></p><br></td></tr>
</table></td></tr>
<table><tr><td><em>Grading Link: </em><a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-001-F23/it114-chatroom-milestone4/grade/ym299" target="_blank">Grading</a></td></tr></table>
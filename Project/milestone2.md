<table><tr><td> <em>Assignment: </em> IT114 Chatroom Milestone 2</td></tr>
<tr><td> <em>Student: </em> Yash Mandal (ym299)</td></tr>
<tr><td> <em>Generated: </em> 11/11/2023 3:32:22 PM</td></tr>
<tr><td> <em>Grading Link: </em> <a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-001-F23/it114-chatroom-milestone-2/grade/ym299" target="_blank">Grading</a></td></tr></table>
<table><tr><td> <em>Instructions: </em> <p>Implement the features from Milestone2 from the proposal document:&nbsp; <a href="https://docs.google.com/document/d/1ONmvEvel97GTFPGfVwwQC96xSsobbSbk56145XizQG4/view">https://docs.google.com/document/d/1ONmvEvel97GTFPGfVwwQC96xSsobbSbk56145XizQG4/view</a></p>
</td></tr></table>
<table><tr><td> <em>Deliverable 1: </em> Payload </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Payload Screenshots</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fym299%2F2023-11-11T19.57.30image.png.webp?alt=media&token=0d9fe323-dc93-450c-a64e-a28fa66fb2b3"/></td></tr>
<tr><td> <em>Caption:</em> <p>Showing relevant payload code from Client.java used for chatrooms with comments explaining its<br>general use<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fym299%2F2023-11-11T19.58.49image.png.webp?alt=media&token=e4b1d5b1-ae44-48e2-88f8-3cef61509b05"/></td></tr>
<tr><td> <em>Caption:</em> <p>Showing relevant payload code from Client.java used for chatrooms with comments explaining its<br>general use<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fym299%2F2023-11-11T20.00.05image.png.webp?alt=media&token=e063b5fc-9ac9-498a-b52e-b5fe75a07000"/></td></tr>
<tr><td> <em>Caption:</em> <p>Showing different types of payload content  from the terminal.<br></p>
</td></tr>
</table></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 2: </em> Server-side commands </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Show the code for the mentioned commands</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fym299%2F2023-11-11T20.01.51image.png.webp?alt=media&token=78daebd7-0228-4c03-86aa-8a1f7caf6c6e"/></td></tr>
<tr><td> <em>Caption:</em> <p>Showing the /roll commands inside Room.java under proccessCommands function inside the try block<br>with comments.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fym299%2F2023-11-11T20.03.18image.png.webp?alt=media&token=b2c61c59-0584-439f-9f54-9c8d9868ed59"/></td></tr>
<tr><td> <em>Caption:</em> <p>Showing flip command which is right after roll commands inside Room.java under proccessCommands.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fym299%2F2023-11-11T20.06.23image.png.webp?alt=media&token=b3c32ce9-9cfb-45be-8256-14c3ccd3c611"/></td></tr>
<tr><td> <em>Caption:</em> <p>This code is to format the results of both flip and roll commands<br>by adding the room name where the command happened. This happens inside sendMessage<br>function in room.java. For example: If my name is Yash in the chatroom,<br>and I use /flip in the lobby result would be: Yash: Yash flipped<br>heads in the Lobby. Same thing for the roll command.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fym299%2F2023-11-11T20.29.53image.png.webp?alt=media&token=fdd2b21e-02ee-4dbd-846d-114239648502"/></td></tr>
<tr><td> <em>Caption:</em> <p>showing three different roll outputs.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fym299%2F2023-11-11T20.30.52image.png.webp?alt=media&token=7bcf190d-b71e-40ee-a05f-958c9077a328"/></td></tr>
<tr><td> <em>Caption:</em> <p>showing two different flip outputs<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Explain the logic/implementation of each commands</td></tr>
<tr><td> <em>Response:</em> <div>/roll</div><div><br></div><div>This first checks the format of the /roll command to determine how to<br>handle it. There are two supported formats:</div><div><br></div><div>/roll xdY</div><div><ul><li>This will roll x number of<br>dice with Y sides each.</li><li>It splits the input on "d" into two parts,<br>parses them to ints</li><li>Loops x times, generating a random int from 1 to<br>Y</li><li>Sums all the rolls and sends the total</li></ul></div><div><br></div><div>/roll X</div><div><ul><li>This will generate a random<br>int from 1 to X</li><li>Parses X to an int</li><li>Generates random int from 1<br>to X</li><li>Sends the single roll value</li><li>If invalid format, it sends an error message.</li></ul></div><div><br></div><div>/flip</div><div><ul><li>Generates<br>a random 0 or 1</li><li>If 0, result is "heads"</li><li>If 1, result is "tails"</li><li>Sends<br>back the flip result</li></ul><div>/flip and /roll result format in sendMessage() inside Room.java explaination:</div></div><div><br></div><div><ul><li>By<br>default, when the result is broadcasted for both commands flip and roll, the<br>result would look like this: username: username flipped heads/ rolled x.</li><li>I wanted to<br>change to username: username flipped heads/ rolled x in room "roomName."</li><li>I added a<br>unique message with special characters at the end of each string result for<br>roll and flip and send it to send message.</li><li>Inside sendMessage, an if command<br>checks if the message has the certain unique message pertaining to roll or<br>flip.</li><li>if yes, it replaces that with the room name.</li></ul></div><div><br></div><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 3: </em> Text Display </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Show the code for the various style handling via markdown or special characters</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fym299%2F2023-11-11T20.13.35image.png.webp?alt=media&token=81d35449-b78f-4a82-a816-80644fbfca02"/></td></tr>
<tr><td> <em>Caption:</em> <p>code shown for the various style handling via special characters inside function formatText.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fym299%2F2023-11-11T20.14.34image.png.webp?alt=media&token=3d94325f-d20e-4ed3-b266-8474a4dbf892"/></td></tr>
<tr><td> <em>Caption:</em> <p>code shown that handles formatted messages by calling on function formatText() before being<br>sent.<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Show source message and the result output in the terminal (note, you won't actually see the styles until Milestone3)</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fym299%2F2023-11-11T20.22.54image.png.webp?alt=media&token=eb521b0d-d708-4e90-8294-7dd8fbbf64b9"/></td></tr>
<tr><td> <em>Caption:</em> <p>Showing all examples in the terminal with input highlighted as yellow and output<br>highlighted as green.<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Explain how you got each style applied</td></tr>
<tr><td> <em>Response:</em> <div>Bold:</div><div><ul><li>formatted = text.replaceAll("\(.+?)\", "&lt;b&gt;$1&lt;/b&gt;");</li><li>\(.+?)\ is a regex that looks for text</li><li>The (.+?) captures<br>the text between the *'s into group $1</li><li>The replaceAll puts &lt;b&gt; and &lt;/b&gt;<br>tags around the captured text to make it bold</li></ul></div><div><br></div><div>Italics:</div><div><ul><li>formatted = formatted.replaceAll("-(.+?)-", "&lt;i&gt;$1&lt;/i&gt;");</li><li>Same concept<br>but with -text- and &lt;i&gt; &lt;/i&gt; tags</li></ul></div><div><br></div><div>Color:</div><div><ul><li>formatted = formatted.replaceAll("#([a-z])(.+?)#\1", "&lt;font color=$1&gt;$2&lt;/font&gt;");</li><li>#(char)(text)#(char) The regex<br>matches opening and closing color tags with the same code (e.g. #r...#r), captures<br>the color code and text in between, and replaces with font tags using<br>the captured code and text.</li><li>Example: #r text r# means wrap text in red<br>font. Result for now: &lt;font color=red&gt;text&lt;/font&gt;</li><li>$1 captures the color code character</li><li>$2 captures the<br>text</li><li>Replace with &lt;font color=$1&gt;$2&lt;/font&gt;</li></ul></div><div><br></div><div>Underline:</div><div><ul><li>formatted = formatted.replaceAll("(.+?)", "&lt;u&gt;$1&lt;/u&gt;");</li><li>Same idea as bold/italics but with text<br>and &lt;u&gt; &lt;/u&gt;</li></ul></div><div><br></div><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 4: </em> Misc </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Include the pull request for Milestone2 to main</td></tr>
<tr><td> <a rel="noreferrer noopener" target="_blank" href="https://github.com/Yash4x/ym299-IT114-001-hw/pull/10">https://github.com/Yash4x/ym299-IT114-001-hw/pull/10</a> </td></tr>
</table></td></tr>
<table><tr><td><em>Grading Link: </em><a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-001-F23/it114-chatroom-milestone-2/grade/ym299" target="_blank">Grading</a></td></tr></table>
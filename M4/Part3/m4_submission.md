<table><tr><td> <em>Assignment: </em> IT114 - Sockets Part 1 - 3</td></tr>
<tr><td> <em>Student: </em> Yash Mandal (ym299)</td></tr>
<tr><td> <em>Generated: </em> 10/15/2023 2:22:14 PM</td></tr>
<tr><td> <em>Grading Link: </em> <a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-001-F23/it114-sockets-part-1-3/grade/ym299" target="_blank">Grading</a></td></tr></table>
<table><tr><td> <em>Instructions: </em> <ol><li>Create a new branch for this assignment</li><li>Go through the socket lessons and get each part implemented (parts 1-3)</li><ol><li>You'll probably want to put them into their own separate folders/packages (i.e., Part1, Part2, Part3) These are for your reference</li><li>Part 3, below, is what's necessary for this HW</li><li><a href="https://github.com/MattToegel/IT114/tree/Module4/Module4/Part3">https://github.com/MattToegel/IT114/tree/Module4/Module4/Part3</a><br></li></ol><li>Create a new folder called Part3HW</li><li>Create an empty m4_submission.md file in Part3HW (or skip this step and download the file at the end)</li><ol><li>Add/commit/push the branch</li><li>Create a pull request to main and keep it open</li></ol><li>Copy the the Part3 code into this new folder (Part3HW)</li><li>Git add/commit all of the sample code and the Part3HW code</li><li>Implement <b>two </b>of the following <b>server-side</b> activities for all connected clients (majority of the logic should be processed server-side and broadcasted/sent to all clients if/when applicable)</li><ol><li>Simple number guesser where all clients can attempt to guess while the game is active</li><ol><li>Have a start command that activates the game allowing guesses to be interpreted</li><li>Have a stop command that deactivates the game, guesses will be treated as regular messages</li><li>Have a guess command that include a value that is processed to see if it matches the hidden number (i.e., <i>guess 5</i>)</li><ol><li>Guess should only be considered when the game is active</li><li>The response should include who guessed, what they guessed, and whether or not it was correct (i.e., Bob guessed 5 but it was not correct)</li></ol><li>No need to implement complexities like strikes</li></ol><li>Coin toss command (random heads or tails)</li><ol><li>Command should be something logical like flip or toss or coin or similar</li><li>The result should mention <i>who</i>&nbsp;did <i>what</i>&nbsp;and got what <i>result</i>&nbsp;(i.e., Bob Flipped a coin and got heads)</li></ol><li>Dice roller given a command and text format of "roll #d#" (i.e., roll 2d6)</li><ol><li>Command should be in the format of roll #d# (i.e., roll 1d10)</li><li>The result should mention&nbsp;<i>who</i>&nbsp;did&nbsp;<i>what</i>&nbsp;and got what&nbsp;<i>result</i>&nbsp;(i.e., Bob rolled 1d10 and got 7)</li></ol><li>Math game (server outputs a basic equation, first person to guess it correctly gets congratulated and a new equation is given)</li><ol><li>Have a start command that activates the game allowing equaiton to be answered</li><li>Have a stop command that deactivates the game, answers will be treated as regular messages</li><li>Have an answer command that include a value that is processed to see if it matches the hidden number (i.e.,&nbsp;<i>answer 15</i>)<br></li><ol><li>The response should include who answered, what they answered, and whether or not it was correct (i.e., Bob answered 5 but it was not correct)</li></ol></ol><li>Private message (a client can send a message targetting another client where only the two can see the messages)</li><ol><li>Command can be pm, dm or an @ preceding the users name (clearly note which)</li><li>The server should properly check the target audience and send the response to the original sender and to the receiver</li><li>Alternatively (make note if you do this and show evidence) you can add support to private message multiple people at once. Evidence should show a larger number of clients than the target list of the private message to show it works. Note to grader: if this is accomplished add 0.5 to total final grade on Canvas.</li></ol><li>Message shuffler (randomizes the order of the characters of the given message)</li><ol><li>Command should be shuffle or randomize (clearly mention what you chose)</li><li>The message should be sent to all clients showing it's from the user but randomized</li><ol><li>Example: Bob types <i>command</i>&nbsp;hello and everyone recevies Bob: lleho</li></ol></ol></ol><li>Fill in the below deliverables</li><li>Save and generated the markdown or markdown file</li><li>Update the m4_submission.md file in the Part3HW folder</li><li>Add/commit/push your changes</li><li>Merge the pull request</li><li>From the M4-Sockets branch, navigate to your m4_submission.md file on github and copy the link</li><li>Submit the direct link to Canvas</li></ol></td></tr></table>
<table><tr><td> <em>Deliverable 1: </em> Baseline </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add as many screenshots as necessary to show basic communication among 3 clients and 1 server</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fym299%2F2023-10-15T17.47.26image.png.webp?alt=media&token=426bcfd5-debe-433f-8fe2-a209fa02078c"/></td></tr>
<tr><td> <em>Caption:</em> <p>Showing Server with three connected clients and that all clients receive all the<br>messages that were sent when all were connected.<br></p>
</td></tr>
</table></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 2: </em> Feature Implementation 1 </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> What feature did you pick? Briefly explain how you implemented it</td></tr>
<tr><td> <em>Response:</em> <p>First implementation: Implemented&nbsp;Coin toss command (random heads or tails):<div><ol><li class="whitespace-normal" index="0" style="box-sizing: border-box;<br>border: 0px solid rgb(229, 231, 235); --tw-border-spacing-x: 0; --tw-border-spacing-y: 0; --tw-translate-x: 0; --tw-translate-y:<br>0; --tw-rotate: 0; --tw-skew-x: 0; --tw-skew-y: 0; --tw-scale-x: 1; --tw-scale-y: 1; --tw-pan-x: ;<br>--tw-pan-y: ; --tw-pinch-zoom: ; --tw-scroll-snap-strictness: proximity; --tw-gradient-from-position: ; --tw-gradient-via-position: ; --tw-gradient-to-position: ; --tw-ordinal:<br>; --tw-slashed-zero: ; --tw-numeric-figure: ; --tw-numeric-spacing: ; --tw-numeric-fraction: ; --tw-ring-inset: ; --tw-ring-offset-width: 0px;<br>--tw-ring-offset-color: #fff; --tw-ring-color: rgba(59,130,246,.5); --tw-ring-offset-shadow: 0 0 #0000; --tw-ring-shadow: 0 0 #0000; --tw-shadow:<br>0 0 #0000; --tw-shadow-colored: 0 0 #0000; --tw-blur: ; --tw-brightness: ; --tw-contrast: ;<br>--tw-grayscale: ; --tw-hue-rotate: ; --tw-invert: ; --tw-saturate: ; --tw-sepia: ; --tw-drop-shadow: ; --tw-backdrop-blur:<br>; --tw-backdrop-brightness: ; --tw-backdrop-contrast: ; --tw-backdrop-grayscale: ; --tw-backdrop-hue-rotate: ; --tw-backdrop-invert: ; --tw-backdrop-opacity: ;<br>--tw-backdrop-saturate: ; --tw-backdrop-sepia: ;">Added a Random instance variable to generate random numbers</li>&lt;li class=&quot;whitespace-normal&quot;<br>index=&quot;1&quot; style=&quot;box-sizing: border-box; border: 0px solid rgb(229, 231, 235); --tw-border-spacing-x: 0; --tw-border-spacing-y: 0;<br>--tw-translate-x: 0; --tw-translate-y: 0; --tw-rotate: 0; --tw-skew-x: 0; --tw-skew-y: 0; --tw-scale-x: 1; --tw-scale-y:<br>1; --tw-pan-x: ; --tw-pan-y: ; --tw-pinch-zoom: ; --tw-scroll-snap-strictness: proximity; --tw-gradient-from-position: ; --tw-gradient-via-position: ;<br>--tw-gradient-to-position: ; --tw-ordinal: ; --tw-slashed-zero: ; --tw-numeric-figure: ; --tw-numeric-spacing: ; --tw-numeric-fraction: ; --tw-ring-inset:<br>; --tw-ring-offset-width: 0px; --tw-ring-offset-color: #fff; --tw-ring-color: rgba(59,130,246,.5); --tw-ring-offset-shadow: 0 0 #0000; --tw-ring-shadow: 0<br>0 #0000; --tw-shadow: 0 0 #0000; --tw-shadow-colored: 0 0 #0000; --tw-blur: ; --tw-brightness:<br>; --tw-contrast: ; --tw-grayscale: ; --tw-hue-rotate: ; --tw-invert: ; --tw-saturate: ; --tw-sepia: ;<br>--tw-drop-shadow: ; --tw-backdrop-blur: ; --tw-backdrop-brightness: ; --tw-backdrop-contrast: ; --tw-backdrop-grayscale: ; --tw-backdrop-hue-rotate: ; --tw-backdrop-invert:<br>; --tw-backdrop-opacity: ; --tw-backdrop-saturate: ; --tw-backdrop-sepia: ; --tw-space-y-reverse: 0; margin-top: calc(.5rem * calc(1<br>- var(--tw-space-y-reverse))); margin-bottom: calc(.5rem * var(--tw-space-y-reverse));&quot;&gt;In the processCommand() method, checked if the message<br>was &quot;flip&quot; or &quot;toss&quot;</li><li class="whitespace-normal" index="2" style="box-sizing: border-box; border: 0px solid rgb(229, 231,<br>235); --tw-border-spacing-x: 0; --tw-border-spacing-y: 0; --tw-translate-x: 0; --tw-translate-y: 0; --tw-rotate: 0; --tw-skew-x: 0;<br>--tw-skew-y: 0; --tw-scale-x: 1; --tw-scale-y: 1; --tw-pan-x: ; --tw-pan-y: ; --tw-pinch-zoom: ; --tw-scroll-snap-strictness:<br>proximity; --tw-gradient-from-position: ; --tw-gradient-via-position: ; --tw-gradient-to-position: ; --tw-ordinal: ; --tw-slashed-zero: ; --tw-numeric-figure: ;<br>--tw-numeric-spacing: ; --tw-numeric-fraction: ; --tw-ring-inset: ; --tw-ring-offset-width: 0px; --tw-ring-offset-color: #fff; --tw-ring-color: rgba(59,130,246,.5); --tw-ring-offset-shadow:<br>0 0 #0000; --tw-ring-shadow: 0 0 #0000; --tw-shadow: 0 0 #0000; --tw-shadow-colored: 0<br>0 #0000; --tw-blur: ; --tw-brightness: ; --tw-contrast: ; --tw-grayscale: ; --tw-hue-rotate: ; --tw-invert:<br>; --tw-saturate: ; --tw-sepia: ; --tw-drop-shadow: ; --tw-backdrop-blur: ; --tw-backdrop-brightness: ; --tw-backdrop-contrast: ;<br>--tw-backdrop-grayscale: ; --tw-backdrop-hue-rotate: ; --tw-backdrop-invert: ; --tw-backdrop-opacity: ; --tw-backdrop-saturate: ; --tw-backdrop-sepia: ; --tw-space-y-reverse:<br>0; margin-top: calc(.5rem * calc(1 - var(--tw-space-y-reverse))); margin-bottom: calc(.5rem * var(--tw-space-y-reverse));">If so, used<br>the Random to generate a random boolean (true or false) to represent heads<br>or tails</li><li class="whitespace-normal" index="3" style="box-sizing: border-box; border: 0px solid rgb(229, 231, 235); --tw-border-spacing-x:<br>0; --tw-border-spacing-y: 0; --tw-translate-x: 0; --tw-translate-y: 0; --tw-rotate: 0; --tw-skew-x: 0; --tw-skew-y: 0;<br>--tw-scale-x: 1; --tw-scale-y: 1; --tw-pan-x: ; --tw-pan-y: ; --tw-pinch-zoom: ; --tw-scroll-snap-strictness: proximity; --tw-gradient-from-position:<br>; --tw-gradient-via-position: ; --tw-gradient-to-position: ; --tw-ordinal: ; --tw-slashed-zero: ; --tw-numeric-figure: ; --tw-numeric-spacing: ;<br>--tw-numeric-fraction: ; --tw-ring-inset: ; --tw-ring-offset-width: 0px; --tw-ring-offset-color: #fff; --tw-ring-color: rgba(59,130,246,.5); --tw-ring-offset-shadow: 0 0<br>#0000; --tw-ring-shadow: 0 0 #0000; --tw-shadow: 0 0 #0000; --tw-shadow-colored: 0 0 #0000;<br>--tw-blur: ; --tw-brightness: ; --tw-contrast: ; --tw-grayscale: ; --tw-hue-rotate: ; --tw-invert: ; --tw-saturate:<br>; --tw-sepia: ; --tw-drop-shadow: ; --tw-backdrop-blur: ; --tw-backdrop-brightness: ; --tw-backdrop-contrast: ; --tw-backdrop-grayscale: ;<br>--tw-backdrop-hue-rotate: ; --tw-backdrop-invert: ; --tw-backdrop-opacity: ; --tw-backdrop-saturate: ; --tw-backdrop-sepia: ; --tw-space-y-reverse: 0; margin-top:<br>calc(.5rem * calc(1 - var(--tw-space-y-reverse))); margin-bottom: calc(.5rem * var(--tw-space-y-reverse));">Formatted a string with the<br>result that includes the user id and heads/tails</li><li class="whitespace-normal" index="4" style="box-sizing: border-box; border:<br>0px solid rgb(229, 231, 235); --tw-border-spacing-x: 0; --tw-border-spacing-y: 0; --tw-translate-x: 0; --tw-translate-y: 0;<br>--tw-rotate: 0; --tw-skew-x: 0; --tw-skew-y: 0; --tw-scale-x: 1; --tw-scale-y: 1; --tw-pan-x: ; --tw-pan-y:<br>; --tw-pinch-zoom: ; --tw-scroll-snap-strictness: proximity; --tw-gradient-from-position: ; --tw-gradient-via-position: ; --tw-gradient-to-position: ; --tw-ordinal: ;<br>--tw-slashed-zero: ; --tw-numeric-figure: ; --tw-numeric-spacing: ; --tw-numeric-fraction: ; --tw-ring-inset: ; --tw-ring-offset-width: 0px; --tw-ring-offset-color:<br>#fff; --tw-ring-color: rgba(59,130,246,.5); --tw-ring-offset-shadow: 0 0 #0000; --tw-ring-shadow: 0 0 #0000; --tw-shadow: 0<br>0 #0000; --tw-shadow-colored: 0 0 #0000; --tw-blur: ; --tw-brightness: ; --tw-contrast: ; --tw-grayscale:<br>; --tw-hue-rotate: ; --tw-invert: ; --tw-saturate: ; --tw-sepia: ; --tw-drop-shadow: ; --tw-backdrop-blur: ;<br>--tw-backdrop-brightness: ; --tw-backdrop-contrast: ; --tw-backdrop-grayscale: ; --tw-backdrop-hue-rotate: ; --tw-backdrop-invert: ; --tw-backdrop-opacity: ; --tw-backdrop-saturate:<br>; --tw-backdrop-sepia: ; --tw-space-y-reverse: 0; margin-top: calc(.5rem * calc(1 - var(--tw-space-y-reverse))); margin-bottom: calc(.5rem<br>* var(--tw-space-y-reverse));">Called broadcast() to send this coin flip result string to all connected<br>clients</li><li class="whitespace-normal" index="5" style="box-sizing: border-box; border: 0px solid rgb(229, 231, 235); --tw-border-spacing-x: 0;<br>--tw-border-spacing-y: 0; --tw-translate-x: 0; --tw-translate-y: 0; --tw-rotate: 0; --tw-skew-x: 0; --tw-skew-y: 0; --tw-scale-x:<br>1; --tw-scale-y: 1; --tw-pan-x: ; --tw-pan-y: ; --tw-pinch-zoom: ; --tw-scroll-snap-strictness: proximity; --tw-gradient-from-position: ;<br>--tw-gradient-via-position: ; --tw-gradient-to-position: ; --tw-ordinal: ; --tw-slashed-zero: ; --tw-numeric-figure: ; --tw-numeric-spacing: ; --tw-numeric-fraction:<br>; --tw-ring-inset: ; --tw-ring-offset-width: 0px; --tw-ring-offset-color: #fff; --tw-ring-color: rgba(59,130,246,.5); --tw-ring-offset-shadow: 0 0 #0000;<br>--tw-ring-shadow: 0 0 #0000; --tw-shadow: 0 0 #0000; --tw-shadow-colored: 0 0 #0000; --tw-blur:<br>; --tw-brightness: ; --tw-contrast: ; --tw-grayscale: ; --tw-hue-rotate: ; --tw-invert: ; --tw-saturate: ;<br>--tw-sepia: ; --tw-drop-shadow: ; --tw-backdrop-blur: ; --tw-backdrop-brightness: ; --tw-backdrop-contrast: ; --tw-backdrop-grayscale: ; --tw-backdrop-hue-rotate:<br>; --tw-backdrop-invert: ; --tw-backdrop-opacity: ; --tw-backdrop-saturate: ; --tw-backdrop-sepia: ; --tw-space-y-reverse: 0; margin-top: calc(.5rem<br>* calc(1 - var(--tw-space-y-reverse))); margin-bottom: calc(.5rem * var(--tw-space-y-reverse));">Returned true to indicate the command<br>was handled</li></ol></div><br></p><br></td></tr>
<tr><td> <em>Sub-Task 2: </em> Add screenshot(s) showing the implemented feature working</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fym299%2F2023-10-15T17.53.01image.png.webp?alt=media&token=3fca02de-6cf8-4c71-8570-4544188dd896"/></td></tr>
<tr><td> <em>Caption:</em> <p>showing the the addition of a private random variable to generate random numbers<br>in the beginning of the server class.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fym299%2F2023-10-15T17.57.50image.png.webp?alt=media&token=662f92ff-5063-4a69-b6f4-c956123dd707"/></td></tr>
<tr><td> <em>Caption:</em> <p>Showing output of the coin toss implementation.<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Add screenshot(s) of related code changes to highlight the new logic</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fym299%2F2023-10-15T18.00.35image.png.webp?alt=media&token=dde32337-9013-400d-b564-421f80c79b44"/></td></tr>
<tr><td> <em>Caption:</em> <p>Highlighted portion in the screenshot shows the implementation of the coin toss feature<br>which checks for the command &quot;flip&quot; or &quot;toss,&quot; flips a coin,  broadcasts<br>result to all clients and showing the outputs.<br></p>
</td></tr>
</table></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 3: </em> Feature Implementation 2 </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> What feature did you pick? Briefly explain how you implemented it</td></tr>
<tr><td> <em>Response:</em> <p>Second implementation: Dice roller given a command and text format of &quot;roll #d#.&quot;<div><ol>&lt;li<br>class=&quot;whitespace-normal&quot; index=&quot;0&quot; style=&quot;box-sizing: border-box; border: 0px solid rgb(229, 231, 235); --tw-border-spacing-x: 0; --tw-border-spacing-y:<br>0; --tw-translate-x: 0; --tw-translate-y: 0; --tw-rotate: 0; --tw-skew-x: 0; --tw-skew-y: 0; --tw-scale-x: 1;<br>--tw-scale-y: 1; --tw-pan-x: ; --tw-pan-y: ; --tw-pinch-zoom: ; --tw-scroll-snap-strictness: proximity; --tw-gradient-from-position: ; --tw-gradient-via-position:<br>; --tw-gradient-to-position: ; --tw-ordinal: ; --tw-slashed-zero: ; --tw-numeric-figure: ; --tw-numeric-spacing: ; --tw-numeric-fraction: ;<br>--tw-ring-inset: ; --tw-ring-offset-width: 0px; --tw-ring-offset-color: #fff; --tw-ring-color: rgba(59,130,246,.5); --tw-ring-offset-shadow: 0 0 #0000; --tw-ring-shadow:<br>0 0 #0000; --tw-shadow: 0 0 #0000; --tw-shadow-colored: 0 0 #0000; --tw-blur: ;<br>--tw-brightness: ; --tw-contrast: ; --tw-grayscale: ; --tw-hue-rotate: ; --tw-invert: ; --tw-saturate: ; --tw-sepia:<br>; --tw-drop-shadow: ; --tw-backdrop-blur: ; --tw-backdrop-brightness: ; --tw-backdrop-contrast: ; --tw-backdrop-grayscale: ; --tw-backdrop-hue-rotate: ;<br>--tw-backdrop-invert: ; --tw-backdrop-opacity: ; --tw-backdrop-saturate: ; --tw-backdrop-sepia: ;&quot;&gt;In processCommand(), check if the message<br>matches the &quot;roll #d#&quot; pattern using regex (which I found from a lot<br>of trial and error and online help.)</li><li class="whitespace-normal" index="1" style="box-sizing: border-box; border: 0px<br>solid rgb(229, 231, 235); --tw-border-spacing-x: 0; --tw-border-spacing-y: 0; --tw-translate-x: 0; --tw-translate-y: 0; --tw-rotate:<br>0; --tw-skew-x: 0; --tw-skew-y: 0; --tw-scale-x: 1; --tw-scale-y: 1; --tw-pan-x: ; --tw-pan-y: ;<br>--tw-pinch-zoom: ; --tw-scroll-snap-strictness: proximity; --tw-gradient-from-position: ; --tw-gradient-via-position: ; --tw-gradient-to-position: ; --tw-ordinal: ; --tw-slashed-zero:<br>; --tw-numeric-figure: ; --tw-numeric-spacing: ; --tw-numeric-fraction: ; --tw-ring-inset: ; --tw-ring-offset-width: 0px; --tw-ring-offset-color: #fff;<br>--tw-ring-color: rgba(59,130,246,.5); --tw-ring-offset-shadow: 0 0 #0000; --tw-ring-shadow: 0 0 #0000; --tw-shadow: 0 0<br>#0000; --tw-shadow-colored: 0 0 #0000; --tw-blur: ; --tw-brightness: ; --tw-contrast: ; --tw-grayscale: ;<br>--tw-hue-rotate: ; --tw-invert: ; --tw-saturate: ; --tw-sepia: ; --tw-drop-shadow: ; --tw-backdrop-blur: ; --tw-backdrop-brightness:<br>; --tw-backdrop-contrast: ; --tw-backdrop-grayscale: ; --tw-backdrop-hue-rotate: ; --tw-backdrop-invert: ; --tw-backdrop-opacity: ; --tw-backdrop-saturate: ;<br>--tw-backdrop-sepia: ; --tw-space-y-reverse: 0; margin-top: calc(.5rem * calc(1 - var(--tw-space-y-reverse))); margin-bottom: calc(.5rem *<br>var(--tw-space-y-reverse));">If so, split the message on space to get the full command</li>&lt;li class=&quot;whitespace-normal&quot;<br>index=&quot;2&quot; style=&quot;box-sizing: border-box; border: 0px solid rgb(229, 231, 235); --tw-border-spacing-x: 0; --tw-border-spacing-y: 0;<br>--tw-translate-x: 0; --tw-translate-y: 0; --tw-rotate: 0; --tw-skew-x: 0; --tw-skew-y: 0; --tw-scale-x: 1; --tw-scale-y:<br>1; --tw-pan-x: ; --tw-pan-y: ; --tw-pinch-zoom: ; --tw-scroll-snap-strictness: proximity; --tw-gradient-from-position: ; --tw-gradient-via-position: ;<br>--tw-gradient-to-position: ; --tw-ordinal: ; --tw-slashed-zero: ; --tw-numeric-figure: ; --tw-numeric-spacing: ; --tw-numeric-fraction: ; --tw-ring-inset:<br>; --tw-ring-offset-width: 0px; --tw-ring-offset-color: #fff; --tw-ring-color: rgba(59,130,246,.5); --tw-ring-offset-shadow: 0 0 #0000; --tw-ring-shadow: 0<br>0 #0000; --tw-shadow: 0 0 #0000; --tw-shadow-colored: 0 0 #0000; --tw-blur: ; --tw-brightness:<br>; --tw-contrast: ; --tw-grayscale: ; --tw-hue-rotate: ; --tw-invert: ; --tw-saturate: ; --tw-sepia: ;<br>--tw-drop-shadow: ; --tw-backdrop-blur: ; --tw-backdrop-brightness: ; --tw-backdrop-contrast: ; --tw-backdrop-grayscale: ; --tw-backdrop-hue-rotate: ; --tw-backdrop-invert:<br>; --tw-backdrop-opacity: ; --tw-backdrop-saturate: ; --tw-backdrop-sepia: ; --tw-space-y-reverse: 0; margin-top: calc(.5rem * calc(1<br>- var(--tw-space-y-reverse))); margin-bottom: calc(.5rem * var(--tw-space-y-reverse));&quot;&gt;Parseint out the # of dice and #<br>of sides from the command string</li><li class="whitespace-normal" index="3" style="box-sizing: border-box; border: 0px solid<br>rgb(229, 231, 235); --tw-border-spacing-x: 0; --tw-border-spacing-y: 0; --tw-translate-x: 0; --tw-translate-y: 0; --tw-rotate: 0;<br>--tw-skew-x: 0; --tw-skew-y: 0; --tw-scale-x: 1; --tw-scale-y: 1; --tw-pan-x: ; --tw-pan-y: ; --tw-pinch-zoom:<br>; --tw-scroll-snap-strictness: proximity; --tw-gradient-from-position: ; --tw-gradient-via-position: ; --tw-gradient-to-position: ; --tw-ordinal: ; --tw-slashed-zero: ;<br>--tw-numeric-figure: ; --tw-numeric-spacing: ; --tw-numeric-fraction: ; --tw-ring-inset: ; --tw-ring-offset-width: 0px; --tw-ring-offset-color: #fff; --tw-ring-color:<br>rgba(59,130,246,.5); --tw-ring-offset-shadow: 0 0 #0000; --tw-ring-shadow: 0 0 #0000; --tw-shadow: 0 0 #0000;<br>--tw-shadow-colored: 0 0 #0000; --tw-blur: ; --tw-brightness: ; --tw-contrast: ; --tw-grayscale: ; --tw-hue-rotate:<br>; --tw-invert: ; --tw-saturate: ; --tw-sepia: ; --tw-drop-shadow: ; --tw-backdrop-blur: ; --tw-backdrop-brightness: ;<br>--tw-backdrop-contrast: ; --tw-backdrop-grayscale: ; --tw-backdrop-hue-rotate: ; --tw-backdrop-invert: ; --tw-backdrop-opacity: ; --tw-backdrop-saturate: ; --tw-backdrop-sepia:<br>; --tw-space-y-reverse: 0; margin-top: calc(.5rem * calc(1 - var(--tw-space-y-reverse))); margin-bottom: calc(.5rem * var(--tw-space-y-reverse));">Loop<br>for the # of dice, generating a random number from 1 to #<br>sides for each die</li><li class="whitespace-normal" index="4" style="box-sizing: border-box; border: 0px solid rgb(229, 231,<br>235); --tw-border-spacing-x: 0; --tw-border-spacing-y: 0; --tw-translate-x: 0; --tw-translate-y: 0; --tw-rotate: 0; --tw-skew-x: 0;<br>--tw-skew-y: 0; --tw-scale-x: 1; --tw-scale-y: 1; --tw-pan-x: ; --tw-pan-y: ; --tw-pinch-zoom: ; --tw-scroll-snap-strictness:<br>proximity; --tw-gradient-from-position: ; --tw-gradient-via-position: ; --tw-gradient-to-position: ; --tw-ordinal: ; --tw-slashed-zero: ; --tw-numeric-figure: ;<br>--tw-numeric-spacing: ; --tw-numeric-fraction: ; --tw-ring-inset: ; --tw-ring-offset-width: 0px; --tw-ring-offset-color: #fff; --tw-ring-color: rgba(59,130,246,.5); --tw-ring-offset-shadow:<br>0 0 #0000; --tw-ring-shadow: 0 0 #0000; --tw-shadow: 0 0 #0000; --tw-shadow-colored: 0<br>0 #0000; --tw-blur: ; --tw-brightness: ; --tw-contrast: ; --tw-grayscale: ; --tw-hue-rotate: ; --tw-invert:<br>; --tw-saturate: ; --tw-sepia: ; --tw-drop-shadow: ; --tw-backdrop-blur: ; --tw-backdrop-brightness: ; --tw-backdrop-contrast: ;<br>--tw-backdrop-grayscale: ; --tw-backdrop-hue-rotate: ; --tw-backdrop-invert: ; --tw-backdrop-opacity: ; --tw-backdrop-saturate: ; --tw-backdrop-sepia: ; --tw-space-y-reverse:<br>0; margin-top: calc(.5rem * calc(1 - var(--tw-space-y-reverse))); margin-bottom: calc(.5rem * var(--tw-space-y-reverse));">Sum all the<br>dice rolls</li><li class="whitespace-normal" index="5" style="box-sizing: border-box; border: 0px solid rgb(229, 231, 235); --tw-border-spacing-x:<br>0; --tw-border-spacing-y: 0; --tw-translate-x: 0; --tw-translate-y: 0; --tw-rotate: 0; --tw-skew-x: 0; --tw-skew-y: 0;<br>--tw-scale-x: 1; --tw-scale-y: 1; --tw-pan-x: ; --tw-pan-y: ; --tw-pinch-zoom: ; --tw-scroll-snap-strictness: proximity; --tw-gradient-from-position:<br>; --tw-gradient-via-position: ; --tw-gradient-to-position: ; --tw-ordinal: ; --tw-slashed-zero: ; --tw-numeric-figure: ; --tw-numeric-spacing: ;<br>--tw-numeric-fraction: ; --tw-ring-inset: ; --tw-ring-offset-width: 0px; --tw-ring-offset-color: #fff; --tw-ring-color: rgba(59,130,246,.5); --tw-ring-offset-shadow: 0 0<br>#0000; --tw-ring-shadow: 0 0 #0000; --tw-shadow: 0 0 #0000; --tw-shadow-colored: 0 0 #0000;<br>--tw-blur: ; --tw-brightness: ; --tw-contrast: ; --tw-grayscale: ; --tw-hue-rotate: ; --tw-invert: ; --tw-saturate:<br>; --tw-sepia: ; --tw-drop-shadow: ; --tw-backdrop-blur: ; --tw-backdrop-brightness: ; --tw-backdrop-contrast: ; --tw-backdrop-grayscale: ;<br>--tw-backdrop-hue-rotate: ; --tw-backdrop-invert: ; --tw-backdrop-opacity: ; --tw-backdrop-saturate: ; --tw-backdrop-sepia: ; --tw-space-y-reverse: 0; margin-top:<br>calc(.5rem * calc(1 - var(--tw-space-y-reverse))); margin-bottom: calc(.5rem * var(--tw-space-y-reverse));">Format a string with the<br>dice roll command, total, and clientId</li><li class="whitespace-normal" index="6" style="box-sizing: border-box; border: 0px solid<br>rgb(229, 231, 235); --tw-border-spacing-x: 0; --tw-border-spacing-y: 0; --tw-translate-x: 0; --tw-translate-y: 0; --tw-rotate: 0;<br>--tw-skew-x: 0; --tw-skew-y: 0; --tw-scale-x: 1; --tw-scale-y: 1; --tw-pan-x: ; --tw-pan-y: ; --tw-pinch-zoom:<br>; --tw-scroll-snap-strictness: proximity; --tw-gradient-from-position: ; --tw-gradient-via-position: ; --tw-gradient-to-position: ; --tw-ordinal: ; --tw-slashed-zero: ;<br>--tw-numeric-figure: ; --tw-numeric-spacing: ; --tw-numeric-fraction: ; --tw-ring-inset: ; --tw-ring-offset-width: 0px; --tw-ring-offset-color: #fff; --tw-ring-color:<br>rgba(59,130,246,.5); --tw-ring-offset-shadow: 0 0 #0000; --tw-ring-shadow: 0 0 #0000; --tw-shadow: 0 0 #0000;<br>--tw-shadow-colored: 0 0 #0000; --tw-blur: ; --tw-brightness: ; --tw-contrast: ; --tw-grayscale: ; --tw-hue-rotate:<br>; --tw-invert: ; --tw-saturate: ; --tw-sepia: ; --tw-drop-shadow: ; --tw-backdrop-blur: ; --tw-backdrop-brightness: ;<br>--tw-backdrop-contrast: ; --tw-backdrop-grayscale: ; --tw-backdrop-hue-rotate: ; --tw-backdrop-invert: ; --tw-backdrop-opacity: ; --tw-backdrop-saturate: ; --tw-backdrop-sepia:<br>; --tw-space-y-reverse: 0; margin-top: calc(.5rem * calc(1 - var(--tw-space-y-reverse))); margin-bottom: calc(.5rem * var(--tw-space-y-reverse));">Call<br>broadcast() to send result string to all clients</li><li class="whitespace-normal" index="7" style="box-sizing: border-box; border:<br>0px solid rgb(229, 231, 235); --tw-border-spacing-x: 0; --tw-border-spacing-y: 0; --tw-translate-x: 0; --tw-translate-y: 0;<br>--tw-rotate: 0; --tw-skew-x: 0; --tw-skew-y: 0; --tw-scale-x: 1; --tw-scale-y: 1; --tw-pan-x: ; --tw-pan-y:<br>; --tw-pinch-zoom: ; --tw-scroll-snap-strictness: proximity; --tw-gradient-from-position: ; --tw-gradient-via-position: ; --tw-gradient-to-position: ; --tw-ordinal: ;<br>--tw-slashed-zero: ; --tw-numeric-figure: ; --tw-numeric-spacing: ; --tw-numeric-fraction: ; --tw-ring-inset: ; --tw-ring-offset-width: 0px; --tw-ring-offset-color:<br>#fff; --tw-ring-color: rgba(59,130,246,.5); --tw-ring-offset-shadow: 0 0 #0000; --tw-ring-shadow: 0 0 #0000; --tw-shadow: 0<br>0 #0000; --tw-shadow-colored: 0 0 #0000; --tw-blur: ; --tw-brightness: ; --tw-contrast: ; --tw-grayscale:<br>; --tw-hue-rotate: ; --tw-invert: ; --tw-saturate: ; --tw-sepia: ; --tw-drop-shadow: ; --tw-backdrop-blur: ;<br>--tw-backdrop-brightness: ; --tw-backdrop-contrast: ; --tw-backdrop-grayscale: ; --tw-backdrop-hue-rotate: ; --tw-backdrop-invert: ; --tw-backdrop-opacity: ; --tw-backdrop-saturate:<br>; --tw-backdrop-sepia: ; --tw-space-y-reverse: 0; margin-top: calc(.5rem * calc(1 - var(--tw-space-y-reverse))); margin-bottom: calc(.5rem<br>* var(--tw-space-y-reverse));">Return true to indicate command handled</li></ol></div><br></p><br></td></tr>
<tr><td> <em>Sub-Task 2: </em> Add screenshot(s) showing the implemented feature working</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fym299%2F2023-10-15T18.08.07image.png.webp?alt=media&token=e29d3c32-e6f6-48ac-94f0-001908f61bdf"/></td></tr>
<tr><td> <em>Caption:</em> <p>Showing outputs for rolling dice for all clients<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Add screenshot(s) of related code changes to highlight the new logic</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://firebasestorage.googleapis.com/v0/b/learn-e1de9.appspot.com/o/assignments%2Fym299%2F2023-10-15T18.14.58image.png.webp?alt=media&token=227ae597-1435-4f9b-9fc3-ab1dd0ba11ac"/></td></tr>
<tr><td> <em>Caption:</em> <p>Highlighted portion in the screenshot shows the implementation of the dice roll feature<br>which checks for the command roll #d# using regex, rolls the # of<br>die with # of faces,  broadcasts result to all clients and showing<br>the outputs.<br></p>
</td></tr>
</table></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 4: </em> Misc </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Did you have an issues and how did you resolve them? If no issues, what did you learn during this assignment that you found interesting?</td></tr>
<tr><td> <em>Response:</em> <p>Biggest hurdle for me this class was regex for the dice roll implementation<br>which I resolved looking up some videos about basic regex videos, and asking<br>for regex related help from my dad as he is a database analyst<br>and programmer.<br></p><br></td></tr>
<tr><td> <em>Sub-Task 2: </em> Pull request link</td></tr>
<tr><td> <a rel="noreferrer noopener" target="_blank" href="https://github.com/Yash4x/ym299-IT114-001-hw/pull/7">https://github.com/Yash4x/ym299-IT114-001-hw/pull/7</a> </td></tr>
</table></td></tr>
<table><tr><td><em>Grading Link: </em><a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-001-F23/it114-sockets-part-1-3/grade/ym299" target="_blank">Grading</a></td></tr></table>
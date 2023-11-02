

I had trouble setting up connections of classes to maven, hence I coded everything in the Play class,
sorry for the mess!

Class Definition: The main class is named Play, which represents the game itself. 
The class contains various fields, methods, and data structures to manage the game's state and flow.

Game Logic: The code implements the game logic, including checking for a win, loss, or draw. 
It also handles the player's and computer's turns, tracks selected squares, and ensures that players make valid moves.
Data Structures: The code uses arrays and lists to store information about available squares,
selected squares by the player and computer, and combinations that lead to a win. 
It includes methods for removing elements from arrays, checking for valid input, and identifying win conditions.
Main Method: The main method is the entry point of the program.
 It initializes a Play object to start the game, which then enters an infinite loop to allow players to take turns.
Player and Computer Turns: The code handles player turns and computer AI turns. 
It includes logic to make informed decisions for the computer's moves, 
such as blocking the player from winning or making the best possible move.

Determining the Winner: It checks for a win, loss, or draw after each player's move and terminates the game accordingly.
In the case of a draw, it provides the option to restart the game.
Code Organization: The code uses methods to segment and organize different parts of the game logic. 
This promotes modularity and readability.

Improvements: The code could benefit from additional comments and documentation to clarify its functionality and purpose. 
Additionally, user input validation and game restart 
options have been commented out and can be further developed to enhance the user experience.
Possible Bugs: There is a commented-out call to computerTurn();
 in the playerTurn method, which might lead to issues during the game's flow. 
Uncommenting this line could enable the computer to take its turn.

Overal, I implemented the computer best available square to pays, labeled AI section in the code,
the user and computer controlled move system, enabling them to play only to available squares,
improved user interface and its restrictions. 

I tried to achieve all the requirement of the task for a competitive computer player, however as mentioned above
some bugs may come out, as my code has some as I was forced to use some unconventional in some functions of the 
computer decision making, for instance I was constantly bombard by index errors I could not solve line 298 Play.java,
so I have to find I value that prevents the bug, but limit the computer decision making.  

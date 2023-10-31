/*
 * Play.java
 *
 * Play a game of noughts and crosses
 * includes main method
 */
 
 package noughts;

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.lang.*;


class Play{

     // all combinations that leads to a win
    public static int[][] win_variations = {
    {1,4,7},//array1
    {7,8,9},//array2
    {3,6,9},//array3 
    {1,2,3},//array4 
    {1,5,9},//array5
    {7,5,3},//array6
    {2,5,8},//array7
    {4,5,6},//array8 
    };


    // used to store available squares to play
    public int[] MoveControl = {1,2,3,4,5,6,7,8,9};

    //To store selected squares in the box by player and computer
    public static int[] player_squares = {0,0,0,0,0};
    public static int[] computer_squares={0,0,0,0,0};

    int countMovesP =0;
    int countMovesC =0;



    
    // Restricts the movements of to each position(numbers) by removing in from the MoveControl array
    public static int[] removeFromMoveControl(int[] array, int squareToRemove) 
    {
    int newSize = array.length - 1;  // Calculate the new size of the array without the element to be removed
    int[] newArray = new int[newSize];// Create a new array with the new size

    // Copy all elements from the original array to the new array, except the one to be removed
    int newIndex = 0;
    for (int i = 0; i < array.length; i++) {
        if (array[i] != squareToRemove) {
            newArray[newIndex] = array[i];
            newIndex++;
        }
    }
    return newArray;
    }



    // Checks if position is illigal to play( avalable or not)
    public static boolean containsNumber(int[] MoveControl, int square) {
        for (int num : MoveControl) {
            if (num == square) {
                return true; // The number is found in the ArrayLis
            }
        }
        return false; // The number is not found in the array
    }


    // Checks if the game was won using stored player and pc selected quares comparig against win_variations 
    public static boolean checksIfWon(int[] check_arr) {  // passes the player and pc selected squares arrays
        for (int i = 0; i < win_variations.length; i++) {
            boolean containsAll = true;
            for (int j = 0; j < win_variations[i].length; j++) {
                boolean found = false;
                for (int k = 0; k < check_arr.length; k++) {
                    if (check_arr[k] == win_variations[i][j]) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    containsAll = false;
                    break;
                }
            }
            if (containsAll) {
                return true; // If the passed array contains all elements of an array in win_variations, return true.
            }
        }
        return false; // the passed array does not contain all elements of any of the arrays in the win_variations.
    }





    Game game;   // the noughts and crosses game
    Scanner input;
        public static void main(String[] args) {
            // main method - just create a Play object
            new Play();
            
        }

        public Play () {
            // constructor
            game = new Game();  // create game board
            input = new Scanner(System.in);  // Scanner for user input

            System.out.println("Welcome to noughts and crosses"); 
            
            while (true) { // infinite loop
                determineWinner();
                game.printBoard(); // print board
                playerTurn(); // human turn
                computerTurn(); // computer turn
                
            }
        }








    public void playerTurn()  {


        // Player turn: just read in a square and claim it for human
        System.out.print("Take a square (1-9): ");
                // Reading data using readLine
        int square = input.nextInt();
        System.out.println(" ");
        
        if (square >= 10 || square == 0) {
            System.out.println("INVALID MOVE, please select a number from 1 to 9");
            playerTurn();

        }
        if(containsNumber(MoveControl,square)){
            game.setHuman(square);
            
            MoveControl = removeFromMoveControl(MoveControl,square);
            player_squares[countMovesP] = square;
            countMovesP++;
            

        }//else if(){}
        else{
            System.out.println("Please enter a valid move, position " + square + " is already taken");
            playerTurn();
            
        } 
        
    }

    public void computerTurn() {

        // computer turn - currently does nothing other than print out a message
        System.out.println("Computer is thinking... \n");
 
        //Reading Computer move
        

        // Generate a random index from MoveControl and passes its value to square
        Random rand = new Random();
        if (MoveControl.length == 0){
            return;
        }else{
            int square = MoveControl[ (int) Math.random()*MoveControl.length];
            if(containsNumber(MoveControl,square)){
                //System.out.println(square);
                game.setComputer(square);
                
                MoveControl = removeFromMoveControl(MoveControl,square);
                computer_squares[countMovesC] = square;
                countMovesC++;
            }
        }
        
            


        
    }



    public void determineWinner(){
        //checking if won
        Scanner scanner = new Scanner(System.in);
        if (checksIfWon(player_squares)) {
            game.printBoard(); 
            System.out.println("You Win");
            System.exit(0);
            
        }
        // Loss
        if (checksIfWon(computer_squares)) {
            game.printBoard(); 
            System.out.println("You Lost");
            System.exit(0);
        }
        // Draw
        else if(player_squares[4] != 0 || computer_squares[4]!=0){
            game.printBoard(); 
            System.out.println("We've got a draw");
            System.exit(0);
            

            /*System.out.print("\n Do You want to play again? Enter y or n: ");
            String response = scanner.nextLine();
            if(response.equals("y") || response.equals("Y")){
                System.out.println("Start a new game");
                new Game();
                new Play();
            }else{ System.exit(0);}
        */

        }

        





    }


}
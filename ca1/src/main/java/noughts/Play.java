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


class Play{

    public int[] MoveControl = {1,2,3,4,5,6,7,8,9};

    
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

    Game game;   // the noughts and crosses game
    Scanner input;
        public static void main(String[] args) {
            // main method - just create a Play object
            new Play();

            
        }

        public Play () {
            // constructor
            System.out.println("Welcome to noughts and crosses"); 
            game = new Game();  // create game board
            input = new Scanner(System.in);  // Scanner for user input
            while (true) { // infinite loop
                game.printBoard(); // print board
                playerTurn(); // human turn
                computerTurn(); // computer tuen
        }
    }
    public void playerTurn()  {

        // Player turn: just read in a sqaure and claim it for human
        System.out.print("Take a square (1-9): ");
                // Reading data using readLine
        int square = input.nextInt();
        
        if (square >= 10 || square == 0) {
            System.out.println("INVALID MOVE, please select a number from 1 to 9");

        }
        if(containsNumber(MoveControl,square)){
            game.setHuman(square);
            MoveControl = removeFromMoveControl(MoveControl,square);
            

            for(int i=0; i<MoveControl.length; i++){
            System.out.println("array: "+MoveControl[i]);
            }


        }//else if(){}
        else{
            System.out.println("Please enter a valid move, position " + square + " is already taken");
        }
        
        
    }

    public void computerTurn() {

        // computer turn - currently does nothing other than print out a message
        System.out.println("Computer is thinking");
 
        //Reading Computer move
        

        // Generate a random index from MoveControl and passes its value to square
        Random rand = new Random();
        int square = MoveControl[ (int) Math.random()*MoveControl.length];
        if(containsNumber(MoveControl,square)){
            System.out.println(square);
            game.setComputer(square);
            MoveControl = removeFromMoveControl(MoveControl,square);

        }else{
            System.out.println(square);
            System.out.println("INVALID");
        }
    
        
        

    }
}
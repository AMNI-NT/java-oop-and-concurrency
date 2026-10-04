package q1;

import java.util.Scanner;

/**
 * This class represents the game Bull Pgia where the player has to guess a 
 * randomly generated 4 digit number (digits are distinct). 
 * 
 * For any number the player guesses, a Pgia is counted for every digit in the 
 * guessed number which also appears in the wanted number, 
 * and a Bull is counted for any digit which appears in both the guessed and the
 * wanted number in the same place.
 * 
 * When the game ends player is asked whether to play again or not
 * 
 * @author Amit Nissenbaum
 */
public class Q1{ 
	
    // Length of a valid input 
    final static int INPUT_LENGTH = 4;
    
    // Unicode of digits 1 and 9 
    final static int DIGIT_0_UNICODE = '0';
    final static int DIGIT_9_UNICODE = '9';
    
    // string representing yes for player input
    final static String YES = "y";
    
    // string representing no for player input
    final static String NO = "n";
    
    /**
     * This is the main method of the game. This method contains the game loop
     * which continues as long as the player has not guessed the correct number,
     * and displays number of Bulls and Pgias for every guess. Also number of 
     * guesses is counted (invalid input is not counted as a guess).
     * When the correct number is guessed correctly the player is asked whether 
     * to play again.
     * 
     * @param args 
     */
    public static void main(String[] args) { 

        //creat new object in GameLogic class
        GameLogic game = new GameLogic();

        //Create boolean that updates to true when game has ended and not restarted
        boolean endGame = false;

        // Creat an int array where the output will be stored (number of Bulls and
        // Pgias for every guess)
        int[] output;

        // creates a new string for the player to save given input
        String input;      
        
        // creates counter to check number of guesses
        int guessCounter = 0;
        
        // Game loop. As long as player has not guessed the correct number - loop continues.
        // When game ends player chooses whether to play again or end game.
        while (!endGame){

            // input number from player, playAgain input mode is set to false
            input = playerInput(false);
            
            // raise guess count
            guessCounter++;

            // Call GameLogic method that checks number of Bulls and Pgias, and 
            // save in an int array output
            output = game.checkBullsAndPgias(input);

            // output saved number of Bulls and Pgias
            System.out.println(output[GameLogic.CELL_CONTAINING_BULLS_COUNT] + " Bulls, and " + 
                    output[GameLogic.CELL_CONTAINING_PGIAS_COUNT] + " Pgias\n");

            // check whether player has guessed correctly (4 bulls) 
            if (output[GameLogic.CELL_CONTAINING_BULLS_COUNT] == INPUT_LENGTH){

                // player has guessed correctly, 
                System.out.println("YOU GUESSED CORRETLY!\n" + 
                    "NUMBER OF GUESSES IS " + guessCounter + 
                    "\n\nPlay again? ("+ YES +" - for yes, "+ NO + " - for no)");
                
                // take input from player, set to playAgain input mode
                input = playerInput(true);

                // did player choose to play again? (input "y")
                if (input.equals(YES)){
                    
                    // generate new number for the player to guess
                    GameLogic.generateNewWantedNumber();
                    
                    // set guess counter to zero
                    guessCounter = 0;
                    
                    System.out.println("\nNEW GAME");
                }
                else {
                    // Change endGame boolean to true so that game loop ends
                    endGame = true;
                }
            }
        }
    }
        
    /**
     * If input mode is asking player to choose whether to play again 
     * (playAgainInput is set to true) then player is asked to input y or n 
     * until a valid value is given. 
     * 
     * Otherwise (playAgainInput is set to false) takes the user's input and 
     * asks player the enter a valid input as long as an invalid input is given. 
     * An invalid is one where one of the characters is not a digit, 
     * the length of the input is not 4, or there is a repeated character.
     * 
     * @param playAgainInput represents whether we are in input mode in which
     *   player is asked whether to play again or not
     * @return input the input given from the player. Returned only if valid
     */
    public static String playerInput(boolean playAgainInput){

        // Creat a new scanner object
        Scanner scanner = new Scanner(System.in);

        // create new string to store player's input 
        String input = "";
       
        //Create boolean to check whether input is valid
        boolean isValid = false;
        
        // if current input mode is asking player to choose whether to play again
        if (playAgainInput){
            
            while(!isValid){
                // take player input
                input = scanner.nextLine();

                // is input valid?
                if (!YES.equals(input) && !NO.equals(input)){

                    // input is not valid. Display massage 
                    System.out.println(" - for no)" + "\nInput is not valid.\nplease choose" +
                            YES +" - for yes, "+ NO + " - for no");
                }

                // if input is valid return value
                else return input;
            }     
        }

        // Create a new char array to copy the player's input into
        char[] copyInput;
        
        // Asks player to input number until it is valid (4 digits, only
        // numerical values and no repeats)
        while (!isValid){

            // input number from player 
            input = scanner.nextLine();

            // copy input to another string which will be changed
            copyInput = input.toCharArray();

            // set isValid to true
            isValid = true; 

            // if input's length isn't 4 set isValid to false
            if (input.length() != INPUT_LENGTH){
                isValid = false;
            } 

            // goes over every character and checks whether it is not a 
            // number or is repeated
            for (int i = 0; i < INPUT_LENGTH && isValid == true; i++){

                // check if input's i-th character is a digit 
                // (1 to nine are unicode 49 to 57) if not, 
                // set isValid to false
                if ( copyInput[i] < DIGIT_0_UNICODE || copyInput[i] > DIGIT_9_UNICODE){
                    isValid = false; 
                }

                // check for repeated characters
                for (int j=i+1; j < INPUT_LENGTH && isValid == true; j++){

                    // if there is another number in copyInput which is the 
                    // same as in index i, we have found a repeated
                    // character and isValid is set to false
                    if (copyInput[i] == copyInput[j]){
                        isValid = false;
                    }
                }  
            }

            // if input is invalid ask player for a valid input
            if (isValid == false){
                System.out.println("Please enter a valid input\n");
            } 
        }

        // returns input 
        return input;

    }
}

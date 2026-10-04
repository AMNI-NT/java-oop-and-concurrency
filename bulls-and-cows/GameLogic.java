package q1;

import java.util.Random;

/**
 * This class represents the game's logic and contains the number the player has
 * to guess (wantedNum) 
 * @author Amit Nissenbaum
 */
public class GameLogic {
    
    // the number player needs to guess 
    public static String wantedNum;
    
    // length of both generated number and input length
    final static int NUMBER_LENGTH = 4;
    
    // Represents the cell numbers in the counter for Bulls and Pgias where 
    // each is stored
    final static int CELL_CONTAINING_BULLS_COUNT = 0;
    final static int CELL_CONTAINING_PGIAS_COUNT = 1;

    
    /**
     * Constructor of the game logic class. 
     * Calls generateNewWantedNumber so that a new wanted number is generated  
     */
    public GameLogic(){
        
        // generates and stores in wantedNum a new four distinct digit number
        generateNewWantedNumber();        
    }
    
    /**
     * This method generates and stores in wantedNum a new four distinct digit 
     * number, as a string value.
     * Uses randomizeFourDigitNumber to randomize a string representation of a
     * four digit number, to be the number the user has to guess.
     */
    public static void generateNewWantedNumber(){
        
        // wantedNum is set to the input string
        wantedNum = randomizeFourDigitNumber();   
    }
    
    /**
     * This method randomizes a four distinct digits and returns them 
     * represented in as a string value
     * 
     * @return String.valueOf(digits) the four digits stored in a char array 
     *  converted to string value
     */
    public static String randomizeFourDigitNumber(){
        
        // Create a new char array to contain digits 
        char[] digits = new char[4];
        
        // Create a new Random object
        Random rnd = new Random();
                
        // creates new boolean to check if randomized digit is distict
        boolean isDigitDistinct;
        
        // randomized 4 distict digits which are stored in digits array
        for (int i=0; i<NUMBER_LENGTH; i++){
            
            // set is digit distinct to false
            isDigitDistinct = false;

            // randomizes a new digit until a distinct one is found
            while (!isDigitDistinct){
                  
                // generates a new digit between 0 and 9 and adds char value of
                // '0' to convert it to the correct unicode. Afterwards the
                // int value is converted to char and stored in digits[i]
                digits[i] = (char) (rnd.nextInt(9) + '0');
                                
                // checks if generated char already exists in digits array
                for (int j=0; j<=i; j++){
                    
                    // all digits have been checked to be different from the 
                    // new one. Setting isDigitDistinct to true
                    if(i==j)isDigitDistinct = true;
                    
                    // if we have found another digit which is the same as the 
                    // the new one, it is not distinct and the loop breaks 
                    // without changing isDigitDistinct value
                    else if (digits[j] == digits[i]) break;
                }
            }        
        }
        
        // returns string value of char array "digits"
        return String.valueOf(digits);
    }
    
    /**
     * Checks for number of Bulls and Pgias in the given input, and then stores them in an array which is returned.
     * First cell in this array contains number of Bulls and second cell contains Pgias.
     * @param input 
     * @return countBP The array that contains number of Bulls and Pgias in given input 
     */
    public int[] checkBullsAndPgias(String input){
        
        // counter for bulls and pgias is initiated (first cell for Bulls and second for Pgias)
        int[] countBP = {0,0};
        
        // for every character in input count Bulls and Pgias
        for (int i=0; i<NUMBER_LENGTH; i++){
            
            // does the wanted number contain i-th character of input?
           if (input.contains(String.valueOf(wantedNum.charAt(i)))){
               
               // count as a Pgia
               countBP[CELL_CONTAINING_PGIAS_COUNT]++;
               
               // is the i-th character of input and output the same?
               if (wantedNum.charAt(i) == input.charAt(i)){
                   
                   // count as a Bull
                   countBP[CELL_CONTAINING_BULLS_COUNT]++;
               }    
           }
        }
        
        // returns the counted values
        return countBP;           
    }
    
    
}

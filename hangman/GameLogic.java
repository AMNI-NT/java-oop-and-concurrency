
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import javafx.stage.FileChooser;
import javax.swing.JOptionPane;

/**
 * This class represents the logic for Hanged Man game
 * @author Amit
 */
public class GameLogic {
    
    private final Character[] FULL_ABC_CHARS = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
       'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
       'Y', 'Z'};
    
    // list of remaining characters to guess from
    private Character [] remainingChars;
    
    // contains chars guessed so far
    private ArrayList<Character> guessedChars;
    
    // contains array of words to guess
    private ArrayList<String> words;
    
    // contains current word
    private String currentWord = "NETBEANS";
    
    // contains guessed word (current word with _ replacing chars not yet guessed)
    private char[] guessedWord;
    
    // contains remaining tries
    private int remainingTries;
    
    /** 
     * constructor for a new GameLogic object. 
     */
    public GameLogic(){       
       // initialize guessed chars to empty
        guessedChars = new ArrayList<>();
        
        // initialize words list 
        words = new ArrayList<>();
        loadFromFile();
    }
    
    /**
     * Initializes variables in order to start a new game
     */
    public final void newGame(){
        
        //initialize remaining chars
        remainingChars = Arrays.copyOf(FULL_ABC_CHARS, FULL_ABC_CHARS.length);

        // set remaining tries initial number
        remainingTries = 7;         

        //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
        guessedChars.clear();
        
        // saves word from list to current word, and deletes it from list
        saveAndRemoveRandomWord();
        
        //initialize char list representing the guessed word with only guessed
        // chars visible to empty (filled with '_')
        guessedWord = new char[currentWord.length()];
        for(int i=0; i<guessedWord.length; i++){guessedWord[i]='_';}
    }
       
    /** 
     * 
     * @return remaining chars to guess Character array form
     */
    public Character[] getRemainingChars(){return remainingChars;}
    
    /** 
     * 
     * @return remaining tries 
     */
    public int getRemainingTries(){return remainingTries;}
    
    /** 
     * 
     * @return guessed word (current word with _ replacing chars not yet guessed)
     */
    public String getGuessedWord(){return String.valueOf(guessedWord);}

    /**
     * This method check if given character c is in current word, 
     * and updates guessed characters array, remaining tries counter and deletes
     * it from remaining characters. 
     * 
     * @param c given char
     * @return true if given character is in current word
     */
    public boolean checkChar(Character c){
                
        // delete current char from remaining characters array
        deleteCurrentChar(c);
        
        // if current char is contained in given word, add it to list of guessed
        // words, update guessed word and return true
        if (currentWord.contains(Character.toString(c))){  
            this.guessedChars.add(c);
            this.updateGuessedWord();
            return true;
        }
        
        // current char is not contains in current word. Therefore:
                
        // decrease remaining tries 
        remainingTries--;

        //return false
        return false;
    }
    
    /**
     * Opens openJPane for player to choose whether to play another game or no, 
     * or when there are no more words to guess and application is exited
     * @return true if player chose to play again 
     */
    public boolean openJPane(){
         
        // if there are still words in word list
        if(!words.isEmpty()){
            
            // ask player whether to play again
            int reply = JOptionPane.showConfirmDialog(null, "Do you want to play again?"
            , "", JOptionPane.YES_NO_OPTION);
            
            // if yes state a new game has started and return true
            if (reply == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, "NEW GAME");
                return true;

            // otherwise exit game
            } else {
                System.exit(0);
                
            }         
        }
        
        // word list is emty. The player is notified and game is closed
        else{
            int reply = JOptionPane.showConfirmDialog(null, "There are no more words to guess"
            , "", JOptionPane.DEFAULT_OPTION);
            System.exit(0); 
        }
        
        return false;
    }
    
    /**
     * This method shows user where the text file that stores the words is stored and it's name
     */
    public void showTextFileLocationAndName(){
        JOptionPane.showConfirmDialog(null, "The text file that stores the"
                + " words for this game is located at: text/words.txt"
            , "", JOptionPane.DEFAULT_OPTION);
    }

    
    /** 
     * Checks if player has won
     * 
     * @return 1 if player has guessed the word, -1 if player has not guessed the
     * word and has no remaining tries and 0 if none of the above
     */
    public int winCheck(){
        
        // if guessed word is equal to current word then the player has won, and
        // integer 1 is returned
        if (String.valueOf(guessedWord).equals(currentWord)){return 1;}
        
        // if player has no more tries left then player has lost, and -1 is returned
        else if(remainingTries == 0 ) return -1;
        
        // otherwise return 0
        return 0;
    }
    /** 
     * Updates the char list representation of the guessed word (the current word
     * with only the guessed letters)
     * 
     */   
    private void updateGuessedWord(){
        
        // contains currently scanned char
        char currentChar;
        
        // contains last guessed char
        char lastGuessedChar = (char)guessedChars.get(guessedChars.size() - 1);
        
        // fills in every time the last guessed char shows up in current word, 
        // in guessed word
        for(int i=0; i<currentWord.length(); i++){
            
            // save currentl char
            currentChar = currentWord.charAt(i);

            // if current word contains guessed char in this index change guessed word 
            // in this index to guessed char
            if(currentChar == lastGuessedChar){           
                guessedWord[i] = currentChar;
            }
        }
    }
    
    /**
     * retrieves random word out of word list, saves it in currentWord and deletes it
     * from words list so that is won't be 
     */
    private void saveAndRemoveRandomWord(){
        
        // creates new random object
        Random rnd = new Random();
        
        // randomize an index in word list 
        int randomIndex = rnd.nextInt(words.size());
        
        // saves word in randomized index to currentWord
        currentWord = words.get(randomIndex);
        
        // removes this word from list
        words.remove(randomIndex);
    }
   
    /** 
     * deletes currently chosen character form remaining character list so that 
     * it won't be chosen again
     * @param c character to delete
     */
    private void deleteCurrentChar(Character c){
        
        // search selected char in remaining chars array and replace it with *
        for(int i=0; i<remainingChars.length; i++){  
            if (remainingChars[i] == c){
                remainingChars[i] = '*';
            }
        }
    }
   
    /**
     * Copies words from words text file to words array list
     */
    private void loadFromFile(){
            try {
                
                // create scanner to wrap words.txt file
                Scanner s = new Scanner(new File("text/words.txt"));

                // load all words from file to words array list
                while(s.hasNext()){
                    words.add(s.next());
                }
                
                // close scanner
                s.close();
                
            } catch (IOException e) {
                System.out.println("Error");
           
            } catch (NullPointerException e){
                System.out.println("NullPointerException caught");
            }
    }    
}

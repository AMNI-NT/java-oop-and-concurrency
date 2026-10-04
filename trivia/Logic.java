
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * This class represents the logic for trivia game
 * @author Amit
 */
public class Logic {
    
    // contains an array list of String arrays, each representing one Questionnaire, 
    ArrayList<String[]> qList;
    
    private final int QUESTIONNAIRE_LENGTH = 5;
    
    /** 
     * This is the constructor for logic class for trivia game
     */
    public Logic(){

        // initializes Array list qList 
        qList = new ArrayList<>(); 
        
        // initializes game 
        this.newGame();
    }
    
    /**
     * This method deletes a random String array representing a questionnaire, 
     * and returns a copy of it. 
     * @return a copy of a random String array representing a questionnaire
     */
    public String[] getRandomQuestionnaire(){
        
        // creates new random object
        Random random = new Random();
        
        // generate random integer pointing to object in qList
        int randomInt = random.nextInt(qList.size());
        
        // save string array at generated random index 
        String[] s = Arrays.copyOf(qList.get(randomInt), QUESTIONNAIRE_LENGTH);
        
        // remove this string array 
        qList.remove(randomInt);
        
        // return 
        return s;
    }
    
    /**
     * This method shows user where the text file that stores the questions and
     * answers is stored and it's name
     */
    public void showTextFileLocationAndName(){
        JOptionPane.showConfirmDialog(null, "The text file that stores the"
                + " questions and answers is located at: text/trivia.txt"
            , "", JOptionPane.DEFAULT_OPTION);
    }
    
    /**
     * 
     * @return true if qList has unused questions
     */
    public boolean listHasAnotherQuestionnnaire(){
        return !qList.isEmpty();
    }
    
    /**
     * This method creates a new game
     */
    public final void newGame(){
        
        // clear q
        qList.clear();
        
        // copy file to qList
        readFile();
    }
    
    /**
     * This method shuffles button answer map, which contains numbers from 1 
     * to 4.
     * @return shuffled button answer map
     */
    public int[] getRandomMap(){
        
        // initial map to be shuffled
        int[] buttonAnswerMap = {1, 2, 3, 4};
        
        Random rnd = new Random();
        
        // stores randomly generated number
        int randomTemp;
        
        // stores value in cell of buttonAnswerMap before switch
        int temp;
        
        for(int i = buttonAnswerMap.length - 1; i > 1; i--){
            // generates number integer from 0 to i
            randomTemp = rnd.nextInt(i + 1);
            
            // switch value in i-th cell and randomTemp-th cell of buttonAnswerMap
            temp = buttonAnswerMap[i];
            buttonAnswerMap[i]=buttonAnswerMap[randomTemp];
            buttonAnswerMap[randomTemp] = temp;              
        }
        
        // return shuffeled map
        return buttonAnswerMap;
    }  
    
    /**
     * 
     * @param answer given answer
     * @return true if answer is correct (equals to 1)
     */
    public boolean checkAnswer(int answer){return (answer==1);}
    
    /**
     * This method read trivia.txt file and saves it's contents in array list, 
     * qList.
     */
    private void readFile(){
        try {
            
            // indicates whether current string group is a question or an 
            // answer and which answer
            int mode = 0;
            
            // stores words from trivia.txt to be proccessed
            String[] s;
            
            // create scanner object and wrap around trivia text file
            Scanner input = new Scanner(new File("text/trivia.txt"));
            
            while(input.hasNextLine()){
                // creates new questionnaire if mode is set to question mode
                if(mode == 0) qList.add(new String[5]);       
                
                //save in s current 
                s = qList.get(qList.size()-1);
                
                // save next line of text to s[mode]
                s[mode] = input.nextLine();
                
                // update qList 
                qList.set(qList.size()-1, s);
                
                // if we have reached the last question, set mode to question mode
                if(mode == 4){mode = 0;}
                
                // other wise set mode to next question
                else mode++;
            }
        } catch (IOException e) {
            System.out.println("error");
        }
    }
}



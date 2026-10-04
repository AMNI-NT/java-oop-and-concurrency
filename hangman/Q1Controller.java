import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


/**
 * This class is the controller for the game Hanged Man.
 * @author Amit
 */
public class Q1Controller {
    
    private final int CANVAS_WIDTH = 600;
    
    private final int CANVAS_HEIGHT = 350;
    
    private final int HANGED_MANS_HEAD_RADIUS = 25;
    
    private final int HANGED_MANS_BODY_WIDTH = 30;
    
    private final int HANGED_MANS_BODY_HEIGHT = 50;
    
    // Contains boolean value of whether game is over
    boolean isGameOver;
   
    GameLogic g = new GameLogic();
    
    private GraphicsContext gc;

    @FXML
    private ComboBox<Character> cmbb;

    @FXML
    private Button btn;

    @FXML
    private Canvas canv;

    @FXML
    private Text txt;
    
    /**
     * Initializes the controller for Hanged Man, and starts a new game
     */
    @FXML
    public void initialize(){
        
        gc = canv.getGraphicsContext2D();
        
        // show where text file containing words for game is located and it's name
        g.showTextFileLocationAndName();
        
        // Initializes parameters for gc to draw with
        gc.setFont(Font.font("Monospaced", 20));
        
        txt.setFont(Font.font("Monospaced", 15));

        gc.setFill(Color.BLACK);
        
        gc.setLineWidth(5);
        
        gc.fillRect(10, 10, 10, 10);
        
        // starts new game
        this.newGame();
    }
    
    /**
     * When button is clicked GameLogic class is called to check
     * game status and hanged man, number of tries remaining and
     * guessed word are drawn to the screen. 
     * @param event 
     */
    @FXML
    void buttonClicked(ActionEvent event) {
        
        // if game is not over
        if(!isGameOver){
            
            // save last character guessed in c
            Character c = cmbb.getValue();
 
            // if current char is valid (not '*') check game current status and display 
            // it to the player
            if(!c.equals('*')){
                
                // sets current selected value in combo box to '*'
                cmbb.setValue('*');

                // Contains value of whether c is in the word
                boolean isCharInWord = g.checkChar(c);

                // contains 1 if player has won, -1 if player has lost and 0 otherwise
                int winValue = g.winCheck();

                // update combo box to remaining items
                cmbb.getItems().setAll(g.getRemainingChars());
                
                if(isCharInWord) displayGuessedWord();
                else drawHangedMan();

                // updates canvas
                //updateCanvas();       

                // display text indicating whether the player has won, number of guesses, 
                // and if last guessed char was in the word or not
                displayText(c, isCharInWord, winValue);

                // if player has won or lost set isGameOver value to true, and
                // change button text to exit this game
                 if(winValue == 1 || winValue == -1){
                    btn.setText("EXIT THIS GAME");
                    isGameOver = true;
                 }

            } 

            // ask player to choose different character, because player has chosen *
            else txt.setText("This character has been guessed already. ");      
        } 
        
        // if game is over, ask player whether to play again or exit. 
        // if player chooses to play again a new game is started
        else if(g.openJPane()){
            System.out.println("open new game");
            this.newGame();  
        }
                    
        
    }
    
    /**
     * creates a new game
     */
    private void newGame(){
        
        // combo box selected value is set to null
        cmbb.setValue(null);
        
        // clears canvas
        gc.clearRect(0, 0, CANVAS_WIDTH, CANVAS_WIDTH);
        
        // initializes text
        txt.setText("Choose a character, and try to guess the word");
        
        // initializes button text
        btn.setText("ENTER CHARACTER");
        
        // calls game logic class to start a new game
        g.newGame();
        
        // sets combo box items to remaining chars list in game logic class
        cmbb.getItems().setAll(g.getRemainingChars());
        
        // set game over parameter to false
        isGameOver = false;

        // update canvas
        this.updateCanvas();
    }
    
    /**
     * Updates canvas. If 
     */
    @FXML
    private void updateCanvas(){
      
        // draws hanged man               
        drawHangedMan();
              
        // draws guessed word
        displayGuessedWord();     
    }
    
    /** 
     * Displays guessed word (current word with only guesses characters visible)
     */
    @FXML
    private void displayGuessedWord(){
        
        // store guesses word in String
        String text = g.getGuessedWord();
        
        // create new Text object in order to measure text width so that it can 
        // be placed in the center of x axis
        Text tempText = new Text(text);
        tempText.setFont(gc.getFont());
        double textWidth = tempText.getLayoutBounds().getWidth();
        
        // clear previous text
        gc.clearRect((CANVAS_WIDTH - textWidth)/2, 300, CANVAS_WIDTH, CANVAS_HEIGHT);

        // fill new text 
        gc.fillText(text,(CANVAS_WIDTH - textWidth)/2 ,300);
        
    }
    
    /** 
     * draws hanged man to canvas. 
     * Each body part is drawn separately and each correspondingly to remaining 
     * tries.
     */
    @FXML
    private void drawHangedMan(){
        
        // for each case of remaining tries draw corresponding body part
        switch (g.getRemainingTries()) {
            case 6:
                //draw head
                gc.strokeOval((CANVAS_WIDTH / 2) - HANGED_MANS_HEAD_RADIUS , 50,
                        HANGED_MANS_HEAD_RADIUS * 2, HANGED_MANS_HEAD_RADIUS * 2);
                break;
            case 5:
                //draw body
                gc.strokeRect((CANVAS_WIDTH / 2) - (HANGED_MANS_BODY_WIDTH / 2)
                        , 50 + HANGED_MANS_HEAD_RADIUS * 2, HANGED_MANS_BODY_WIDTH,
                        HANGED_MANS_BODY_HEIGHT);
                break;
            case 4:
                //draw left hand
                gc.strokeLine((CANVAS_WIDTH / 2) - (HANGED_MANS_BODY_WIDTH / 2),
                        50 + HANGED_MANS_HEAD_RADIUS * 2 + 5,
                        (CANVAS_WIDTH / 2) - (HANGED_MANS_BODY_WIDTH / 2) - 10,
                        50 + HANGED_MANS_HEAD_RADIUS * 2 + 10 + 45);
                break;
            case 3:
                //draw right hand
                gc.strokeLine((CANVAS_WIDTH / 2) + (HANGED_MANS_BODY_WIDTH / 2),
                        50 + HANGED_MANS_HEAD_RADIUS * 2 + 5,
                        (CANVAS_WIDTH / 2) + (HANGED_MANS_BODY_WIDTH / 2) + 10,
                        50 + HANGED_MANS_HEAD_RADIUS * 2 + 10 + 45);
                break;
            case 2:
                //draw left leg
                gc.strokeLine((CANVAS_WIDTH / 2) - (HANGED_MANS_BODY_WIDTH / 2) + 5,
                        50 + HANGED_MANS_HEAD_RADIUS * 2 + HANGED_MANS_BODY_HEIGHT,
                        (CANVAS_WIDTH / 2) - (HANGED_MANS_BODY_WIDTH / 2) + 5,
                        50 + HANGED_MANS_HEAD_RADIUS * 2 + HANGED_MANS_BODY_HEIGHT + 60);
                break;
            case 1:
                //draw right leg
                gc.strokeLine((CANVAS_WIDTH / 2) + (HANGED_MANS_BODY_WIDTH / 2) - 5,
                        50 + HANGED_MANS_HEAD_RADIUS * 2 + HANGED_MANS_BODY_HEIGHT,
                        (CANVAS_WIDTH / 2) + (HANGED_MANS_BODY_WIDTH / 2) - 5,
                        50 + HANGED_MANS_HEAD_RADIUS * 2 + HANGED_MANS_BODY_HEIGHT + 60);
                break;
            case 0:
                //draw pole
                gc.strokeLine((CANVAS_WIDTH / 2) , 10,
                        (CANVAS_WIDTH / 2) , 50);
                gc.strokeLine((CANVAS_WIDTH / 2) , 10,
                        (CANVAS_WIDTH / 2) + 80 , 10);
                gc.strokeLine((CANVAS_WIDTH / 2) + 80 , 10,
                        (CANVAS_WIDTH / 2) + 80 , 250);
                gc.strokeLine((CANVAS_WIDTH / 2) + 80 + 50, 250,
                        (CANVAS_WIDTH / 2) + 80 - 50 , 250);
                break;
            default:
                break;
        }
    }
    
    
    /**
     * displays text indicating whether the player has won, number of guesses, 
     * and if last guessed char was in the word or not
     * 
     * @param c last guessed char
     * @param isCharInWord true if c is in current word
     * @param winValue 1 if player has won, -1 if player has lost, and 0 otherwise
     */
    @FXML
    private void displayText(Character c, boolean isCharInWord ,int winValue){
        
        // if last guessed char is in word display it and write number of remaining guesses
        if(!isCharInWord){
            txt.setText(c + " is not in the word. You have: " + 
                g.getRemainingTries() + " tries.");
            
            // if player has lost set text to indicate it
            if (winValue == -1){
                txt.setText("YOU LOST.");
            }  
        } 
        
        // if player has won set text to indicate it
        else if(winValue== 1){
            txt.setText("YOU WON!");
        }        
        
        // otherwise show number of remaining tries, and that last guessed char is in the word
        else txt.setText(c + " is in the word! You have: " + g.getRemainingTries() + " tries.");
    }

}

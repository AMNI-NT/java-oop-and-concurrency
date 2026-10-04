import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Q2Controller {
    
    // object to refer to logic class
    Logic l;
    
    // maps button to answer. cell i-1 represents i-th button and 
    //buttonAnswerMap[i]-th answer
    int[] buttonAnswerMap ;
    
    // stores player's points
    int playerPoints;
    
    // represents current questionnaire
    String[] q;
    
    @FXML
    private Text txt;

    @FXML
    private Button nextQuestionButton;

    @FXML
    private Button exitGameButton;

    @FXML
    private Button newGameButton;

    @FXML
    private ToggleButton toggleButton1;

    @FXML
    private ToggleButton toggleButton2;

    @FXML
    private ToggleButton toggleButton3;

    @FXML
    private ToggleButton toggleButton4;

    @FXML
    private ToggleGroup toggleGroup;
    
    @FXML
    public void initialize(){
        
        // initialize logic object
        l = new Logic();
        
        // show user location of text file containing answers and questions
        l.showTextFileLocationAndName();
        
        // sets font
        txt.setFont(Font.font("Monospaced", 15));
        
        // starts a new game
        this.newGame();   
    }
    
    /**
     * This method initializes class variables for new game 
     */
    public void newGame(){
        
        // logic class initializes variables for new game
        l.newGame();
        
        // player points are set to zero
        playerPoints = 0;
        
        // set up next question to be shown
        nextQuestion();
    }
    
    /**
     * This method sets up the next questionnaire to be shown to player
     */
    @FXML
    private void nextQuestion(){
        
        // save in q a random questionnaire
        q = l.getRandomQuestionnaire();
        
        // randomly map answers to buttons
        //mapRandomIntegers();
        
        this.buttonAnswerMap = l.getRandomMap();
        
        // assign coresponding answer to each toggle button 
        toggleButton1.setText(q[buttonAnswerMap[0]]);
        toggleButton2.setText(q[buttonAnswerMap[1]]);
        toggleButton3.setText(q[buttonAnswerMap[2]]);
        toggleButton4.setText(q[buttonAnswerMap[3]]);
        
        // assign question to Text object
        txt.setText(q[0]);
     
        // enable toggle buttons and disable next question button
        setDisableToggleButtons(false);
    }
   
    /**
     * This method either calls logic class to check if answer was right, 
     * start, a new game, exit game, or show next question - depending on what 
     * button was pressed. 
     * 
     * @param buttonNum number assigned to clicked button
     */
    @FXML
    void buttonClicked(int buttonNum){
        
        switch (buttonNum) {
            // next question button was pressed
            case 0:
                nextQuestion();
                break;
            // new game button was pressed
            case 5:
                this.newGame();
                break;
            //exit game button was pressed
            case 6:
                System.exit(0);
                break;
            // toggle button was pressed (player answered a question)
            default:
                if(l.checkAnswer(buttonNum)){
                    txt.setText("YOU ARE CORRECT!");
                    playerPoints += 10;
                } 
                else{
                    txt.setText("YOU ARE NOT CORRECT.");
                    playerPoints -= 5;
                }
                
                // diable toggle button and enable next question button
                setDisableToggleButtons(true);
                
                // if there are no other questions ask player to choose whether
                // to play again or exit game
                if(!l.listHasAnotherQuestionnnaire()){
                    txt.setText(txt.getText() + "\n\n YOU HAVE ANSWERED ALL"
                        + " QUESTIONS AND HAVE ATTAINNED " + playerPoints + 
                            " POINTS. \n\nPLEASE CHOOSE WHETHER TO PLAY AGAIN OR EXIT");
                    
                    // disable next question button
                    nextQuestionButton.setDisable(true);
                } 
        }
    }
    
    /**
     * This method sets each of the toggle buttons to either disabled or enabled
     * and next question button to opposite.
     * @param bool boolean value of whether all toggle button will be disabled and
     * next question button enabled
     */
    @FXML
    void setDisableToggleButtons(boolean bool){
        nextQuestionButton.setDisable(!bool);
        toggleButton1.setDisable(bool);
        toggleButton2.setDisable(bool);
        toggleButton3.setDisable(bool);
        toggleButton4.setDisable(bool);
    }
    

    @FXML
    void exitGameButtonClicked(ActionEvent event) {
        buttonClicked(6);
    }

    @FXML
    void newGameButtonClicked(ActionEvent event) {
        buttonClicked(5);
    }
    
    @FXML
    void nextQuestionButtonClicked(ActionEvent event) {
        buttonClicked(0);
    }

    @FXML
    void toggleButton1Clicked(ActionEvent event) {
        buttonClicked(buttonAnswerMap[0]);
    }

    @FXML
    void toggleButton2Clicked(ActionEvent event) {
        buttonClicked(buttonAnswerMap[1]);
    }

    @FXML
    void toggleButton3Clicked(ActionEvent event) {
        buttonClicked(buttonAnswerMap[2]);
    }

    @FXML
    void toggleButton4Clicked(ActionEvent event) {
        buttonClicked(buttonAnswerMap[3]);
    }
}

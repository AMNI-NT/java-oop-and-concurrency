import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This class represent an application that shows a chart of every month's avg
 * temperature from 2001 to 2005. 
 * On launch 2001 is showed and every time the "next" button is pressed the next
 * year is shown (or goes back from 2005 to 2001). 
 * Coldest month of each year is colored blue, hottest month in red, and the 
 * rest in gray

 * @author Amit
 */
public class Question2 extends Application{
    
    // stores the data of the avg temperature of every year from 2001 to 2005
    public final int[][] YEARLY_TEMP_DATA = {
        {32, 34, 38, 47, 56, 65, 70, 69, 61, 51, 42, 34},  // 2001
        {33, 35, 39, 48, 57, 66, 3, 70, 62, 52, 43, 35},  // 2002
        {60, 30, 37, 46, 55, 64, 69, 68, 60, 50, 41, 33},  // 2003
        {34, 36, 40, 49, 12, 67, 72, 71, 63, 53, 44, 36},  // 2004
        {35, 37, 41, 50, 59, 68, 73, 50, 20, 54, 35, 37}   // 2005
    };
    
    // points to current year shown on screen
    public int yearPointer;


    /**
     * This method sets up the fxml file to be shown on the screen of the 
     * application.
     * 
     * @param stage
     * @throws Exception 
     */	
    @Override
    public void start(Stage stage) throws Exception{ 
            Parent root = (Parent) FXMLLoader.load(getClass().getResource("fxml/Question2.fxml")); 
            Scene scene = new Scene(root); 
            stage.setTitle("Question2"); 
            stage.setScene(scene); 
            stage.show(); 
    } 
    
    /**
     * main method of Question2 class
     * @param args 
     */
    public static void main(String[] args) { 
            launch(args); 
            System.out.println();
    } 
}

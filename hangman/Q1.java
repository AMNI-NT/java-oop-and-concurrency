import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This class represents a Hanged Man game and contains the main method for this 
 * game.
 * @author Amit
 */
public class Q1 extends Application{ 
	
        @Override
	public void start(Stage stage) throws Exception{ 
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("fxml/Q1.fxml")); 
		Scene scene = new Scene(root); 
		stage.setTitle("Q1"); 
		stage.setScene(scene); 
		stage.show(); 
	} 
	
	public static void main(String[] args) { 
		launch(args); 
		System.out.println();
	} 
}

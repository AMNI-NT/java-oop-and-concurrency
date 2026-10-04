import java.util.Random;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

/**
 * This method is the controller for the game of life game 
 * @author Amit
 */
public class Q2Controller {
    
    private final int MATRIX_LENGTH_AND_HEIGHT= 10;
    
    private final int CANVAS_LENGTH_AND_HEIGHT = 300;
    
    // represets the matrix containing the boolean values
    public boolean[][] matrix;
    
    private GraphicsContext gc;

    
    // gamelogic object to access the calculation of next gen
    GameLogic g;

    @FXML
    private Button btn;

    @FXML
    private Canvas cnv;
    
    
        
    /**
     * This method initializes the controller for game of life.
     * It randomizes new matrix of 10x10 and prints it
     */
    @FXML
    public void initialize(){
        
        gc = cnv.getGraphicsContext2D();
        
        g = new GameLogic();
        
        // creates random object
        Random random = new Random();
        
        // sets matrix's bounds
        matrix = new boolean[MATRIX_LENGTH_AND_HEIGHT][MATRIX_LENGTH_AND_HEIGHT];
        
        // fills matrix with random boolean values
        for(int i = 0; i < MATRIX_LENGTH_AND_HEIGHT; i++){
            for(int j=0; j<MATRIX_LENGTH_AND_HEIGHT; j++){
                matrix[i][j] = random.nextBoolean();
            }
        }
        
        // draw new matrix
        drawMatrix();

    }

    /**
     * when button is clicked new generation is calculated, saved and printed
     * @param event 
     */
    @FXML
    void BtnClicked(ActionEvent event) {
        
        // calculate and save next generatine
        matrix = g.nextGen(matrix);
        
        // draw new matrix
        drawMatrix();
    }
    
    /**
     * This method draws the matrix on the canvas 
     */
    @FXML
    public void drawMatrix(){
        for(int i = 0; i < MATRIX_LENGTH_AND_HEIGHT; i++){
            for(int j=0; j<MATRIX_LENGTH_AND_HEIGHT; j++){
                
                // paint current cell black if set to alive, and white if set to
                // dead
                if (matrix[i][j] == true){
                    gc.setFill(Color.BLACK);
                } else gc.setFill(Color.WHITE);
                
                // fills rect in proportional position on canvas
                gc.fillRect(i*CANVAS_LENGTH_AND_HEIGHT/MATRIX_LENGTH_AND_HEIGHT, 
                        j*CANVAS_LENGTH_AND_HEIGHT/MATRIX_LENGTH_AND_HEIGHT, 
                        CANVAS_LENGTH_AND_HEIGHT/MATRIX_LENGTH_AND_HEIGHT, 
                        CANVAS_LENGTH_AND_HEIGHT/MATRIX_LENGTH_AND_HEIGHT);
            }
        }

    }

}

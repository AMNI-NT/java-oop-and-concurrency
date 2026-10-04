import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * This class represents the controller of visual element of the chart 
 * represented by Question2 class. It is responsible for drawing the chart 
 * representing the average temperature of every month from the year 2001 to 
 * 2005. 
 * On launch 2001 is showed and every time the "next" button is pressed the next
 * year is shown (or goes back from 2005 to 2001). 
 * Coldest month of each year is colored blue, hottest month in red, and the 
 * rest in gray
 * 
 * @author Amit
 */
public class Question2Controller {

    @FXML
    private Canvas canv;
    private GraphicsContext gc;
        
    // a Question2 object, used to access data from main class
    final Question2 q2 = new Question2();
    
    // stores data on which months of each year are coldest / hottests
    private int[][] yearlyColdestAndHottestMonths = {{0,0},{0,0},{0,0},{0,0},{0,0}};
     
    /**
     * This method initializes variables of Question2Controller class. 
     * Year pointer is set to first year (2001), hottest and coldest months of
     * each year are calculated, and the first chart is drawn.
     */
    @FXML
    public void initialize() {
        gc = canv.getGraphicsContext2D();
        
        // initialize year pointer
        q2.yearPointer = 0; 
        
        // save to yearlyColdestAndHottestMonths coldest and hottest month of
        // each year
        saveColdestAndHottestMonths();
        
        // draws the x and y axis of the chart (months and temperatures)
        drawChartAxis();
          
        // draws chart of currently initialized year (2001)
        drawChart();        
    }

    /**
     * This method is activated when the "next" button is clicked.
     * Pointer is set to next year (or first if last year is reached), then
     * the chart is drawn using method drawChart
     * @param event 
     */
    @FXML
    void buttonClicked(ActionEvent event) {
        
           if(q2.yearPointer != 4){ // is year pointer set to after 2005?
               q2.yearPointer++; // no, button set to next year
           }
           else q2.yearPointer = 0; // yes, set pointer back to 2001

           drawChart(); // draw temprature chart 
    }
    
    /**
     * This method draws a chart of avg temperature of every month in the year
     * the pointer points to. The coldest month of the year is set to color blue
     * and the hottest to red. All other months are in gray.
     */
    @FXML
    public void drawChart(){
        
        // clears the canvas for a new chart to be deawn
        gc.clearRect(45, 0, 555, 360); 
         
        // draws text indicating current year
        gc.strokeText("The average temprature of each month of the year 200" + (q2.yearPointer + 1) + " is:", 45, 15);
          
       // draws every month of the chart        
        for (int i=0; i<12; i++){
            
            // if current month is coldest draw it in blue
            if(yearlyColdestAndHottestMonths[q2.yearPointer][0] == i){
                gc.setFill(Color.BLUE);    
            }
            // if current month is hottest draw it in red
            else if(yearlyColdestAndHottestMonths[q2.yearPointer][1] == i){
                gc.setFill(Color.RED);
            }
            // otherwise, draw in grey
            else gc.setFill(Color.GREY);
            
            // draws current month's representative rectangle
            gc.fillRect(45 + i*45,355-q2.YEARLY_TEMP_DATA[q2.yearPointer][i]*4,40,q2.YEARLY_TEMP_DATA[q2.yearPointer][i]*4);
            
            // prints a text indicating the temperature above the rectangle              
            gc.strokeText("" + q2.YEARLY_TEMP_DATA[q2.yearPointer][i], 58 + i*45,350-q2.YEARLY_TEMP_DATA[q2.yearPointer][i]*4, 45);
        }   

    }
    
    /**
     * This method draws the x and y axis of the chart.
     * The x axis is for months, and y is for avg temperature of each month
     */
    @FXML
    private void drawChartAxis(){
        
        // draw month numbers on x axis 
        for (int i=0; i<12; i++){
            gc.strokeText(i + 1 +"", 60 + i*45,370, 40);
        }
        
        // draw temprature markings on y axis
        for (int i=0; i<8; i++){    
            gc.strokeText("" + i*10, 5,340 - i*10*4);
        }

    }
    
    /**
     * This method checks the avg temperature of each year in the data stored 
     * in Question2 class, and saves in yearlyColdestAndHottestMonths the 
     * coldest and hottest months of each month (coldest in first cell of year, 
     * and hottest in second cell)
     */
    private void saveColdestAndHottestMonths(){
        
        // check every year for colderst and hottest months
        for(int i = 0; i < 5; i++){
           
            // check for every month of current year and save if a colder/hotter
            // than coldest/hottest month so far have been found 
            for(int j = 0; j < 12; j++){
                
                // if current month is colder than coldest month so far 
                if ( q2.YEARLY_TEMP_DATA[i][j] < q2.YEARLY_TEMP_DATA[i][yearlyColdestAndHottestMonths[i][0]]){
                    
                    // set current month to new coldest month
                    yearlyColdestAndHottestMonths[i][0] = j;
                }
                
                // if current month is hotter than coldest month so far 
                if ( q2.YEARLY_TEMP_DATA[i][j] > q2.YEARLY_TEMP_DATA[i][yearlyColdestAndHottestMonths[i][1]]){
                    
                    // set current month to new hotest month
                    yearlyColdestAndHottestMonths[i][1] = j;
                }
            }       
        }
    }
}

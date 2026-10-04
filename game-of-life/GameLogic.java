


/**
 * This method represents the game logic of the game of life
 * @author Amit
 */
public class GameLogic {
     /**
     * constructor for game logic class
     */
    public GameLogic(){}
    
    /** 
     * calculates values of next generation changes matrix to them according to 
     * 10x10 matrix
     * @param matrix given matrix
     * @return next generation matrix
     */
    public boolean[][] nextGen(boolean[][] matrix){
        
        // create a temporary matrix to save matrix's values
        boolean[][] temp = matrix;
        
        // counter for alive neighbors
        int count;
        // change every cell in matrix according to rules
        for(int i = 0; i < 10; i++){
            
            
            for(int j=0; j<10; j++){
                //counter is set to zero
                count = 0;
                
                // counts every alive neighbor of current cell
                if(i-1 != -1){
                    if(matrix[i-1][j] == true) count++;
                    
                    if(j-1 != -1){
                        if(matrix[i-1][j-1] == true) count++;
                    } 
                }
                
                if(j-1 != -1){
                    if(matrix[i][j-1] == true) count++;
                    
                    if(i+1 != 10){
                        if(matrix[i+1][j-1] == true) count++;
                    }
                }
                
                if(i+1 != 10){
                    if(matrix[i+1][j] == true) count++;
                    
                    if(j+1 != 10){
                        if(matrix[i+1][j+1] == true) count++;
                    }
                }
                if(j+1 != 10){
                    if(matrix[i][j+1] == true) count++;
                    
                    if(i-1 != -1){
                        if(matrix[i-1][j+1] == true) count++;
                    }
                }
                
                // first rule: if current cell is dead and has three alive neighbors
                // set to alive
                if(temp[i][j] == false && count == 3) temp[i][j] = true;
                
                // second and third rule: if currrent cell is alive, if has more than
                // three alive cells it dies, and if it has less than two living
                // neighbors it dies
                else if(temp[i][j] == true && 
                        (count < 2 || count > 3)){
                    temp[i][j] = false;
                }    
            }
        }
        
        // returns newly calculated matrix
        return temp;
    }
}

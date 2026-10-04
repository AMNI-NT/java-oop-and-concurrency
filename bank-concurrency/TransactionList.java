
import java.util.ArrayList;


/**
 * This method represents a list of transaction to make
 * @author Amit
 */
public class TransactionList {
    
    // list containing pairs of id (first cell and transaction amount (second cell),
    // which are represented as an array of two integers
    private ArrayList<int[]> list;
    
    /** 
     * This method gets an array of id/transaction pairs and saves them in list
     * @param list given array
     */
    public TransactionList(int[][] list){
        
        // initialize array list of actions
        this.list = new ArrayList<>();
        
        //add every id/action pair to this list
        for (int i=0; i < list.length; i++){    
            this.list.add(list[i]);  
        }
    }
    
    /**
     * @return next transaction in list, or null if list is empty
     */
    public int[] getTransaction(){
        
        // if list if not empty remove last object, and return it 
        if(!list.isEmpty()){
                      
            int[] transaction = list.get(0);
            list.remove(0);
                        
            return transaction;
        }
               
        // list is empty and therefore return null
        return null;             
    }
    
    
}

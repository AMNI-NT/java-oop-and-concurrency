
import java.util.ArrayList;
import java.util.Arrays;


/**
 *
 * @author Amit
 */
public class MergeThread extends Thread{
    
    // array list of type int[] that stores arrays
    static ArrayList<int[]> arrList;
    
    public MergeThread(){}
    
    /**
     * initializes arrList to contain a the cells of a given array of integers 
     * as one cell arrays
     * @param array given array of integers
     */
    public static void intArrayToArrayListOfIntArrays(int[] array){
        arrList = new ArrayList<>();
        
        // add each cell in array as it's own int[] in array list
        for(int i=0; i < array.length; i++){    
           arrList.add(new int[]{array[i]}); 
        }    

    }
    
    
    //--------------------------------------------------------------------------
    public static String arrayListToString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[\n"); // Start of ArrayList
        
        for (int[] array : arrList) {
            sb.append("  ").append(Arrays.toString(array)).append("\n"); // Convert each int[] to String
        }
        
        sb.append("]");
        return sb.toString();
    }
//----------------------------------------------------------------------------------
    
    
    @Override
    public void run(){
        super.run();
        
        // while all arrays have not been mergred continues to merge
        while(arrList.size() > 1){
            // merge two arrays from arrList
            mergeTwoArraysFromArrayList(arrList.remove(0), arrList.remove(0));
        }   
        
        
    }
    
       
    /**
     * Merges two sorted int arrays from array list, and replaces them with one 
     * sorted array,
     * 
     * @param arr1 first given array
     * @param arr2 second given array
     */
    private synchronized void mergeTwoArraysFromArrayList(int[] arr1, int[] arr2 ){
        
        
        // create new array with combined length of the two arrays into which 
        // the merge array will be saved
        int[] arr3 = new int[arr1.length + arr2.length];
        
        // initialize index for arr1
        int i=0;
        
        // initialize index for arr2
        int j=0; 
        
        // initialize index for arr3
        int k=0;
        
        // while no index has reached it's array's length
        while(i < arr1.length && j < arr2.length){
            
            // if arr1 current cell is less or equal to arr2's current cell
            if(arr1[i] <= arr2[j]){
                
                // save it in current cell of arr3 and increase arr1 pointer
                arr3[k]=arr1[i];
                i++; 
            } 
            // if arr1 current cell is larger than arr2's current cell
            else{
                
                 // save it in current cell of arr3 increase arr2 pointer                 
                arr3[k]=arr2[j];
                j++; 
            }  
            
            // increase arr3 pointer 
            k++;
        }
        
        // save any remaining values in arr1 or arr2 to arr3
        
        while(i < arr1.length){
            arr3[k]=arr1[i];
            i++; k++;
        }
        
        while(j < arr2.length){
            arr3[k]=arr2[j];
            j++; k++;
        }

        // add merged and sorted array to array list
        arrList.add(arr3);
    }
}

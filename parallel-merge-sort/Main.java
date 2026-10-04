
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Amit
 */
public class Main {
    public static void main(String[] args){
        
        ArrayList<MergeThread> threadList = new ArrayList<>();
        
        // create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);
        
        // random object to create an array of random objects
        Random rnd = new Random();
        
        // ask the user for the array length (n)
        System.out.print("Enter the length of the array (n): ");
        int n = scanner.nextInt();

        // ask the user for the number of threads (m)
        System.out.print("Enter the number of threads (m): ");
        int m = scanner.nextInt();
        
        // initialize random array in the size of given n
        int[] randomIntArray = new int[n];
        
        // fills new array with numbers between 1 and 100
        for (int i=0; i < n; i++){
            randomIntArray[i] = rnd.nextInt(99) + 1;
        }
        
                
        MergeThread.intArrayToArrayListOfIntArrays(randomIntArray);
        
        
        System.out.println("Unsorted array: " + MergeThread.arrayListToString());
        


        for( int i=0; i<m; i++){
            threadList.add(new MergeThread());
        }
        
        for (int i=0; i<m; i++){
            threadList.get(i).start();
        }
        
        try{
            for (int i=0; i<m; i++){
                threadList.get(i).join();
            }
  
        }catch(InterruptedException e){ 
        }
        
        System.out.println("Sorted array: " + MergeThread.arrayListToString());
        
        
    }
}

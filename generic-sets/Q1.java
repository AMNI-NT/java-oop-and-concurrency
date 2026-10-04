
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author Amit
 */
public class Q1 {
    public static void main(String[] args){
                
        System.out.println("-------------------------------------------------");
        System.out.println("Seif Bet ");
        System.out.println("-------------------------------------------------");
        seifBet();
        
        System.out.println("-------------------------------------------------");
        System.out.println("Seif Gimel ");
        System.out.println("-------------------------------------------------");
        seifGimel();
        
        
        
    }
    
    private static void seifGimel(){
        
        Person person1 = new Person(1002, "Alice Johnson", "1990-01-01");
        Person person2 = new Person(1007, "Bob Smith", "1985-05-12");
        Person person3 = new Person(1003, "Charlie Brown", "2000-10-25");
        Person person4 = new Person(1006, "Diana Prince", "1995-07-15");
        Person person5 = new Person(1008, "Eve Adams", "1988-12-30");
        
        Person[] p = {person1, person2, person3, person4, person5};
        
        System.out.println("These are the people created: " + person1.toString() + person2.toString()
            + person3.toString()  + person4.toString() +  person5.toString());
        
        System.out.println("\nThey will now be added to a new set.");
        
        Set<Person> pSet = new Set(p);

        System.out.println("\nMinimal person from group is :" + classForSeifGimel.methodForSeifGimel(pSet).getName());
    }
    
    private static void seifBet(){
        Random random = new Random();
                
        Set<Integer> set1 = new Set(random.ints(10, 0, 10).boxed().toArray(Integer[]::new));
        Set<Integer> set2 = new Set(random.ints(10, 0, 10).boxed().toArray(Integer[]::new));
        Set<Integer> set3 = new Set(random.ints(10, 0, 10).boxed().toArray(Integer[]::new));
            
        System.out.println("This is the first set: " + set1.toString()
                + "\nThis is the second set: " + set2.toString() 
                + "\nThis is the third set: " + set3.toString());
        
        System.out.println("\n-------------------------------------------------");

        System.out.println("\nNow the union of the first and second set will be saved in first set.");
        
        set1.union(set2);
        
        System.out.println("\nFirst and second sets have been united. \nThe union is: " + set1.toString());
        
        System.out.println("\n-------------------------------------------------");
        
        System.out.println("\nNow the intersection of the first and third set will be saved in first set.");
        
        set1.intersect(set3);
        
        System.out.println("\nFirst and third sets have been intersected. \nThe intersection is: " + set1.toString());
        
        System.out.println("\n-------------------------------------------------");
        
        System.out.println("\nNow a new set will be created from two integers which will be given by the user: ");
        
        Integer[] intArr = new Integer[2];
        
        System.out.print("\nPlease enter an integer: ");
        intArr[0] = getIntInput();
                
        
        System.out.print("\nPlease enter another integer: ");
        intArr[1]  = getIntInput();
                           
        System.out.println("\nA new set have been created from given integers.");

        Set<Integer> set4 = new Set(intArr);
        
        boolean isSet4SubsetofSet1 = set1.isSubset(set4);
        
        boolean isSet4SubsetofSet2 = set2.isSubset(set4);
        
        boolean isSet4SubsetofSet3 = set3.isSubset(set4);
        
        if(isSet4SubsetofSet1){
            System.out.println("\nNew set is a subset of first set");
        } 
        if(isSet4SubsetofSet2){
            System.out.println("\nNew set is a subset of second set");
        } 
        if(isSet4SubsetofSet3){
            System.out.println("\nNew set is a subset of third set");
        } 
        else if(!isSet4SubsetofSet1 && !isSet4SubsetofSet2){
            System.out.println("\nNew set is not a subset of any set");
        }
        
        System.out.println("\n-------------------------------------------------");

        System.out.print("\nPlease enter an integer: ");
        int input = getIntInput();
        
        if(set1.isMember(input)) System.out.println("\nGiven integer is a member of the first set");
        
        System.out.println("\nNow given integer will be added to second set.");
        
        set2.insert(input);
        
        System.out.println("\nSecond set has been changed to: " + set2.toString());

        System.out.println("\nNow given integer will be deleted from third set.");
        
        set3.delete(input);
        
        System.out.println("\nThird set has been changed to: " + set3.toString());

    }
    
    private static int getIntInput(){
        Scanner scanner = new Scanner(System.in);
        
        while(true){
            try{
                return scanner.nextInt();
            } catch (InputMismatchException e){
                System.out.print("This is not an integer. Please enter an integer: ");
                scanner.nextLine(); 
            }

        }
        
    }
}

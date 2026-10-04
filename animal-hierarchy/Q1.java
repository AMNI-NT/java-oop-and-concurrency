
import java.util.ArrayList;

/**
 *
 * @author Amit
 */
public class Q1 {
    public static void main(String[] args) throws CloneNotSupportedException{
        
        System.out.println("\n------");
        System.out.println("seif alef");
        System.out.println("------");

        
        // creates new array list which will represent the pension
        ArrayList<Animal> pension = new ArrayList<Animal>();
        
        // ads a dog and a cow
        pension.add(new Dog("Melvin", 6, "brown", 6.0, 20.0, "Margot", "12341"));
        pension.add(new Cow("Manny", 11, "black", 3.0));
        
        // ads a pigeon and a songbird
        pension.add(new Pigeon("Bob", 3, "white"));
        pension.add(new Songbird("Bella", 5, "blue"));
        
        //ads a snake and a lizard 
        pension.add(new Snake("Rob", 7, "green", 35, 3, "Ron", "09870"));
        pension.add(new Lizard("Ray", 4, "gray", 20, 10));
        
        System.out.println("\n-Details of every animal in the pension: \n");
        
        // every animal's details are printed
        for (int i=0; i<pension.size(); i++){
            System.out.println(pension.get(i).toString());
        }

        System.out.println("\n------");
        System.out.println("seif bet");
        System.out.println("------");
           
        System.out.println("\n-All animals are going to be fed: \n");
        
        // all animals are fed
        for (int i=0; i<pension.size(); i++){
            pension.get(i).eat();
        }
        
        System.out.println("\n-All mammal are going to be let walk: \n");
        
        // all mammals are let to walk
        for (int i=0; i<pension.size(); i++){
            
            // checking for every item in arraylist pension, if it is a mammal it is walked 1 km
            if(pension.get(i).getClass().getSuperclass().getName().equals("Mammal")){ 
                ((Mammal)pension.get(i)).walk(1.0);
            }        
        }
        
        System.out.println("\n-All birds are going to be let fly: \n");

        
        // all birds are let to fly
        for (int i=0; i<pension.size(); i++){
            
            // checking for every item in arraylist pension, if it is a bird it is let fly 1 km
            if(pension.get(i).getClass().getSuperclass().getName().equals("Bird")){ 
                ((Bird)pension.get(i)).fly(1.0);
            }        
        }
        
        System.out.println("\n-All reptiles are going to be let crawl: \n");

        // all reptiles are let to crawl
        for (int i=0; i<pension.size(); i++){
            
            // checking for every item in arraylist pension, if it is a reptile it is let crawl
            if(pension.get(i).getClass().getSuperclass().getName().equals("Reptile")){ 
                ((Reptile)pension.get(i)).crawl();
            }        
        }
        
        System.out.println("\n------");
        System.out.println("seif gimel");
        System.out.println("------");
 
        
        System.out.println("\nNow a new dog is going to be created, and is going to be cloned: ");
        
        // new dog is created
        Dog dog = new Dog("Dor", 4, "white", 5.0, 15.0, "Dabbie", "78907");
        
        // dog is cloned
        Dog cloneDog = (Dog)dog.clone();
        
        // cloned dog's owner is changed
        cloneDog.setOwner("Carrie", "45674");
        
        System.out.println("\nThe dog has been cloned");
        
        // original dog's owner's propertiese are printed
        System.out.println("\nOriginal dog's owner's properties are: " + dog.getOwner().toString());
        
        // cloned dog's owner's propertiese are printed
        System.out.println("Cloned dog's owner's properties are: " + cloneDog.getOwner().toString());
        
        
    }
}

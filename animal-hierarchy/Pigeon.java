/**
 * This class represent a pigeon.
 * 
 * @author Amit
 */
public class Pigeon extends Bird{
    
    /** Constructor for songbird class. 
     * Flight speed is set to 100 km/h
     * 
     * @param name Pigeon's name
     * @param age Pigeon's age
     * @param color Pigeon's color
     */
    public Pigeon(String name, int age, String color){
        super(name, age, color, 100);
    }
    
    /**
     * This method makes a Pigeon object eat bread
     */
    @Override
    public void eat(){
        System.out.println("Pigeon " + this.name + " has eaten bread.");
    }
    
    /**
     * 
     * @return new Cow object with same values as this
     * @throws java.lang.CloneNotSupportedException
     */
    @Override
    public Object clone() throws CloneNotSupportedException{
     
        // return created
        return (Pigeon) super.clone();
    }

}

/**
 * This class represents a cow
 *
 * @author Amit
 */
public class Cow extends Mammal{
    
    /**
     * Constructor for Cow class
     * @param name Cow's name
     * @param age Cow's age
     * @param color Cow's color
     * @param walkingSpeed Cow's walking speed
     */
    public Cow(String name, int age, String color, double walkingSpeed){
        super(name, age, color, walkingSpeed);
    }    
    
    /**
     * This method makes cow walk the given distance and prints the time it took
     * @param walkingDistance
     */
    @Override
    public void walk(double walkingDistance){
        System.out.println("Cow " + this.name + " has walked " + walkingDistance
        + " kilometers in " + walkingDistance/walkingSpeed + " hours.");
    }
    
    /**
     * This method makes cow eat grass
     */
    @Override
    public void eat(){
        System.out.println("Cow " + this.name + " has eaten grass.");
    }
    
    /**
     * 
     * @return new Cow object with same values as this
     */
    @Override
    public Object clone() throws CloneNotSupportedException{
     
        // return created
        return (Cow) super.clone();
    }
   
}

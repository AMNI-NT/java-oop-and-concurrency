/**
 * This class represents a songbird 
 * Has additional methods to Bird, of eating seeds and singing
 * 
 * @author Amit
 */
public class Songbird extends Bird{
    
    /** Constructor for songbird class. 
     * Flight speed is set to 50 km/h
     * 
     * @param name Songbird's name
     * @param age Songbird's age
     * @param color Songbird's color
     */
    public Songbird(String name, int age, String color){
        super(name, age, color, 50);
    }
    
    /**
     * This method makes a Songbird object sing
     */
    public void sing(){
        System.out.println("Songbird " + this.name + " has sung.");
    }
    
    /**
     * This method makes a Songbird object eat seeds
     */
    @Override
    public void eat(){
        System.out.println("Songbird " + this.name + " has eaten seeds.");
    }
    
    /**
     * 
     * @return new Cow object with same values as this
     * @throws java.lang.CloneNotSupportedException
     */
    @Override
    public Object clone() throws CloneNotSupportedException{
     
        // return created
        return (Songbird) super.clone();
    }
    
}

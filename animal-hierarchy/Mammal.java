/**
 * This class represents a mammal
 *
 * @author Amit
 */
public abstract class Mammal extends Animal{
    
    // represent's this mammal's walking speed
    protected double walkingSpeed;
    
    /**
     * Constructor for Mammal class
     * @param name Mammal's name
     * @param age Mammal's age
     * @param color Mammal's color
     * @param walkingSpeed Mammal's walking speed
     */
    public Mammal(String name, int age, String color, double walkingSpeed){
        super(name, age, color);
        this.walkingSpeed = walkingSpeed;
    }
    
    /**
     * This method makes this mammal walk given distance
     * @param walkingDistance given distance to walk
     */
    public abstract void walk(double walkingDistance); 

    /**
     * @return mammal's walking speed
     */
    public double getWalkingSpeed(){return this.walkingSpeed;}
    
    /**
     * This method sets mammal's walking speed 
     * @param walkingSpeed new speed to be set to 
     */
    public void setWalkingSpeed(double walkingSpeed){this.walkingSpeed = walkingSpeed;}
    
    /** 
     * This method return true if two given mammals have the same values 
     * 
     * @param m second given mammal
     * @return true if two mammals are the same
     */
    public boolean equals(Mammal this, Mammal m){
        
        // boolean value to save in whether this and m are the same
        boolean temp = true;
        
        // if classes or variables inherited from Animals class are not the same 
        // return false
        if(!super.equals(m)) temp = false;
        
        // if walking speed is not the same return false
        if(this.getWalkingSpeed() != m.getWalkingSpeed()) temp = false;
            
        return temp; 
    }
    
    /**
     * 
     * @return string representation of this mammal
     */
    @Override
    public String toString(){
        return super.toString() + ", walking speed is " + this.walkingSpeed + " km/h";
    }
    
    /**
     *
     * @return clone of this mammal 
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException{
        return (Mammal) super.clone();
    }
}

/**
 * This class represents a reptile
 * 
 * @author Amit
 */
public abstract class Reptile extends Animal {
    
    // represent's reptiles preferred temperature in degrees
    protected int preferredTemperature;
    
    /**
     * constructor for Reptile  class.
     * 
     * @param name Reptile's name
     * @param age Reptile's age
     * @param color Reptile's color
     */
    public Reptile(String name, int age, String color, int preferredTemperature){
        super(name, age, color);
        this.preferredTemperature = preferredTemperature;
    }
    
    /**
     * This method makes this reptile crawl
     */
    public void crawl(){
        System.out.println(this.getClass().getName() + " " + this.name + " has crawled.");
    }
    
    /**
     * @return this reptile's preferred temperature
     */
    public int getPreferredTemperature(){
        return this.preferredTemperature;
    }
    
    /**
     * This method sets reptile's preferred temperature 
     * @param preferredTemperature temperature to be set
     */
    public void setPreferredTemperature(int preferredTemperature){
        this.preferredTemperature = preferredTemperature;
    }
    
    /** 
     * This method return true if given reptile have the same values as this
     * 
     * @param r given reptile
     * @return true if two reptiles are the same
     */
    public boolean equals(Reptile r){
        
        // boolean value to save in whether this and r are the same
        boolean temp = true;
        
        // if classes or variables inherited from Animals class are not the same 
        // return false
        if(!super.equals(r)) temp = false;
        
        // if preferred temperature is not the same return false
        if(this.preferredTemperature != r.getPreferredTemperature()) temp = false;
            
        return temp; 
    }
    
    @Override
    public String toString(){
        return super.toString() + " ,preferred temperature is " + this.preferredTemperature;
    }
    
    /**
     * 
     * @return new Dog object with same values as this
     */
    @Override
    public Object clone() throws CloneNotSupportedException{
        // use clone method from mammal
        Reptile r = (Reptile) super.clone();
        
        // set walking speed to current one
        r.setPreferredTemperature(this.preferredTemperature);
        
        // return created
        return r;
    }

}

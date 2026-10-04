/**
 * This class represents a bird, which has a certain flight speed, and can 
 * fly a certain given distance using fly method. 
 * 
 * @author Amit
 */
public abstract class Bird extends Animal{
    
    // Bird's speed of flight in km/h
    private double flightSpeed;
    
    /**
     * constructor of Bird class 
     * @param name new Bird's name
     * @param age new Bird's age
     * @param color new Bird's color
     * @param flightSpeed new Bird's flight speed
     */
    public Bird(String name, int age, String color, int flightSpeed){
        super(name, age, color);
        this.flightSpeed = flightSpeed;
    }
      
    /**
     * This method makes bird fly the given distance and prints how long it took
     * @param flightDistance distance for the bird to fly   
     */
    public void fly(double flightDistance){
        System.out.println(this.name + " has flied " + flightDistance + " "
                + " kilometers in " + flightDistance/flightSpeed + " hours.");
    }
    
    /**
     * @return bird's flight speed
     */
    public double getFlightSpeed(){return this.flightSpeed;}
    
    /**
     * This method sets snakes length
     * @param flightSpeed new length to be set to 
     */
    public void setFlightSpeed(double flightSpeed){this.flightSpeed = flightSpeed;}
    
    /** 
     * This method return true if two given birds have the same values 
     * 
     * @param b second given bird
     * @return true if two Birds are the same
     */
    public boolean equals(Object object){
        
        // boolean value to save in whether this and b are the same
        boolean temp = true;
        
        // if classes or variables inherited from Animals class are not the same 
        // return false
        if(!super.equals(object)) temp = false;
        
        // if current object is a bird save it in a Bird pointer
        Bird b = (Bird) object;
        
        // if flight speed is not the same return false
        if(this.getFlightSpeed() != b.getFlightSpeed()) temp = false;
            
        return temp;
        
    }
    
    /**
     * returns this Bird's description as a string 
     * @return string representing animal
     */
    @Override
    public String toString(){
        return super.toString() + ", flight speed is " + this.flightSpeed + " km/h";
    }
    
    /**
     * 
     * @return new Bird object with same values as this
     */
    @Override
    public Object clone() throws CloneNotSupportedException{
        // use clone method from mammal
        Bird b = (Bird) super.clone();
        
        // set walking speed to current one
        b.setFlightSpeed(this.flightSpeed);
        
        // return created
        return b;
    }
    
    
}

    

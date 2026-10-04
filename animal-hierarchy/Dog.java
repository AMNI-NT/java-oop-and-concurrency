/**
 * This class represents a dog
 *
 * @author Amit
 */
public class Dog extends Mammal{
    
    // represents dog's running speed in km/h
    private double runningSpeed;
    
    // represent's dog's owner 
    private Owner owner;
    
    /**
     * Constructor for Dog class. Walking speed is set to 5 km/h and running
     * speed is set to 30 km/h
     * @param name Dog's name
     * @param age Dog's age
     * @param color Dog's color
     * @param walkingSpeed Dog's walking speed
     * @param runningSpeed Dog's running speed
     * @param ownerName dog's owner's name
     * @param phoneNumber dog's owner's phone number
     */
    public Dog(String name, int age, String color, double walkingSpeed, double runningSpeed,
            String ownerName, String phoneNumber){
        super(name, age, color, walkingSpeed);
        this.runningSpeed = runningSpeed;
        owner = new Owner(ownerName, phoneNumber);
    }    
    
    /**
     * This method makes dog run the given distance and prints the time it took
     * @param runnigDistance
     */
    public void run(double runnigDistance){
        System.out.println("Dog " + this.name + " has runned " + runnigDistance
        + " kilometers in " + runnigDistance/runningSpeed + " hours.");
    }

    
    /**
     * This method makes dog walk the given distance and prints the time it took
     * @param walkingDistance
     */
    @Override
    public void walk(double walkingDistance){
        System.out.println("Dog " + this.name + " has walked " + walkingDistance
        + " kilometers in " + walkingDistance/walkingSpeed + " hours.");
    }
    
    /**
     * This method makes dog eat grass
     */
    @Override
    public void eat(){
        System.out.println("Dog " + this.name + " has eaten dog food.");
    }
    
    /**
     * @return mammal's running speed
     */
    public double getRunningSpeed(){return this.runningSpeed;}
    
    /**
     * This method sets mammal's running speed 
     * @param runningSpeed new speed to be set to 
     */
    public void setRunningSpeed(double runningSpeed){this.runningSpeed = runningSpeed;}
    
    /**
     * 
     * @return owner of this dog
     */
    public Owner getOwner(){return this.owner;}
    
    public void setOwner(String ownerName, String ownerPhoneNumber){
        owner = new Owner(ownerName, ownerPhoneNumber);
    }
    
    /** 
     * This method return true if two given dogs have the same values 
     * 
     * @param object  given object
     * @return true if two dogs are the same
     */
    @Override
    public boolean equals(Object object){
        
        // if classes or variables inherited from Mammals class are not the same 
        // return false
        if(!super.equals(object)) return false;
        
        Dog d = (Dog) object;
        
        // if running speed is not the same return false
        if(this.getRunningSpeed() != d.getRunningSpeed()) return false;
        
        // if this dog's owner is different from given dog's pwner return false
        if(this.getOwner().equals(d.getOwner())) return false;
         
        // if no differences were found return true
        return true; 
    }
    
    @Override
    public String toString(){
        return super.toString() + ", running speed is " + this.runningSpeed + " km/h";
    }
    
    
    
    /**
     * 
     * @return new Dog object with same values as this
     */
    @Override
    public Object clone() throws CloneNotSupportedException{
        // use clone method from mammal
        Dog d = (Dog) super.clone();
        
        // set walking speed to current one
        d.setWalkingSpeed(this.runningSpeed);
        
        // return created
        return d;
    }
    
    
}

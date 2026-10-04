/**
 * This class represents a lizard
 * 
 * @author Amit
 */
public class Lizard extends Reptile{

    // represents lizard's length in cm
    private int lizardTailLength;
    
    /**
     * Constructor for Lizard class. 
     * Preferred temperature is initialized to 25 degrees and tail length to 5 
     * cm
     * 
     * @param name lizard's name
     * @param age lizard's age
     * @param color lizard's color
     * @param preferredTemperature lizard's preferred temperature 
     * @param lizardTailLength lizard's tail length
     */
    public Lizard(String name, int age, String color, int preferredTemperature, 
            int lizardTailLength){
        super(name, age, color, preferredTemperature);
        this.lizardTailLength = lizardTailLength; 
    }
    
    /**
     * This method makes this lizard eat a mouse
     */
    @Override
    public void eat(){
        System.out.println(String.format("Lizard %s has eaten an ant.", this.name));
    }
    
    /** 
     * This method returns lizard's length
     * @return this.lizardTailLength length of lizard
     */
    public int getLizardTailLength(){
        return this.lizardTailLength;
    }
    
    /**
     * This method sets lizards length
     * @param lizardTailLength new tail length to be set to 
     */
    public void setLizardTailLength(int lizardTailLength){
        this.lizardTailLength = lizardTailLength;
    }
    
    /** 
     * This method return true if given object is a lizard and has
     * the same values as this lizard
     * 
     * @param object given object
     * @return true if two lizards are the same
     */
    @Override
    public boolean equals(Object object){
        
        // if classes or variables inherited from Animals class are not the same 
        // return false
        if(!super.equals(object)) return false;
        
        Lizard l = (Lizard) object;
        
        // if preferred temperature is not the same return false
        if(this.lizardTailLength != l.getLizardTailLength()) return false;
          
        // if no differences were found return true
        return true; 
    }
    
    @Override
    public String toString(){
        return super.toString() + ", lizard's tail length is " + this.lizardTailLength
                + " meters";
    }
    
    /**
     * 
     * @return new Lizard object with same values as this
     * @throws java.lang.CloneNotSupportedException
     */
    @Override
    public Object clone() throws CloneNotSupportedException{
        // use clone method from mammal
        Lizard l = (Lizard) super.clone();
        
        // set walking speed to current one
        l.setLizardTailLength(this.lizardTailLength);
        
        // return created
        return l;
    }
  }

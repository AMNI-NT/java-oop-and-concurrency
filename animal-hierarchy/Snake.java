/**
 * This class represents a snake
 * 
 * @author Amit
 */
public class Snake extends Reptile{

    // represents snake's length in m
    private int snakeLength;
    
    // represent's snake's owner 
    private Owner owner;
    
    /**
     * Constructor for Snake class
     * 
     * @param name snake's name
     * @param age snake's age
     * @param color snake's color
     * @param preferredTemp snake's preferred temperature
     * @param length snake's length
     * @param ownerName snake's owner's name
     * @param phoneNumber snake's owner's phone number
     */
    public Snake(String name, int age, String color, int preferredTemp, int length,
            String ownerName, String phoneNumber){
        super(name, age, color, preferredTemp);
        this.snakeLength = length; 
        owner = new Owner(ownerName, phoneNumber);
    }
    
    /**
     * This method makes this snake eat a mouse
     */
    @Override
    public void eat(){
        System.out.println(String.format("Snake %s has eaten a mouse.", this.name));
    }
    
    /** 
     * This method returns snake's length
     * @return this.snakeLength length of snake
     */
    public int getSnakeLength(){
        return this.snakeLength;
    }
    
    /**
     * This method sets snakes length
     * @param snakeLength new length to be set to 
     */
    public void setSnakeLength(int snakeLength){
        this.snakeLength = snakeLength;
    }
    
    /** 
     * 
     * @return owner of this snake
     */
    public Owner getOwner(){return this.owner;}

    /** 
     * This method return true if given snake have the same values as this
     * 
     * @param s given snake
     * @return true if two snakes are the same
     */
    public boolean equals(Snake s){
        
        // if classes or variables inherited from Animals class are not the same 
        // return false
        if(!super.equals(s)) return false;
        
        // if preferred temperature is not the same return false
        if(this.snakeLength != s.getSnakeLength()) return false;
        
        if(!this.owner.equals(s.getOwner())) return false;
        
        // if no differences were found return true
        return true; 
    }
    
    @Override
    public String toString(){
        return super.toString() + ", snake's length is " + this.snakeLength + " meters";
    }
    
     /**
     * 
     * @return new Snake object with same values as this
     * @throws java.lang.CloneNotSupportedException
     */
    @Override
    public Object clone() throws CloneNotSupportedException{
        // use clone method from mammal
        Snake s = (Snake) super.clone();
        
        // set walking speed to current one
        s.setSnakeLength(this.snakeLength);
        
        // return created
        return s;
    }
  }

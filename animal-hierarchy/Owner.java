

/**
 * This class represent an owner of an animal
 * @author Amit
 */
public class Owner {
    
    // represent's owners name
    private final String name; 
    
    // represent's owners phone number
    private String phoneNumber; 
    
    /**
     * constructor for owner class
     * @param name owner's name
     * @param phoneNumber owner's phone number
     */
    public Owner(String name, String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    
    /** 
     * @return owner's name
     */
    public String getName(){return this.name;}
    
    /** 
     * @return owner's phone number
     */
    public String getPhoneNumber(){return this.phoneNumber;}
    
    /** 
     * @param o second owner
     * @return true if the variable of two given owners have the same values
     */
    public boolean equals(Owner o){
        return this.getName().equals(o.getName()) && 
                this.getPhoneNumber().equals(o.getPhoneNumber());
    }
    
    @Override
    public String toString(){
        return " name: " + this.name + ", phone number: " + this.phoneNumber;
    }
}

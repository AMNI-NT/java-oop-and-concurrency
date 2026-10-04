
/**
 * This class represents a person
 * @author Amit
 */
public class Person implements Comparable<Person>{
    
    // person's id
    private int ID;
    
    // person's name
    private String name;
    
    // person's date of birth
    private String dateOfBirth;
    
    /**
     * constructor for Person class
     * @param ID person's id
     * @param name person's name
     * @param dateOfBirth person's date of birth
     */
    public Person(int ID, String name, String dateOfBirth){
        this.ID=ID;
        this.name=name;
        this.dateOfBirth=dateOfBirth;
    }

    /**
     * 
     * @return id of this person
     */
    public int getId(){return this.ID;}
    
    /** 
     * 
     * @param p given person
     * @return difference between this person's id and given person's id
     */
    @Override
    public int compareTo(Person p) { 
        return this.ID - p.getId();
    }
    

    // return this person's name
    public String getName() {
        return this.name;
    }
    
    // override toString() to display the person's details
    @Override
    public String toString() {
        return "\nID=" + ID + ", Name=" + name + ", DateOfBirth=" + dateOfBirth;
    }
    
}

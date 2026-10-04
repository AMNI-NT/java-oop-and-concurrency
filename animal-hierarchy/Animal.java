/**
 * This class represents an animal 
 * 
 * @author Amit
 */
public abstract class Animal implements Cloneable{
    
    // represent's animal's name
    protected String name;
    
    // represent's animal's age
    protected int age;
    
    // represent's animal's color
    protected String color;
    
    /**
     * constructor of Animal class 
     * @param name new Animal's name
     * @param age new Animal's age
     * @param color new Animal's color
     */
    public Animal(String name, int age, String color){
        this.name = name;
        this.age = age;
        this.color = color;
    }
    
    /**
     * returns animal's name
     * @return name
     */
    public String getName(){return this.name;}
    
    /**
     * returns animal's age
     * @return age
     */
    public int getAge(){return this.age;}
    
    /**
     * returns animal's color
     * @return color
     */
    public String getColor(){return this.color;}
    
    /**
     * Change's animal's name
     * @param name given name to be changed to
     */
    public void setName(String name){this.name = name;}
    
    /**
     * Changes animal's age
     * @param age given age to be changed to 
     */
    public void setAge(int age){this.age=age;}
    
    /**
     * Changes animal's color
     * @param color given color to be changed to
     */
    public void setColor(String color){this.color=color;}

    /**
     * returns this Animal's description as a string 
     * @return string representing animal
     */
    @Override
    public String toString(){
        return String.format("class: %s, name: %s, age %s, color: %s", 
                this.getClass().getName(),this.getName(), this.getAge(), this.getColor());
    }
    
    /**
     * checks if two objects are different or not
     * @param object given object
     * @return true if both animals are of the same class and their variables 
     *  have the same values
     */
    @Override
    public boolean equals(Object object){
        
        
        // boolean variable to chaneg to false if this and a are not equal
        boolean temp = true;
        
        // if this and a's classes are different then they are not equal
        if(!this.getClass().getName().equals(object.getClass().getName())) temp = false;
        
        Animal a = (Animal) object;
        
        // if this and a's names are different then they are not equal
        if(!this.getName().equals(a.getName())) temp = false;
        
        // if this and a's ages are different then they are not equal
        if(this.getAge() != a.getAge()) temp = false;
        
        // if this and a's colors are different then they are not equal
        if(!this.getColor().equals(a.getColor())) temp = false;
                
        return temp;
        
    }
    /**
     * This method makes this animal sleep
     */
    public void sleep(){
        System.out.println(this.name + " has slept.");
    }
    
    /**
     *
     * @return clone of this animal 
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
    
    
    
    /** 
     * makes this animal eat
     */
    public abstract void eat();

    
}

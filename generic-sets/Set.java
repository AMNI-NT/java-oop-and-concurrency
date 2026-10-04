import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Collectors;


/**
 * This class represents a set of objects
 * 
 * @author Amit
 * @param <E>
 */
public class Set<E>{
    
    // contains all items of this set
    private ArrayList<E> list;
    
    // return size of this set
    public int getSize(){return this.list.size();}
    
    /**
     * This method constructs a new empty set
     */
    public Set(){
        
        // initialize this set's ArrayList parameter
        list = new ArrayList<>();
    }
    
    /**
     * This method constructs a new set from an array of items
     * @param itemsArray given array of items
     */
    public Set(E[] itemsArray){
        
        // initialize this set's ArrayList parameter
        list = new ArrayList<>();
        
        // insert every item to array list (if item does not exist it will not be
        // added.
        for (E itemsArray1 : itemsArray) {
            insert(itemsArray1);
        }
    }
    
    /**
     * This method turns this set to union of this and given set 
     * @param set given set
     */
    public void union(Set<E> set){
        
        // iterator for given set
        Iterator<E> iterator = set.iterator();
        
        // insert every item in given set to this set
        while (iterator.hasNext()){
            this.insert(iterator.next());
        }
    }
    
    /**
     * This method turns this set to the intersection of this and given set
     * @param set given set
     */
    public void intersect(Set<E> set){
        
        // iterator for this set
        Iterator<E> iterator = this.iterator();
        
        // temporary variable to store items from this set
        E temp;
        
        // deletes every item in this set which does not exist in given set
        while(iterator.hasNext()){
            
            // save next item in temporary variable
            temp = iterator.next();
            
            // if current item is not in given set then delete it
            if(!set.isMember(temp)) iterator.remove();
        }
    }
    
    /**
     * @param item given object
     * @return true if object is member of this set
     */
    public boolean isMember(E item){
        try{
            // return true if this set's list contains given item
            return list.contains(item);
        }
        // if there are no items in set (NullPointerException) return false
        catch(NullPointerException e) {
            return false;
        }
    }
    
    /**
     * @param set
     * @return true if given set is a subset of this set
     */
    public boolean isSubset(Set<E> set){
        
        // iterator to scan given set
        Iterator<E> iterator = set.iterator();
        
        // iterate over items in given set and if an item contained in the given 
        // set does not exist in this set return false
        while(iterator.hasNext()){
            if(!isMember(iterator.next())) return false;
        }
        
        // no items exist in given set, that do not exist in array list, therefore
        // it is a subset. returns true
        return true;
    }
    
    
    /**
     * This method receives as item and adds it to this set. 
     * If item already exists method will do nothing
     * @param item given item to insert
     */
    public void insert(E item){
        
        // if item does not already exist in set add it 
        if(!isMember(item)){
            list.add(item);
        }
    }
    
    /**
     * This method receives as item and deletes from this set. 
     * If item does not exist in this set method will do nothing
     * @param item given item to be deleted
     */
    public void delete(E item){
         
        // if item exists in set delete it  
        if(isMember(item)){
            list.remove(item);
        }
    }
    
    /**
     * @return Iterator for set
     */
    public Iterator<E> iterator(){return list.iterator();}
    
    /**
     * @return string representation of this set
     */
    public String toString(){
        
        String[] s = list.stream().map(String::valueOf).toArray(String[]::new);
        
        return "(" + 
                // turn this set's array list to String array
                Arrays.stream(s) 
                        
                        // joing string array to string
                        .collect(Collectors.joining(", "))
                + ")";

    }
        
     
    
    
}

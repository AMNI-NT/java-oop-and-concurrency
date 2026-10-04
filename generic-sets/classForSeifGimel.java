
import java.util.Iterator;


/**
 *
 * @author Amit
 */
public class classForSeifGimel {
    
    public classForSeifGimel(){}
     
    /**
     * @param <E> type of set
     * @param set given set
     * @return minimal item from given set
     */
    public static <E extends Comparable<E>> E methodForSeifGimel(Set<E> set){

        // iterator for given set
        Iterator<E> iterator = set.iterator();

        // contains last read item from set
        E item = iterator.hasNext()? iterator.next(): null;
        
        // Contains minimal item found for every loop
        E minItem = item;
        
        // check every item in set
        while(iterator.hasNext()){
            
            // save next item
            item = iterator.next();
            
            // if next item is smaller than smallest so far update smallest
            if(minItem.compareTo(item) > 0) minItem = item;
        }
        
        // return minimal item
        return minItem;
    }
}

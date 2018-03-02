package code;
import java.util.Comparator;

/**
 * CSIS 2420
 * A03_AutoComplete assignment
 * @author David Jones and Mason Parry
 */
public class BinarySearchDeluxe 
{
	//Return the index of the first key in a[] that equals the search key, or -1 if no such key
	public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator)
	{
		if(a == null || key == null || comparator == null) throw new NullPointerException();
		
        int lo = 0;
        int hi = a.length - 1;
        
        while (lo <= hi)
        {
            int mid = lo + (hi - lo) / 2;
    		int v = comparator.compare(key, a[mid]);
    		
            if(v < 0)
        	{
            	hi = mid - 1;
        	}
            else if (v > 0)
        	{
        		lo = mid + 1;
        	}
            //if v == 0 we want to check to see if we iterated possibly all potential terms
            else if(lo != mid)
            {
            	hi = mid;
            }
            else
            {
            	return mid;	
            }
        }
        return -1;
	}
	
	//Return the index of the last key in a[] that equals the search key, or -1 if no such key
	public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator)
	{
		if(a == null || key == null || comparator == null) throw new NullPointerException();
        int lo = 0;
        int hi = a.length - 1;
        
        while (lo <= hi)
        {
            int mid = lo + (hi - lo) / 2;
    		int v = comparator.compare(key, a[mid]);
  		
            if(v < 0)
        	{
            	hi = mid - 1;
        	}
            else if (v > 0)
        	{
        		lo = mid + 1;
        	}
            //if v == 0 we want to check to see if we iterated possibly all potential terms
            else if( lo != mid)
            {
            	lo = mid;
            }
            else
            {
            	return mid;	
            }
        }
        return -1;
	}
}

package code;
import java.util.Comparator;
import edu.princeton.cs.algs4.BinarySearchST;

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
		
		BinarySearchST<Term, Integer> search = new BinarySearchST<Key, >();
		return -1;	
	}
	
	//Return the index of the last key in a[] that equals the search key, or -1 if no such key
	public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator)
	{
		if(a == null || key == null || comparator == null) throw new NullPointerException();
		return -1;
	}
}

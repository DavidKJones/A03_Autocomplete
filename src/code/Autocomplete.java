package code;

import java.util.Arrays;

/**
 * CSIS 2420
 * A03_AutoComplete assignment
 * @author David Jones and Mason Parry
 */
public class Autocomplete 
{
	private final Term[] allTerms;
	
	//Initialize the data structure from the give array of terms.
	public Autocomplete(Term[] terms)
	{
		if(terms == null)throw new NullPointerException();
		
		allTerms = terms;
		//sort the terms in natural order
		Arrays.sort(allTerms);
	}
	
	//Return all terms that start with the given prefix, in descending order of weight.
	public Term[] allMatches(String prefix)
	{
		if(prefix == null)throw new NullPointerException();
		
		//grab the first index
		int startingIndex = BinarySearchDeluxe.<Term>firstIndexOf(allTerms, new Term(prefix, 0), Term.byPrefixOrder(prefix.length()));
		
		int matchesCount = numberOfMatches(prefix);
		System.out.println("MATCHES : " + matchesCount);
		Term[] matchedTerms = new Term[matchesCount];
		
		//Check to see if there are any matches before we create the array
		for( int i = startingIndex; i < startingIndex + (matchesCount); i++)
		{
			matchedTerms[i - startingIndex] = allTerms[i];
		}
		
		//sort the autocomplete terms with reverse weight order
		Arrays.sort(matchedTerms, Term.byReverseWeightOrder());
		
		return matchedTerms;
	}
	
	//Return the number of terms that start with the given prefix
	public int numberOfMatches(String prefix)
	{
		if(prefix == null)throw new NullPointerException();
		Term t = new Term(prefix, 0);
		
		//grab both the first and last index
		int l = BinarySearchDeluxe.<Term>lastIndexOf(allTerms, t, Term.byPrefixOrder(prefix.length()));
		int f = BinarySearchDeluxe.<Term>firstIndexOf(allTerms, t, Term.byPrefixOrder(prefix.length()));
		
		//calculate the number of matches
		int n = l - f;
	
		//make sure we actually get the correct number of matches
		if(n > 0)
			n++;
		
		return n;
	}
}

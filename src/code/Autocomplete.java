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
		
		int matchesCount = numberOfMatches(prefix);
		
		Term[] matchedTerms = new Term[matchesCount];
		
		//grab the first index
		int startingIndex = BinarySearchDeluxe.<Term>firstIndexOf(allTerms, new Term(prefix, 0), Term.byPrefixOrder(prefix.length()));
		
		//Check to see if there are any matches before we create the array
		if(matchesCount > 0)
			for( int i = 0; i < matchesCount; i++)
			{
				matchedTerms[i] = allTerms[startingIndex + i];
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
		
		if(l == -1 || f == -1)
			return 0;
		
		if(l == f)
			return 1;
		else if( l - f == 1)
			return 2;
		else
			return l-f;
	}
}

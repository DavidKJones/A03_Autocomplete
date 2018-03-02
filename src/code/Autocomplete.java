package code;

import java.util.Arrays;

/**
 * CSIS 2420
 * A03_AutoComplete assignment
 * @author David Jones and Mason Parry
 */
public class Autocomplete 
{
	private final Term[] terms;
	
	//Initialize the data structure from the give array of terms.
	public Autocomplete(Term[] terms)
	{
		if(terms == null)throw new NullPointerException();
		
		this.terms = terms;
		//sort the terms in natural order
		Arrays.sort(this.terms);
	}
	
	//Return all terms that start with the given prefix, in descending order of weight.
	public Term[] allMatches(String prefix)
	{
		if(prefix == null)throw new NullPointerException();
		
		//grab the first index
		int startingIndex = BinarySearchDeluxe.<Term>firstIndexOf(terms, new Term(prefix, 0), Term.byPrefixOrder(prefix.length()));
		
		int matchesCount = numberOfMatches(prefix);
		Term[] matchedTerms = new Term[matchesCount];
		
		//Check to see if there are any matches before we create the array
		for( int i = 0; i < matchesCount; i++)
		{
			matchedTerms[i] = terms[startingIndex + i];
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
		//last index - first index will give us the number of matches
		return BinarySearchDeluxe.<Term>lastIndexOf(terms, t, Term.byPrefixOrder(prefix.length())) - BinarySearchDeluxe.<Term>firstIndexOf(terms, t, Term.byPrefixOrder(prefix.length())); 
	}
}

package code;

import java.util.Arrays;

/**
 * CSIS 2420
 * A03_AutoComplete assignment
 * @author David Jones and Mason Parry
 */
public class Autocomplete 
{
	private Term[] terms;
	
	//Initialize the data structure from the give array of terms.
	public Autocomplete(Term[] terms)
	{
		if(terms == null)throw new NullPointerException();
		
		this.terms = terms;
	}
	
	//Return all terms that start with the given prefix, in descending order of weight.
	public Term[] allMatches(String prefix)
	{
		if(prefix == null)throw new NullPointerException();
		
		Arrays.sort(terms);
		
		int matchCount = numberOfMatches();
		Term[] matchedTerms = (Term[])new Object[matchCount];	
		int startingIndex = BinarySearchDeluxe.firstIndexOf(terms, prefix, Term.byPrefixOrder());
		
		for(int i = 0; i < matchCount; i++) 
		{
			matchedTerms[i] = (Term)terms[startingIndex + startingIndex]; 
		}
		
		Arrays.sort(matchedTerms, Term.byReverseWeightOrder());
		
		return matchedTerms;
	}
	
	//Return the number of terms that start with the given prefix
	public int numberOfMatches(String prefix)
	{
		if(prefix == null)throw new NullPointerException();		
		return BinarySearchDeluxe.lastIndexOf(terms, prefix, Term.byPrefixOrder()) - BinarySearchDeluxe.firstIndexOf(terms, prefix, Term.byPrefixOrder());
	}
}

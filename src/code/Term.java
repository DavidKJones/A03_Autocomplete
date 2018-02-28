package code;
/**
 * CSIS 2420
 * A03_AutoComplete Assignment
 * @author David Jones & Mason Parry
 */

import java.util.Comparator;

public class Term implements Comparable<Term> {
	// fields
	private String query;
	private double weight;
	
    // Initialize a term with the given query string and weight.
    public Term(String query, double weight) {
        if (query == null) {
            throw new java.lang.NullPointerException();
        }
        if (weight < 0) {
            throw new java.lang.IllegalArgumentException();
        }
    	this.query = query;
    	this.weight = weight;
    }

    // Compare the terms in descending order by weight.
    public static Comparator<Term> byReverseWeightOrder() {
    	return new Comparator<Term>() {
            public int compare(Term t1, Term t2) {
            	return (int)((t1.weight-t2.weight)*-1);
            } 
    	};
    }
    
    // Compare the terms in lexicographic order but using only the first r characters of each query.
    public static Comparator<Term> byPrefixOrder(int r) {
    	return new Comparator<Term>() {
            public int compare(Term t1, Term t2) {
            	return (t1.query.substring(0, r).compareTo(t2.query.substring(0, r)));
            } 
    	};
    }

    // Compare the terms in lexicographic order by query.
    public int compareTo(Term that) {
    	return(this.query.compareTo(that.query));
    }

    // Return a string representation of the term in the following format:
    // the weight, followed by a tab, followed by the query.
    public String toString() {
    	return Double.toString(this.weight) + "\t" + this.query;
    }
}
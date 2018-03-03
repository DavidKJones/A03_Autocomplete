/******************************************************************************
 *  Name:     David Jones & Mason Parry
 *  NetID:    
 *  Precept:  
 *
 *  Partner Name:       Mason Parry & David Jones
 *  Partner NetID:      
 *  Partner Precept:    
 *
 *  Hours to complete assignment (optional): a lot
 *
 ******************************************************************************/

Programming Assignment 3: Autocomplete


/******************************************************************************
 *  Describe how your firstIndexOf() method in BinarySearchDeluxe.java
 *  finds the first index of a key that equals the search key.
 *****************************************************************************/

It uses a comparator to compare they key to the value in the array, at first it compares the key to the middle. And because
the keys are sorted we know which way to look (higher or lower). And from there we determine our new low, mid, and high and
search again until they key matches the value in the array.

/******************************************************************************
 *  What is the order of growth of the number of compares (in the
 *  worst case) that each of the operations in the Autocomplete
 *  data type make, as a function of the number of terms n and the
 *  number of matching terms m?
 *
 *  Recall that with order-of-growth notation, you should discard
 *  leading coefficients and lower-order terms, e.g., m^2 + m log n.
 *****************************************************************************/

constructor: N^2 //java uses quicksort so worst case is N^2

allMatches(): M N^2 //the number of matches is equal to N but we do another sort so N is N^2

numberOfMatches(): log (N) //becuase the compares get smaller




/******************************************************************************
 *  Known bugs / limitations.
 *****************************************************************************/

The queries don't line up if the weight differs by a decimal point. A limitation is that
you have to provide the number of queries so it can't be dynamic.

/******************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings, lectures, and precepts, but do
 *  include any help from people (including course staff, lab TAs,
 *  classmates, and friends) and attribute them by name.
 *
 *  Also include any resources (including the web) that you may
 *  may have used in creating your design.
 *****************************************************************************/


/******************************************************************************
 *  Describe any serious problems you encountered.                    
 *****************************************************************************/

Creating a dataset from the Internet Movie Database was a hassel due to how large it is. I
had to use several programs just to get it open to edit it. Then it was even worst
when trying to export it into a format the program accepts.

/******************************************************************************
 *  If you worked with a partner, assert below that you followed
 *  the protocol as described on the assignment page. Give one
 *  sentence explaining what each of you contributed.
 *****************************************************************************/

David Jones: BinarySearchDeluxe, Autocomplete

Mason Parry: AutocompleteGUI, Term, Extra credit
I created the term class and did the extra credit.


/******************************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.                                             
 *****************************************************************************/

  
/******************************************************************************
*	Extra Credit
*******************************************************************************/
EC1. I created a dataset of movies by their running time in minutes. It has 478990
	 queries after being filtered.
	 The link to the original dataset can be found here: https://datasets.imdbws.com/title.basics.tsv.gz
	 
EC2. I changed autocompleteGUI so that the search bar and sugggestions now scale 
	 with the window. I also moved the weight to the left to match how it appears
	 in the text file. 
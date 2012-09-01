import java.util.Arrays;


public class Reverse {

	/*
	 * Now, write a recursive solution to reverse without using any helpers.
	 */
	
	
	public String[] reverse (String[] s) {
		
		// first test for the base case
		if (  ) {
			// solve the base case without using recursion
			
		} else {
			// ah, the recursive case!  Use recursion here
			
		}
		
	}
	
	
	
	
	// include this, or have them just use junit?
	public static void main(String[] args) {
		// you might do some testing in here
		Reverse obj = new Reverse();
		
		String[] test1 = {"a", "test", "array"};
		System.out.println(Arrays.toString(test1) + " --> " + obj.reverse(test1));
	}
	
	
	
	
	//////// HELPER METHODS YOU MIGHT FIND USEFUL
	
	// returns a new array of Strings containing all the entries except the first
	// e.g., allButFirst( {"joe", "bob", "briggs"} )   ==>   {"joe", "bob"}
	public static String[] allButFirst(String[] s) {
		return Arrays.copyOfRange(s, 1, s.length);
	}
	
	// returns a new array of Strings containing all the entries except the last
	// e.g., allButLast( {"joe", "bob", "briggs"} )   ==>   {"bob", "briggs"}
	public static String[] allButLast(String[] s) {
		return Arrays.copyOfRange(s, 0, (s.length-1));
	}
	
	// returns a new array of strings by copying the given array and adding one cell at beginning.  
	// e.g., addAtFront("a", {"b", "c", "d"})  ==> {"a", "b", "c", "d"}
	public static String[] addAtFront(String element, String[] s) {
		String[] ret = new String[1 + s.length];
		ret[0] = element;
		System.arraycopy(s, 0, ret, 1, s.length);
		return ret;
	}
	
	// returns a new array of strings by copying the given array and adding one cell at the end.
	// e.g., addAtEnd({"a", "b", "c"},  "d")   ==>  { "a", "b", "c", "d"}
	public static String[] addAtEnd(String[] s, String element) {
		String[] ret = new String[s.length + 1];
		System.arraycopy(s, 0, ret, 0, s.length);
		ret[s.length] = element;
		return ret;
	}
}

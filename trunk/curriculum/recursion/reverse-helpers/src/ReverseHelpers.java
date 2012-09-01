import java.util.Arrays;

/* 
 * Consider the problem of using recursion returning the reverse of a given Array of Strings.  
 * Recursion means no for or while loops! To make a recursive solution easy to understand, 
 * we are going to write separate methods for different length arrays.
 * "reverse2", for instance, reverses an array of length 2.
 */
public class ReverseHelpers {

	// returns the reverse of a one-length array.  Easy!
	public String[] reverse1 (String[] s) {
		String[] rev = new String[1];   // make a copy
		rev[0] = s[0];
		return rev;
	}
	
	//returns the reverse of a two-length array.
	public String[] reverse2 (String[] s) {
		String[] rev = new String[2];
		rev[0] = s[1];
		rev[1] = s[0];
		return rev;
	}
	
	//returns the reverse of a three-length array.
	public String[] reverse3 (String[] s) {
		String[] rev = new String[3];
		rev[0] = s[2];
		rev[1] = s[1];
		rev[2] = s[0];
		return rev;
	}
	
	
	
	// REWRITE reverse4, making a call to reverse3.  
	// DO NOT use the same strategy as reverse1, reverse2, or reverse3 !
	public String[] reverse4 (String[] s) {
		String[] rev = new String[4];

	
		
		return rev;
	}
	
	
	
	
	public static void main(String[] args) {
		// you might do some testing in here
		ReverseHelpers obj = new ReverseHelpers();
		
		String[] test1 = {"a", "big", "test", "array"};
		System.out.println(Arrays.toString(test1) + " --> " + obj.reverse4(test1));
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

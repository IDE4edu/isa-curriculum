package reverse;
import java.util.Arrays;


public class Reverse {

	/*
	 * Now, write a recursive solution to reverse without using any helper methods.
	 * That is, reverse should only call reverse! (and some string manipulation methods).
	 */
	
	
	public String reverse (String s) {

		// first test for the base case
		if (    ) {
			// solve the base case without using recursion
			
			
		} else {
			// ah, the recursive case!  Use recursion here
			
			
		}
		
	}
	
	
	
	
	// include this, or have them just use junit?
	public static void main(String args) {
		// you might do some testing in here
		Reverse obj = new Reverse();
		
		String test1 = "abracadabra";
		System.out.println(test1 + " --> " + obj.reverse(test1));
	}
	
	
	
	
	//////// HELPER METHODS YOU MIGHT FIND USEFUL
	
	// returns a string containing all the characters except the first
	public static String allButFirst(String s) {
		return s.substring(1);
	}
	
	// returns a string  containing all the characters except the last
	public static String allButLast(String s) {
		return s.substring(0, s.length());
	}
	
}

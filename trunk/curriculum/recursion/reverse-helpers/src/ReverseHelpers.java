

/* 
 * Consider the problem of using recursion to reverse a string.  
 * Recursion means no for or while loops! To make a recursive solution easy to understand, 
 * we are going to write separate methods for different length strings.
 * "reverse2", for instance, reverses a string of length 2.
 */
public class ReverseHelpers {

	// returns the reverse of a one-length string.  Easy!
	public String reverse1 (String s) {
		return s;
	}
	
	//returns the reverse of a two-length string.
	public String reverse2 (String s) {
		return (s.substring(1,2) + 
				s.substring(0,1));
	}
	
	//returns the reverse of a three-length string.
	public String reverse3 (String s) {
		return (s.substring(2,3) +
				s.substring(1,2) + 
				s.substring(0,1));
	}
	
	
	
	// REWRITE reverse4, making a call to reverse3.  
	// DO NOT use the same strategy as reverse1, reverse2, or reverse3 !
	public String reverse4 (String s) {

		//return s.substring(3,4) + reverse3(allButLast(s));
		return "";
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

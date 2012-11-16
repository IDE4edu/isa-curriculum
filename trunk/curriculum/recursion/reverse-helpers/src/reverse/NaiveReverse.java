package reverse;

/* 
 * Some naive solutions to reverse a string.
 * You should write reverse6 below.
 */
public class NaiveReverse {

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
	
	
	// ... reverse4 and reverse5 would be similar
	
	
	// WRITE reverse6, which takes a String of length 6 and returns its reverse
	public String reverse6 (String s) {
		
		
		
	}
	
	
	// ... and more could go here... reverse612 would be awfully long...


	

}

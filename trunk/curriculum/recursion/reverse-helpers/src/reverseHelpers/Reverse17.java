package reverseHelpers;

public class Reverse17 extends Reverse16 {

	
	//public String reverse16 (String s) {
		// this is written in the hidden parent class, don't fret 
	//}
	
	
	// WRITE reverse17 by using reverse16
	public String reverse17 (String s) {
		
		
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
	
	
	
	
	// Use this to test your reverse17 method by running this class manually
	public static void main(String[] args) {
		Reverse17 obj = new Reverse17();
		System.out.println(obj.reverse17("disinterestedness"));
		System.out.println(obj.reverse17("uniformitarianism "));
		System.out.println(obj.reverse17("pseudohydrophobia"));
	}
	
}

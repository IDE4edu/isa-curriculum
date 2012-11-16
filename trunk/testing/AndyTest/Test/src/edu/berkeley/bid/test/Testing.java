package edu.berkeley.bid.test;

public class Testing {

	
	public static void tryRecursion (int i ) {
		System.out.println ("I'm here " + i);
		tryRecursion (i + 1 );
	}

	
	public static String tryRecursion2() {
		return "again!" + tryRecursion2();
	}
	
	
	
	public static void main (String [ ] args) {
		tryRecursion (1 );
	}

}

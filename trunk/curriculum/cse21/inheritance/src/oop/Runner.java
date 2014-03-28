package oop;

public class Runner {

	public static void main(String[] args) {
		testCounter();

		// testCyclicCounter();
	}

	
	
	public static void testCounter() {
		
		Counter c = new Counter ( );
		c.increment ( );
		System.out.println (c.value ( ));

		
	}
	
	
	
	
	public static void testCounter7Statements() {
		Counter c = new Counter();
		// include exactly 7 increment() and reset() statements below

		
		// check if the value is 3
		if (c.value() == 3) {
			System.out.println("Value is 3, good job");
		} else {
			System.out.println("Value should be 3, but it is" + c.value());
		}
	}
	

	
	
	

}

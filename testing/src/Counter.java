
public class Counter {
	
	private int myValue;
	
	public Counter ( ) {
		myValue = 0;
	}
	
	public int value ( ) {
		return myValue;
	}

	public void reset ( ) {
		myValue = 0;
	}
	
	public void increment ( ) {
		myValue++;
	}
	
	/**
	 * @param args
	 */
	public static void main (String [ ] args) {
		Counter c = new Counter ( );
		c.increment ( );
		System.out.println ("Counter value = " + c.value ( ));

	}

}

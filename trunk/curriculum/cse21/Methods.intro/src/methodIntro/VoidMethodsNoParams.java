package methodIntro;

// Change main() so that it calls two of the other methods and 
// produces "CBB" as output.
// Click "Test" in your navigator below to see if you got it right.

public class VoidMethodsNoParams {

	public static void m1 ( ) {
		System.out.println ("A");
	}

	public static void m2 ( ) {
		System.out.println ("B");
	}

	public static void m3 ( ) {
		System.out.println ("C");
		m2 ( );
	}

	public static void main (String [ ] args) {
		// change these calls here.  Don't put System.out.println calls in here!
		m1 ( );
		m3 ( );
	}
}

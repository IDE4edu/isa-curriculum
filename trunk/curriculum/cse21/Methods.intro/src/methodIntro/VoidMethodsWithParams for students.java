package methodIntro;

public class VoidMethodsWithParams {

	public static void m1 (int lineCount) {
		System.out.println ("A");
	}

	public static void m2 (int lineCount) {
		System.out.println ("B");
		m1 ( 100 );	// will be changed
	}

	public static void main (String [ ] args) {
		m1 ( 100 );	// should be changed
		m2 ( 100 );	// should be changed
	}
}

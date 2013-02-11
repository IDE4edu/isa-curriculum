package methodIntro;

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
//		m1 ( );
//		m3 ( );
		m3 ( );
		m2 ( );
	}
}

package methodIntro;

public class VoidMethodsWithParams {

	public static void m1 (int lineCount) {
		for (int k=0; k<lineCount; k++) {
			System.out.println ("A");
		}
	}

	public static void m2 (int lineCount) {
		for (int k=0; k<lineCount; k++) {
			System.out.println ("B");
			m1 ( 1 );
		}
	}

	public static void main (String [ ] args) {
		m1 ( 3 );
	}
}

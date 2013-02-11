package methodIntro;

public class TypedMethods {

	public static int silly (int n1, int n2) {
		return 2 * n1 + n2;
	}

	public static void main (String [ ] args) {
		System.out.println (silly (3, 5));
	}

// First exercise:
//	public static void main (String [ ] args) {
//		System.out.println (silly (1, 5));
//	}

// Second exercise:
//	public static void main (String [ ] args) {
//		System.out.println (silly (-5, silly (3, 5)));
//	}
	
// Third exercise:
//	public static void main (String [ ] args) {
//		System.out.println (silly (5, silly (-6, 3)));
//	}

}

package recursion;

/*  This recursive method is a slightly augmented 
	version of the program in the last step: it only makes a recursive
	call under certain conditions.   There are three calls that print to the 
	console.  See if you can predict what will get printed and in what order.
 */
public class SimpleRecursion {

	// version 1
	public static void recur(int k) {
		System.out.println("Entering recur with k = " + k);
		if (k <= 3) {
			System.out.println("Recursing with k = " + k);
			recur(k + 1);
		}
		System.out.println("Leaving recur with k = " + k);
	}

	/*
	// version 2
	public static void recur (int k) {
		System.out.println ("count = " + k);
		if (k != 5) {
			recur (k+1);
		}
	}
	
	// version 3
	public static void recur (int k) {
		if (k == 5) {
			System.out.println ("count = " + k);
			recur (k+1);
		}
	}

	// version 4
	public static void recur (int k) {
		if (k < 5) {
			System.out.println ("count = " + k);
			recur (k+1);
		}
	}

	// version 5
	public static void recur (int k) {
		System.out.println ("count = " + k);
		if (k == 5) {
			recur (k+1);
		}
	}
	
	// version 6
	public static void recur (int k) {
		if (k != 5) {
			System.out.println ("count = " + k);
			recur (k+1);
		}
	}
	
	*/
	public static void main(String[] args) {
		recur(0);
	}
}

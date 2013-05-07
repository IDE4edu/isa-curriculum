package recursionIntroduction;

/*  This recursive method is a slightly augmented 
	version of the program in the last step: it only makes a recursive
	call under certain conditions.   There are three calls that print to the 
	console.  See if you can predict what will get printed and in what order.
*/
public class SimpleRecursionTest {

	public static void main(String[] args) {
		recur(0);
	}

	public static void recur(int k) {
		System.out.println("Entering recur with k = " + k);
		if (k <= 3) {
			System.out.println("Recursing with k = " + k);
			recur(k + 1);
		}
		System.out.println("Leaving recur with k = " + k);
	}
}

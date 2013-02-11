package methodIntro;

// Exercise 1: 
// Add a loop to m1 so that the number of "A"s printed
// is equal to lineCount.

// Exercise 2:
// Modify m2 so that the total number of lines printed is equal to lineCount, with
// half the lines printed containing an "A" and the other half containing a "B". 
// If lineCount is odd, the number of "B"s printed should be 1 less than the number of "A"s.
// For example, 
//  	m2 (4)
// should print 2 "B"s and 2 "A"s, and
//  	m2 (7)
// should print 3 "B"s and 4 "A"s.  The order of the "B"s and "A"s aren't important.

// Test your solutions by clicking the 'test' button, or by manually changing main.

public class VoidMethodsWithParams {

	public static void m1(int lineCount) {
		System.out.println("A");
	}

	public static void m2(int lineCount) {
		System.out.println("B");
		m1(1);
	}

	public static void main(String[] args) {
		// change these lines to test your solutions manually
		m1(5);
		m2(5);
	}
}

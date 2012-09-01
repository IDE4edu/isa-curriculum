import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Stack;
import org.junit.Test;


public class ReverseTest {

	// keeps track of reverse calls, to test whether reverse calls itself
	class ReverseChild extends Reverse {
		public Stack<String[]> calls = new Stack<String[]>();
		public String[] reverse (String[] s) {
			calls.push(s);
			String[] ret = super.reverse(s);
			return ret;
		}
	}
	
	// tests whether reverse makes use of its own return value.
	// do we really need this?  It would be hard to write something that calls itself
	// recursively but then doesn't use the result!
	class ReverseBrokenChild extends Reverse {
		public String[] initialParam;
		// this class breaks reverse3, to make sure the student is using it.
		public String[] reverse (String[] s) {
			if (Arrays.equals(initialParam, s)) {
				// we are in the initial call -- let it try once
				return super.reverse(s);
			} else {
				// break it here by returning value unchanged
				return Arrays.copyOf(s, s.length);
			}
		}
	}

	
	private String[] real_reverse(String[] s) {
		String[] ret = Arrays.copyOf(s, s.length);
		// who would ever do this recursively!?!
		for(int i = 0; i < (ret.length / 2); i++) {
		    String temp = ret[i];
		    ret[i] = ret[s.length - i - 1];
		    ret[ret.length - i - 1] = temp;
		}
		return ret;
	}



	String[] sa1 = {"a", "b", "c"};
	String[] sa2 = {"the", "rain", "in", "Spain", "falls", "public static void main"};
	String[] sa3 = {"omg"};
	String[] sa4 = {"one", "two", "three", "four", "five", "six", "7", "8", "9", "10"};
	


	@Test
	public void correct1() {
		correctHelper(sa1);
	}
	
	public void correctHelper(String[] init) {
		Reverse r = new Reverse();
		String[] out = r.reverse(Arrays.copyOf(init, init.length));
		assertTrue("Your reverse method didn't correctly reverse the array " 
				 	+ Arrays.toString(init)
				 	+ ".  It returned " 
				 	+ Arrays.toString(out)
				 	+ " instead.",
				 	Arrays.equals(out, real_reverse(init)));
	}

	@Test
	public void correct2() {
		correctHelper(sa2);
	}
	
	@Test
	public void correct3() {
		correctHelper(sa3);
	}
	
	@Test
	public void correct4() {
		Reverse r = new Reverse();
		String[] out = r.reverse(Arrays.copyOf(sa4, sa4.length));
		assertTrue("Your reverse method didn't correctly reverse an array that we won't show you. " 
				 	+ "  There must still be a bug!",
				 	Arrays.equals(out, real_reverse(sa4)));
	}

	@Test
	public void correct_empty() {
		Reverse r = new Reverse();
		String[] empty = new String[0];
		try {
			String[] out = r.reverse(empty);
			assertNull("Your reverse method didn't correctly handle an empty array as input: it didn't return an empty array!",
					out);
		} catch (Exception e) {
			fail("Your reverse method broke when passed an empty array!");
		}

	}
	
	
	@Test
	public void uses_recursion() {

		//todo

	}
	

	
}

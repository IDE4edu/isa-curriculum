import static org.junit.Assert.*;

import java.util.Stack;
import org.junit.Test;


public class ReverseTest {

	// keeps track of reverse calls, to test whether reverse calls itself
	class ReverseChild extends Reverse {
		public Stack<String> calls = new Stack<String>();
		public String reverse (String s) {
			calls.push(s);
			String ret = super.reverse(s);
			return ret;
		}
	}
	
	// tests whether reverse makes use of its own return value.
	// do we really need this?  It would be hard to write something that calls itself
	// recursively but then doesn't use the result!
	class ReverseBrokenChild extends Reverse {
		public String initialParam;
		// this class breaks reverse3, to make sure the student is using it.
		public String reverse (String s) {
			if (s.equals(initialParam)) {
				// we are in the initial call -- let it try once
				return super.reverse(s);
			} else {
				// break it here by returning value unchanged
				return s;
			}
		}
	}

	
	private String real_reverse(String s) {
		return new StringBuffer(s).reverse().toString();
	}	



	String s1 = "abcde";
	String s2 = "public static void pain";
	String s3 = "Z";
	String s4 = "Computing science is no more about computers than astronomy is about telescopes -- Edsger W. Dijkstra";
	


	@Test
	public void correct1() {
		correctHelper(s1);
	}
	
	public void correctHelper(String init) {
		Reverse r = new Reverse();
		String out = r.reverse(init);
		assertTrue("Your reverse method didn't correctly reverse the string \"" 
				 	+ init
				 	+ "\".  It returned \"" 
				 	+ out
				 	+ "\" instead.",
				 	out.equals(real_reverse(init)));
	}

	@Test
	public void correct2() {
		correctHelper(s2);
	}
	
	@Test
	public void correct3() {
		correctHelper(s3);
	}
	
	@Test
	public void correct4() {
		Reverse r = new Reverse();
		String out = r.reverse(s4);
		assertTrue("Your reverse method didn't correctly reverse a string that we won't reveal to you. " 
				 	+ "  There must still be a bug!",
				 	out.equals(real_reverse(s4)));
	}

	@Test
	public void correct_empty() {
		Reverse r = new Reverse();
		String empty = "";
		try {
			String out = r.reverse(empty);
			assertEquals("Your reverse method didn't correctly handle an empty string as input: it didn't return an empty string!",
					out, "");
		} catch (Exception e) {
			fail("Your reverse method broke when passed an empty string!");
		}

	}
	
	
	@Test
	public void uses_recursion() {

		ReverseChild rc = new ReverseChild();
		rc.reverse(s4);
		assertTrue("Your reverse method never calls itself.  It isn't recursive!",
				(rc.calls.size() > 1));
		//todo

	}
	

	
}

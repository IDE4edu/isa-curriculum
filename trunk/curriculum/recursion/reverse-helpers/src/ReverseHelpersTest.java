import static org.junit.Assert.*;

import java.util.Stack;
import org.junit.Test;


public class ReverseHelpersTest {

	// this class tracks use of reverse3, to make sure student is calling it
	class ReverseHelpersChild extends ReverseHelpers {
		public Stack<String> r3calls = new Stack<String>();
		public String reverse3 (String s) {
			r3calls.push(s);
			String ret = super.reverse3(s);
			return ret;
		}
	}
	
	// this class breaks reverse3, to make sure the student is using its return value.
	class ReverseHelpersBrokenChild extends ReverseHelpers {
		public String reverse3 (String s) {
			// passing it unchanged.  probably randomizing it would be better, eh.
			return s;
		}
	}

	
	
	private String real_reverse(String s) {
		return new StringBuffer(s).reverse().toString();
	}	

	
	
//  //Not sure what to test here -- that reverse3 still reverses a 3 element array?	 
//	// Would a student really change reverse3 to get reverse4 to work?
//	@Test
//	public void testReverse3() {
//		fail("Not yet implemented");
//	}
//	
	
	

	String sa1 = "abcd";
	String sa2 = "yefc";
	


	@Test
	public void correct() {

		ReverseHelpers rh = new ReverseHelpers();
		String out1 = rh.reverse4(sa1);
		assertTrue("Your reverse4 method didn't correctly reverse the string \"" 
				 	+ sa1
				 	+ "\".  It returned " 
				 	+ out1
				 	+ " instead.",
				 	out1.equals(real_reverse(sa1)));
		String out2 = rh.reverse4(sa2);
		assertTrue("While your reverse4 correctly reversed the string \"" 
			 	+ sa1
			 	+ "\", it was incorrect when reversing a different 4-length string.  There must still be a bug! " ,
			 	out2.equals(real_reverse(sa2)));
	}
	
	@Test
	public void uses_reverse3() {

		ReverseHelpersChild rhc = new ReverseHelpersChild();
		rhc.reverse4(sa1);
		int r3calls1 = rhc.r3calls.size();
		rhc.r3calls.removeAllElements();
		rhc.reverse4(sa2);
		int r3calls2 = rhc.r3calls.size();
		rhc.r3calls.removeAllElements();
		
		// check if reverse3 wasn't called
		assertTrue("Reverse3 is never called!  Remember, you need to write reverse4 such that it calls reverse3 to do its work.", 
				((r3calls1 > 0) && (r3calls2 > 0)));
		
		// check if reverse3 is actually used
		ReverseHelpersBrokenChild broken = new ReverseHelpersBrokenChild();
		// these should be false
		boolean result1 = broken.reverse4(sa1).equals(real_reverse(sa1));
		boolean result2 = broken.reverse4(sa2).equals(real_reverse(sa2));
		assertFalse("Hey, reverse4 isn't making use of the reversed 3-length string that reverse3 returns! Don't just call it and ignore it; you need to use the result to solve reverse4!", 
				result1 && result2);
	}
	

	
}

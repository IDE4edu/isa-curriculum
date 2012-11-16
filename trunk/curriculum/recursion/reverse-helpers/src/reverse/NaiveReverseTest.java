package reverse;
import static org.junit.Assert.*;

import org.junit.Test;


public class NaiveReverseTest {

	// we'd like to ensure they don't have any loops, and no use of regular Java reverse...
	
	private String real_reverse(String s) {
		return new StringBuffer(s).reverse().toString();
	}	

	
	


	
	

	@Test
	public void reverse_abcdef() {
		String tst = "abcdef";
		
		NaiveReverse nr = new NaiveReverse();
		String obs = nr.reverse6(tst);
		String exp = real_reverse(tst);
		assertEquals("Your reverse6 method didn't work correctly", obs, exp);
	}
	
	@Test
	public void reverse_lolwtf() {
		String tst = "lolwtf";
		
		NaiveReverse nr = new NaiveReverse();
		String obs = nr.reverse6(tst);
		String exp = real_reverse(tst);
		assertEquals("Your reverse6 method didn't work correctly", obs, exp);
	}
	
	
	@Test
	public void reverse_hidden1() {
		String tst = "yefcZu";
		NaiveReverse nr = new NaiveReverse();
		String obs = nr.reverse6(tst);
		String exp = real_reverse(tst);
		assertTrue("Your reverse6 didn't correctly reverse other 6-length strings. " ,
			 	obs.equals(exp));
	}
	

	

	
}

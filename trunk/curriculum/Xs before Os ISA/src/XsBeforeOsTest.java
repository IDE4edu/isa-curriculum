import java.util.Arrays;

import junit.framework.TestCase;

public class XsBeforeOsTest extends TestCase {
	
	// tests for one-element array
	public void test1elems ( ){
		char [ ] [ ] tests = {{'X'}, {'O'}};
		char [ ] [ ] solns = {{'X'}, {'O'}};
		for (int k=0; k<tests.length; k++) {
			XsBeforeOs.rearrange (tests[k]);
			assertTrue ("fails for one-element array", Arrays.equals (tests[k], solns[k]));			
		}
	}
	
	// tests for two-element arrays
	public void test2elems ( ) {
		char [ ] [ ] tests = {{'X','X'}, {'X','O'}, {'O','X'}, {'O','O'}};
		char [ ] [ ] solns = {{'X','X'}, {'X','O'}, {'X','O'}, {'O','O'}};
		for (int k=0; k<tests.length; k++) {
			XsBeforeOs.rearrange (tests[k]);
			assertTrue ("fails for " + toString (tests[k]), Arrays.equals (tests[k], solns[k]));			
		}
	}
	
	// tests for four-element arrays
	public void test4elems ( ) {
		char [ ] [ ] tests = {{'O','O','O','O'}, {'X','X','X','X'}, 
				{'X','O','O','O'}, {'O','X','O','O'}, {'O','O','X','O'}, {'O','O','O','X'}, 
				{'O','X','X','X'}, {'X','O','X','X'}, {'X','X','O','X'}, {'X','X','X','O'},
				{'X','X','O','O'}, {'O','X','X','O'}, {'O','O','X','X'}, {'X','O','O','X'}, {'X','O','X','O'}, {'O','X','O','X'}};
		char [ ] [ ] solns = {{'O','O','O','O'}, {'X','X','X','X'}, 
				{'X','O','O','O'}, {'X','O','O','O'}, {'X','O','O','O'}, {'X','O','O','O'}, 
				{'X','X','X','O'}, {'X','X','X','O'}, {'X','X','X','O'}, {'X','X','X','O'},
				{'X','X','O','O'}, {'X','X','O','O'}, {'X','X','O','O'}, {'X','X','O','O'}, {'X','X','O','O'}, {'X','X','O','O'}};
		for (int k=0; k<tests.length; k++) {
			XsBeforeOs.rearrange (tests[k]);
			assertTrue ("fails for " + toString (tests[k]), Arrays.equals (tests[k], solns[k]));			
		}
	}
	
	// tests of one-element arrays
	public void testIsOK1 ( ) {
		char [ ] [ ] tests = {{'X'}, {'O'}};
		for (int k=0; k<tests.length; k++) {
			assertTrue ("fails for one-element array", XsBeforeOs.isOK (tests[k], 0));			
		}
	}
	
	// tests of two-element arrays
	public void testIsOK2 ( ) {
		char [ ] [ ] tests = {{'X','X'}, {'X','O'}, {'O','X'}, {'O','O'}};
		boolean [ ] solns = {true, true, false, true};
		for (int k=0; k<tests.length; k++) {
			assertEquals ("fails for " + toString (tests[k]), XsBeforeOs.isOK (tests[k], 1), solns[k]);			
		}
	}
	
	// tests of four-element arrays
	public void testIsOK3 ( ) {
		char [ ] [ ] tests = {{'X','X','X','X'}, {'X','X','O','X'}, {'X','O','X','X'}, {'X','O','O','X'},
				{'O','X','X','X'}, {'O','X','O','X'}, {'O','O','X','X'}, {'O','O','O','X'}};
		boolean [ ] k2solns = {true, true, false, true, false, false, false, true};
		boolean [ ] k3solns = {true, false, false, false, false, false, false, false};
		for (int k=0; k<tests.length; k++) {
			assertEquals ("fails for " + toString (tests[k]), XsBeforeOs.isOK (tests[k], 2), k2solns[k]);
			assertEquals ("fails for " + toString (tests[k]), XsBeforeOs.isOK (tests[k], 3), k3solns[k]);
		}
	}
	
	private static String toString (char [ ] values) {
		String rtn = "{ ";
		for (int k=0; k<values.length; k++) {
			rtn = rtn + values[k] + " ";
		}
		return rtn + "}";
	}
}

import java.util.Arrays;

import junit.framework.TestCase;

public class XsBeforeOsISATest extends TestCase {
	
	// tests of rearranged
	public void test1elems ( ){
		char [ ] [ ] tests = {{'X'}, {'O'}};
		char [ ] [ ] solns = {{'X'}, {'O'}};
		for (int k=0; k<tests.length; k++) {
			XsBeforeOsISA.rearrange (tests[k]);
			assertTrue (Arrays.equals (tests[k], solns[k]));			
		}
	}
	
	public void test2elems ( ) {
		char [ ] [ ] tests = {{'X','X'}, {'X','O'}, {'O','X'}, {'O','O'}};
		char [ ] [ ] solns = {{'X','X'}, {'X','O'}, {'X','O'}, {'O','O'}};
		for (int k=0; k<tests.length; k++) {
			XsBeforeOsISA.rearrange (tests[k]);
			assertTrue (Arrays.equals (tests[k], solns[k]));			
		}
	}
	
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
			XsBeforeOsISA.rearrange (tests[k]);
			assertTrue (Arrays.equals (tests[k], solns[k]));			
		}
	}
	
	// tests of isOK
	public void testIsOK1 ( ){
		char [ ] [ ] tests = {{'X'}, {'O'}};
		for (int k=0; k<tests.length; k++) {
			assertTrue (XsBeforeOsISA.isOK (tests[k], 0));			
		}
	}
	
	public void testIsOK2 ( ) {
		char [ ] [ ] tests = {{'X','X'}, {'X','O'}, {'O','X'}, {'O','O'}};
		boolean [ ] solns = {true, true, false, true};
		for (int k=0; k<tests.length; k++) {
			assertEquals (XsBeforeOsISA.isOK (tests[k], 1), solns[k]);			
		}
	}
	
	public void testIsOK3 ( ) {
		char [ ] [ ] tests = {{'X','X','X','X'}, {'X','X','O','X'}, {'X','O','X','X'}, {'X','O','O','X'},
				{'O','X','X','X'}, {'O','X','O','X'}, {'O','O','X','X'}, {'O','O','O','X'}};
		boolean [ ] k2solns = {true, true, false, true, false, false, false, true};
		boolean [ ] k3solns = {true, false, false, false, false, false, false, false};
		for (int k=0; k<tests.length; k++) {
			assertEquals (XsBeforeOsISA.isOK (tests[k], 2), k2solns[k]);
			assertEquals (XsBeforeOsISA.isOK (tests[k], 3), k3solns[k]);
		}
	}
}

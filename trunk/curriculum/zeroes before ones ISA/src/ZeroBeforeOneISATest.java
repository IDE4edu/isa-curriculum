import junit.framework.TestCase;

public class ZeroBeforeOneISATest extends TestCase {
	
	private static boolean equals (int [ ] a, int [ ] b) {
		for (int k=0; k<a.length; k++) {
			if (a[k] != b[k]) {
				return false;
			}
		}
		return true;
	}

	// tests of rearrange
	public void test1elems ( ){
		int [ ] [ ] tests = {{0}, {1}};
		int [ ] [ ] solns = {{0}, {1}};
		for (int k=0; k<tests.length; k++) {
			assertTrue (equals (ZeroBeforeOneISA.rearrange (tests[k]), solns[k]));			
		}
	}
	
	public void test2elems ( ) {
		int [ ] [ ] tests = {{0,0}, {0,1}, {1,0}, {1,1}};
		int [ ] [ ] solns = {{0,0}, {0,1}, {0,1}, {1,1}};
		for (int k=0; k<tests.length; k++) {
			assertTrue (equals (ZeroBeforeOneISA.rearrange (tests[k]), solns[k]));			
		}
	}
	
	public void test4elems ( ) {
		int [ ] [ ] tests = {{1,1,1,1}, {0,0,0,0}, 
				{0,1,1,1}, {1,0,1,1}, {1,1,0,1}, {1,1,1,0}, 
				{1,0,0,0}, {0,1,0,0}, {0,0,1,0}, {0,0,0,1},
				{0,0,1,1}, {1,0,0,1}, {1,1,0,0}, {0,1,1,0}, {0,1,0,1}, {1,0,1,0}};
		int [ ] [ ] solns = {{1,1,1,1}, {0,0,0,0}, 
				{0,1,1,1}, {0,1,1,1}, {0,1,1,1}, {0,1,1,1}, 
				{0,0,0,1}, {0,0,0,1}, {0,0,0,1}, {0,0,0,1},
				{0,0,1,1}, {0,0,1,1}, {0,0,1,1}, {0,0,1,1}, {0,0,1,1}, {0,0,1,1}};
		for (int k=0; k<tests.length; k++) {
			assertTrue (equals (ZeroBeforeOneISA.rearrange (tests[k]), solns[k]));			
		}
	}
	
	// tests of isOK
	public void testIsOK1 ( ){
		int [ ] [ ] tests = {{0}, {1}};
		for (int k=0; k<tests.length; k++) {
			assertTrue (ZeroBeforeOneISA.isOK (tests[k], 0));			
		}
	}
	
	public void testIsOK2 ( ) {
		int [ ] [ ] tests = {{0,0}, {0,1}, {1,0}, {1,1}};
		boolean [ ] solns = {true, true, false, true};
		for (int k=0; k<tests.length; k++) {
			assertEquals (ZeroBeforeOneISA.isOK (tests[k], 1), solns[k]);			
		}
	}
	
	public void testIsOK3 ( ) {
		int [ ] [ ]	tests = {{0,0,0,0}, {0,0,1,0}, {0,1,0,0}, {0,1,1,0},
				{1,0,0,0}, {1,0,1,0}, {1,1,0,0}, {1,1,1,0}};
		boolean [ ] k2solns = {true, true, false, true, false, false, false, true};
		boolean [ ] k3solns = {true, false, false, false, false, false, false, false};
		for (int k=0; k<tests.length; k++) {
			assertEquals (ZeroBeforeOneISA.isOK (tests[k], 2), k2solns[k]);
			assertEquals (ZeroBeforeOneISA.isOK (tests[k], 3), k3solns[k]);
		}
	}
}

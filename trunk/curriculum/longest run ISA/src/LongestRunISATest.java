import junit.framework.TestCase;

public class LongestRunISATest extends TestCase {

	public void testSmallCases ( ) {
		int [ ] [ ] tests = {{1}, {2,2}, {1,2,2}, {2,2,1}, {5,5,5,5,5}};
		int [ ] solns = {0, 0, 1, 0, 0};
		for (int k=0; k<tests.length; k++) {
			assertEquals (solns[k], LongestRunISA.longestRun (tests[k]));
		}
		int [ ] allDiff = {1,2,3,4,5};
		int x = LongestRunISA.longestRun (allDiff);
		assertTrue (x>=0 && x<5);
	}
	
	public void test3runs ( ) {
		int [ ] [ ] tests = {{1,2,2,3,3,3}, {1,3,3,3,2,2}, 
				{2,2,1,3,3,3}, {2,2,3,3,3,1}, {3,3,3,1,2,2}, {3,3,3,2,2,1}};
		int [ ] solns = {3, 1, 3, 2, 0, 0};
		for (int k=0; k<tests.length; k++) {
			assertEquals (solns[k], LongestRunISA.longestRun (tests[k]));
		}
	}
	
	public void testIsOK ( ) {
		int [ ] vals = {3,3,3,1,4,4,4,4};
		// isOK args are int [ ] values, int k, int startPos, int bestStartPos, int maxLen

		assertTrue (LongestRunISA.isOK (vals, 0, 0, 0, 1));
		assertTrue (LongestRunISA.isOK (vals, 1, 0, 0, 2));
		assertTrue (LongestRunISA.isOK (vals, 2, 0, 0, 3));
		assertTrue (LongestRunISA.isOK (vals, 3, 3, 0, 3));
		assertTrue (LongestRunISA.isOK (vals, 4, 4, 0, 3));
		assertTrue (LongestRunISA.isOK (vals, 5, 4, 0, 3));
		assertTrue (LongestRunISA.isOK (vals, 6, 4, 0, 3));
		assertTrue (LongestRunISA.isOK (vals, 7, 4, 4, 4));
		
		assertTrue (!LongestRunISA.isOK (vals, -1, 0, 0, 1));
		assertTrue (!LongestRunISA.isOK (vals, 0, -1, 0, 1));
		assertTrue (!LongestRunISA.isOK (vals, 0, 0, -1, 1));
		assertTrue (!LongestRunISA.isOK (vals, 0, 0, 0, 0));

		assertTrue (!LongestRunISA.isOK (vals, 7, 4, 4, 3)); // maxLen wrong at end of values
		assertTrue (!LongestRunISA.isOK (vals, 7, 4, 0, 3)); // bestStartPos wrong at end of values
		assertTrue (!LongestRunISA.isOK (vals, 7, 4, 5, 3)); // bestStartPos wrong at end of values
		assertTrue (!LongestRunISA.isOK (vals, 7, 4, 3, 1)); // shortest run
		assertTrue (!LongestRunISA.isOK (vals, 5, 4, 0, 2)); // maxLen 1 too small
		assertTrue (!LongestRunISA.isOK (vals, 7, 5, 4, 4)); // startPos 1 too large
		assertTrue (!LongestRunISA.isOK (vals, 5, 4, 1, 3)); // bestStartPos 1 too large
	}
}

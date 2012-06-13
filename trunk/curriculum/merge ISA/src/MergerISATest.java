import junit.framework.TestCase;

public class MergerISATest extends TestCase {
	
	private static boolean equals (int [ ] a, int [ ] b) {
		for (int k=0; k<a.length; k++) {
			if (a[k] != b[k]) {
				return false;
			}
		}
		return true;
	}

	public void testOneElemMerge ( ) {
		int [ ] a = {1};
		int [ ] b = {2};
		int [ ] desired = {1,2};
		assertTrue (equals (MergerISA.merged (a, b), desired));
		assertTrue (equals (MergerISA.merged (b, a), desired));
	}
	
	public void testTwoElemsMerge ( ) {
		int [ ] [ ] aTests = {{1,2}, {1,3}, {1,4}, {2,3}, {2,4}, {3,4}};
		int [ ] [ ]	bTests = {{3,4}, {2,4}, {2,3}, {1,4}, {1,3}, {1,2}};
		int [ ] desired = {1,2,3,4};
		for (int k=0; k<aTests.length; k++) {
			assertTrue (equals (MergerISA.merged (aTests[k], bTests[k]), desired));
		}
	}
}

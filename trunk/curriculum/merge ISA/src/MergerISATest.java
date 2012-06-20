import junit.framework.TestCase;
import java.util.Arrays;

public class MergerISATest extends TestCase {
	
	private static String toString (int [ ] values) {
		String rtn = "{ ";
		for (int k=0; k<values.length; k++) {
			rtn = rtn + values[k] + " ";
		}
		return rtn + "}";
	}
	
	public void testOneElemMerge ( ) {
		int [ ] a = {1};
		int [ ] b = {2};
		int [ ] desired = {1,2};
		assertTrue ("fails when merging {1} and {2}", Arrays.equals (MergerISA.merged (a, b), desired));
		assertTrue ("fails when merging {2} and {1}", Arrays.equals (MergerISA.merged (b, a), desired));
	}
	
	public void testTwoElemsMerge ( ) {
		int [ ] [ ] aTests = {{1,2}, {1,3}, {1,4}, {2,3}, {2,4}, {3,4}};
		int [ ] [ ]	bTests = {{3,4}, {2,4}, {2,3}, {1,4}, {1,3}, {1,2}};
		int [ ] desired = {1,2,3,4};
		for (int k=0; k<aTests.length; k++) {
			assertTrue ("fails when merging " + toString (aTests[k]) + " and " + toString (bTests[k]),
					Arrays.equals (MergerISA.merged (aTests[k], bTests[k]), desired));
		}
	}
}

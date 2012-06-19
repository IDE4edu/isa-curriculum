import junit.framework.TestCase;
import java.util.*;

public class MergerISATest extends TestCase {
	
	public void testOneElemMerge ( ) {
		int [ ] a = {1};
		int [ ] b = {2};
		int [ ] desired = {1,2};
		assertTrue (Arrays.equals (MergerISA.merged (a, b), desired));
		assertTrue (Arrays.equals (MergerISA.merged (b, a), desired));
	}
	
	public void testTwoElemsMerge ( ) {
		int [ ] [ ] aTests = {{1,2}, {1,3}, {1,4}, {2,3}, {2,4}, {3,4}};
		int [ ] [ ]	bTests = {{3,4}, {2,4}, {2,3}, {1,4}, {1,3}, {1,2}};
		int [ ] desired = {1,2,3,4};
		for (int k=0; k<aTests.length; k++) {
			assertTrue (Arrays.equals (MergerISA.merged (aTests[k], bTests[k]), desired));
		}
	}
}

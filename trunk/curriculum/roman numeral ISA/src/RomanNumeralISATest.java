import junit.framework.TestCase;


public class RomanNumeralISATest extends TestCase {

	// Test single-digit Roman numerals.
	public void testSingleDigit ( )	{
		String [ ] tests = {"i","v","x","l","c","d","m"};
		int [ ] solns = {1,5,10,50,100,500,1000};
		for (int k=0; k<tests.length; k++) {
			assertEquals ("fails for '" + tests[k] + "'", solns[k], RomanNumeralISA.toDecimal (tests[k]));
		}
	}
	
	// Test double-digit Roman numerals with no prefixes.
	public void testDoubleDigit ( )	{
		String [ ] tests = {"xi","xv","cx","cl","mc","md","mm"};
		int [ ] solns = {11,15,110,150,1100,1500,2000};
		for (int k=0; k<tests.length; k++) {
			assertEquals ("fails for '" + tests[k] + "'", solns[k], RomanNumeralISA.toDecimal (tests[k]));
		}
	}
	
	// Test double-digit Roman numerals, the first of which is a prefix.
	public void testSinglePrefix ( )	{
		String [ ] tests = {"iv","ix","xl","xc","cd","cm"};
		int [ ] solns = {4,9,40,90,400,900};
		for (int k=0; k<tests.length; k++) {
			assertEquals ("fails for '" + tests[k] + "'", solns[k], RomanNumeralISA.toDecimal (tests[k]));
		}
	}
	
	// Test a prefix/prefixed pair followed by a Roman numeral with no prefixes.
	public void testPrefixNonprefix ( ) {
		String [ ] tests = {"xlviii","xcviii","cdxxxviii","cmxxxviii"};
		int [ ] solns = {48,98,438,938};
		for (int k=0; k<tests.length; k++) {
			assertEquals ("fails for '" + tests[k] + "'", solns[k], RomanNumeralISA.toDecimal (tests[k]));
		}
	}
	
	// Test a nonprefix followed by a prefix/prefixed pair.
	public void testNonprefixPrefix ( ) {
		String [ ] tests = {"xxxiv","xxxix","cccxl","cccxc","mmmcd","mmmcm"};
		int [ ] solns = {34,39,340,390,3400,3900};
		for (int k=0; k<tests.length; k++) {
			assertEquals ("fails for '" + tests[k] + "'", solns[k], RomanNumeralISA.toDecimal (tests[k]));
		}
	}
	
	// Test consecutive prefix/prefixed pairs.
	public void testPrefixPrefix ( ) {
		String [ ] tests = {"xliv","xlix","cmxl","cmxc"};
		int [ ] solns = {44,49,940,990};
		for (int k=0; k<tests.length; k++) {
			assertEquals ("fails for '" + tests[k] + "'", solns[k], RomanNumeralISA.toDecimal (tests[k]));
		}
	}
	
	public void testIsOK ( ) {
		String testStr;
		testStr = "d";
		assertTrue ("fails for " + testStr, RomanNumeralISA.isOK (testStr, 1, 500));
		assertTrue ("fails for " + testStr, !RomanNumeralISA.isOK (testStr, 0, 0));
		testStr = "mm";
		assertTrue ("fails for " + testStr, RomanNumeralISA.isOK (testStr, 1, 1000));
		assertTrue ("fails for " + testStr, !RomanNumeralISA.isOK (testStr, 1, 0));
		assertTrue ("fails for " + testStr, RomanNumeralISA.isOK (testStr, 2, 2000));
		assertTrue ("fails for " + testStr, !RomanNumeralISA.isOK (testStr, 2, 1000));
		testStr = "xi";
		assertTrue ("fails for " + testStr, RomanNumeralISA.isOK (testStr, 1, 10));
		assertTrue ("fails for " + testStr, !RomanNumeralISA.isOK (testStr, 1, 0));
		assertTrue ("fails for " + testStr, RomanNumeralISA.isOK (testStr, 2, 11));
		assertTrue ("fails for " + testStr, !RomanNumeralISA.isOK (testStr, 2, 10));
		testStr = "ix";
		assertTrue ("fails for " + testStr, !RomanNumeralISA.isOK (testStr, 1, 1));
		assertTrue ("fails for " + testStr, !RomanNumeralISA.isOK (testStr, 1, 9));
		assertTrue ("fails for " + testStr, RomanNumeralISA.isOK (testStr, 2, 9));
		assertTrue ("fails for " + testStr, !RomanNumeralISA.isOK (testStr, 2, 1));
		assertTrue ("fails for " + testStr, !RomanNumeralISA.isOK (testStr, 2, 11));
		testStr = "liv";
		assertTrue ("fails for " + testStr, RomanNumeralISA.isOK (testStr, 1, 50));
		assertTrue ("fails for " + testStr, !RomanNumeralISA.isOK (testStr, 1, 0));
		assertTrue ("fails for " + testStr, !RomanNumeralISA.isOK (testStr, 2, 51));
		assertTrue ("fails for " + testStr, RomanNumeralISA.isOK (testStr, 3, 54));
		assertTrue ("fails for " + testStr, !RomanNumeralISA.isOK (testStr, 3, 51));
		assertTrue ("fails for " + testStr, !RomanNumeralISA.isOK (testStr, 3, 56));
		testStr = "xcviii";
		assertTrue ("fails for " + testStr, !RomanNumeralISA.isOK (testStr, 1, 10));
		assertTrue ("fails for " + testStr, !RomanNumeralISA.isOK (testStr, 1, 90));
		assertTrue ("fails for " + testStr, RomanNumeralISA.isOK (testStr, 2, 90));
		assertTrue ("fails for " + testStr, !RomanNumeralISA.isOK (testStr, 2, 10));
		assertTrue ("fails for " + testStr, !RomanNumeralISA.isOK (testStr, 2, 110));
		assertTrue ("fails for " + testStr, RomanNumeralISA.isOK (testStr, 3, 95));
		assertTrue ("fails for " + testStr, !RomanNumeralISA.isOK (testStr, 3, 115));
		assertTrue ("fails for " + testStr, RomanNumeralISA.isOK (testStr, 4, 96));
		assertTrue ("fails for " + testStr, !RomanNumeralISA.isOK (testStr, 4, 95));
		assertTrue ("fails for " + testStr, !RomanNumeralISA.isOK (testStr, 4, 94));
		assertTrue ("fails for " + testStr, RomanNumeralISA.isOK (testStr, 5, 97));
		assertTrue ("fails for " + testStr, !RomanNumeralISA.isOK (testStr, 5, 95));
		assertTrue ("fails for " + testStr, RomanNumeralISA.isOK (testStr, 6, 98));
		assertTrue ("fails for " + testStr, !RomanNumeralISA.isOK (testStr, 6, 96));
		assertTrue ("fails for " + testStr, !RomanNumeralISA.isOK (testStr, 6, 97));
		testStr = "cdiv";
		assertTrue ("fails for " + testStr, !RomanNumeralISA.isOK (testStr, 1, 100));
		assertTrue ("fails for " + testStr, !RomanNumeralISA.isOK (testStr, 1, 400));
		assertTrue ("fails for " + testStr, RomanNumeralISA.isOK (testStr, 2, 400));
		assertTrue ("fails for " + testStr, !RomanNumeralISA.isOK (testStr, 2, 600));
		assertTrue ("fails for " + testStr, !RomanNumeralISA.isOK (testStr, 3, 401));
		assertTrue ("fails for " + testStr, !RomanNumeralISA.isOK (testStr, 3, 599));
		assertTrue ("fails for " + testStr, RomanNumeralISA.isOK (testStr, 4, 404));
		assertTrue ("fails for " + testStr, !RomanNumeralISA.isOK (testStr, 4, 606));
		assertTrue ("fails for " + testStr, !RomanNumeralISA.isOK (testStr, 4, 401));
	}
}

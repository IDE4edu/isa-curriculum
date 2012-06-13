import junit.framework.TestCase;


public class RomanNumeralISATest extends TestCase {

	// test toDecimal
	public void testSingleDigit ( )	{
		String [ ] tests = {"i","v","x","l","c","d","m"};
		int [ ] solns = {1,5,10,50,100,500,1000};
		for (int k=0; k<tests.length; k++) {
			assertEquals (solns[k], RomanNumeralISA.toDecimal (tests[k]));
		}
	}
	
	public void testDoubleDigit ( )	{
		String [ ] tests = {"xi","xv","cx","cl","mc","md","mm"};
		int [ ] solns = {11,15,110,150,1100,1500,2000};
		for (int k=0; k<tests.length; k++) {
			assertEquals (solns[k], RomanNumeralISA.toDecimal (tests[k]));
		}
	}
	
	public void testSinglePrefix ( )	{
		String [ ] tests = {"iv","ix","xl","xc","cd","cm"};
		int [ ] solns = {4,9,40,90,400,900};
		for (int k=0; k<tests.length; k++) {
			assertEquals (solns[k], RomanNumeralISA.toDecimal (tests[k]));
		}
	}
	
	public void testPrefixNonprefix ( ) {
		String [ ] tests = {"xlviii","xcviii","cdxxxviii","cmxxxviii"};
		int [ ] solns = {48,98,438,938};
		for (int k=0; k<tests.length; k++) {
			assertEquals (solns[k], RomanNumeralISA.toDecimal (tests[k]));
		}
	}
	
	public void testNonprefixPrefix ( ) {
		String [ ] tests = {"xxxiv","xxxix","cccxl","cccxc","mmmcd","mmmcm"};
		int [ ] solns = {34,39,340,390,3400,3900};
		for (int k=0; k<tests.length; k++) {
			assertEquals (solns[k], RomanNumeralISA.toDecimal (tests[k]));
		}
	}
	
	public void testPrefixPrefix ( ) {
		String [ ] tests = {"xliv","xlix","cmxl","cmxc"};
		int [ ] solns = {44,49,940,990};
		for (int k=0; k<tests.length; k++) {
			assertEquals (solns[k], RomanNumeralISA.toDecimal (tests[k]));
		}
	}
	
	// test isOK
	public void testIsOK ( ) {
		String testStr;
		testStr = "d";
		assertTrue (RomanNumeralISA.isOK (testStr, 1, 500));
		assertTrue (!RomanNumeralISA.isOK (testStr, 0, 0));
		testStr = "mm";
		assertTrue (RomanNumeralISA.isOK (testStr, 1, 1000));
		assertTrue (!RomanNumeralISA.isOK (testStr, 1, 0));
		assertTrue (RomanNumeralISA.isOK (testStr, 2, 2000));
		assertTrue (!RomanNumeralISA.isOK (testStr, 2, 1000));
		testStr = "xi";
		assertTrue (RomanNumeralISA.isOK (testStr, 1, 10));
		assertTrue (!RomanNumeralISA.isOK (testStr, 1, 0));
		assertTrue (RomanNumeralISA.isOK (testStr, 2, 11));
		assertTrue (!RomanNumeralISA.isOK (testStr, 2, 10));
		testStr = "ix";
		assertTrue (!RomanNumeralISA.isOK (testStr, 1, 1));
		assertTrue (!RomanNumeralISA.isOK (testStr, 1, 9));
		assertTrue (RomanNumeralISA.isOK (testStr, 2, 9));
		assertTrue (!RomanNumeralISA.isOK (testStr, 2, 1));
		assertTrue (!RomanNumeralISA.isOK (testStr, 2, 11));
		testStr = "liv";
		assertTrue (RomanNumeralISA.isOK (testStr, 1, 50));
		assertTrue (!RomanNumeralISA.isOK (testStr, 1, 0));
		assertTrue (!RomanNumeralISA.isOK (testStr, 2, 51));
		assertTrue (RomanNumeralISA.isOK (testStr, 3, 54));
		assertTrue (!RomanNumeralISA.isOK (testStr, 3, 51));
		assertTrue (!RomanNumeralISA.isOK (testStr, 3, 56));
		testStr = "xcviii";
		assertTrue (!RomanNumeralISA.isOK (testStr, 1, 10));
		assertTrue (!RomanNumeralISA.isOK (testStr, 1, 90));
		assertTrue (RomanNumeralISA.isOK (testStr, 2, 90));
		assertTrue (!RomanNumeralISA.isOK (testStr, 2, 10));
		assertTrue (!RomanNumeralISA.isOK (testStr, 2, 110));
		assertTrue (RomanNumeralISA.isOK (testStr, 3, 95));
		assertTrue (!RomanNumeralISA.isOK (testStr, 3, 115));
		assertTrue (RomanNumeralISA.isOK (testStr, 4, 96));
		assertTrue (!RomanNumeralISA.isOK (testStr, 4, 95));
		assertTrue (!RomanNumeralISA.isOK (testStr, 4, 94));
		assertTrue (RomanNumeralISA.isOK (testStr, 5, 97));
		assertTrue (!RomanNumeralISA.isOK (testStr, 5, 95));
		assertTrue (RomanNumeralISA.isOK (testStr, 6, 98));
		assertTrue (!RomanNumeralISA.isOK (testStr, 6, 96));
		assertTrue (!RomanNumeralISA.isOK (testStr, 6, 97));
		testStr = "cdiv";
		assertTrue (!RomanNumeralISA.isOK (testStr, 1, 100));
		assertTrue (!RomanNumeralISA.isOK (testStr, 1, 400));
		assertTrue (RomanNumeralISA.isOK (testStr, 2, 400));
		assertTrue (!RomanNumeralISA.isOK (testStr, 2, 600));
		assertTrue (!RomanNumeralISA.isOK (testStr, 3, 401));
		assertTrue (!RomanNumeralISA.isOK (testStr, 3, 599));
		assertTrue (RomanNumeralISA.isOK (testStr, 4, 404));
		assertTrue (!RomanNumeralISA.isOK (testStr, 4, 606));
		assertTrue (!RomanNumeralISA.isOK (testStr, 4, 401));
	}
}

package methodIntro;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VoidMethodsWithParamsTest extends systemout.SystemOutTest {
	
	int whichMethod;
	final int testm1 = 1;
	final int testm2 = 2;
	final int testmain = 3;
	int methodArg;
	
	static String [ ] names = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
		"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty"};
	
//	@Test
//	public void test0 ( ) {
//		collectUserOutput ( );
//		String [ ] desiredOutput = { };
//		assertSOEquals("not equal", desiredOutput);
//	}

	@Test
	public void testm1gt0 ( ) {
		whichMethod = testm1;
		methodArg = 7;
		collectUserOutput ( );
		String [ ] desiredOutput = {"A", "A", "A", "A", "A", "A", "A"};
		assertSOEquals("When lineCount is " + methodArg + ", you should print " 
		+ names[methodArg] + " A's (one per line).", desiredOutput);
	}

	@Test
	public void testm1eq0 ( ) {
		whichMethod = testm1;
		methodArg = 0;
		collectUserOutput ( );
		String [ ] desiredOutput = { };
		assertSOEquals("When lineCount is 0, you shouldn't produce any output.", desiredOutput);
	}
	
	@Test
	public void testm2gt0odd ( ) {
		whichMethod = testm2;
		methodArg = 15;
		collectUserOutput ( );
		int aCount = 0, bCount = 0;
		assertEquals("When lineCount is " + methodArg + ", you should print " + names[methodArg] + " lines.",
				methodArg, userOutput.size());
		for (String s : userOutput) { 
			if (s.equals("A")) {
				aCount++;
			} else if (s.equals("B")) {
				bCount++;
			} else {
				fail ("Each line you print should contain an A or a B, with no other characters.");
			}
		}
		assertTrue ("When lineCount is " + methodArg + ", you should print " + names[(methodArg+1)/2] 
				+ " A's and " + names[methodArg/2] + " B's (a total of " + methodArg + " lines).", 
				aCount == (methodArg+1)/2 && bCount == methodArg/2);
	}

	@Test
	public void testm2gt0even ( ) {
		whichMethod = testm2;
		methodArg = 10;
		collectUserOutput ( );
		int aCount = 0, bCount = 0;
		assertEquals("When lineCount is " + methodArg + ", you should print " + names[methodArg] + " lines.",
				methodArg, userOutput.size());
		for (String s : userOutput) { 
			if (s.equals("A")) {
				aCount++;
			} else if (s.equals("B")) {
				bCount++;
			} else {
				fail ("Each line you print should contain an A or a B, with no other characters.");
			}
		}
		assertTrue ("When lineCount is " + methodArg + ", you should print " + names[(methodArg+1)/2] 
				+ " A's and " + names[methodArg/2] + " B's (a total of " + methodArg + " lines).", 
				aCount == (methodArg+1)/2 && bCount == methodArg/2);
	}

	@Test
	public void testm2eq0 ( ) {
		whichMethod = testm2;
		methodArg = 0;
		collectUserOutput ( );
		String [ ] desiredOutput = { };
		assertSOEquals("When lineCount is 0, you shouldn't produce any output.", desiredOutput);
	}

	@Test
	public void testMainContents ( ) {
		// Make sure that main contains a call to m1, m2, or m3,
		// then another call to m1, m2, or m3, and no other statements.
	}

	@Override
	public void callUserCode() {
		String[] empty = {""};
		switch (whichMethod) {
		case testm1:
			VoidMethodsWithParams.m1(methodArg);
			break;
		case testm2:
			VoidMethodsWithParams.m2(methodArg);
			break;
		case testmain:
			VoidMethodsWithParams.main(empty);
		}
	}
}

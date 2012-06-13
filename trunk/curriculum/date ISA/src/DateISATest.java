import junit.framework.TestCase;

public class DateISATest extends TestCase {

	public void testNonsenseIsOK ( ) {
		int [ ] [ ] tests = {{-10,4,2012}, {1000,4,2012}, {20,3000,2012}, {20,-8,2012}, {20,3,-27}};
		for (int k=0; k<tests.length; k++) {
			DateISA d = new DateISA (tests[k][0], tests[k][1], tests[k][2]);
			assertTrue (!d.isOK ( ));
		}
	}
	
	public void testArgMixupIsOK ( ) {
		int [ ] [ ] tests = {{5,30,2012}};
		for (int k=0; k<tests.length; k++) {
			DateISA d = new DateISA (tests[k][0], tests[k][1], tests[k][2]);
			assertTrue (!d.isOK ( ));
		}		
	}
	
	public void monthIs1isOK ( ) {
		for (int k=0; k<12; k++) {
			DateISA d = new DateISA (0, k, 2012);
			assertTrue (!d.isOK ( ));
			d = new DateISA (1, k, 2012);
			assertTrue (d.isOK ( ));
		}
	}
	
	public void test31isOK ( ) {
		int [ ] months = {1, 3, 5, 7, 8, 10, 12};
		for (int k=0; k<months.length; k++) {
			DateISA d = new DateISA (32, months[k], 2012);
			assertTrue (!d.isOK ( ));
			d = new DateISA (31, months[k], 2012);
			assertTrue (d.isOK ( ));
		}
	}
	
	public void test30isOK ( ) {
		int [ ] months = {4, 6, 9, 11};
		for (int k=0; k<months.length; k++) {
			DateISA d = new DateISA (31, months[k], 2012);
			assertTrue (!d.isOK ( ));
			d = new DateISA (30, months[k], 2012);
			assertTrue (d.isOK ( ));
		}
	}

	public void testFebisOK ( ) {
		DateISA d = new DateISA (30, 2, 2012);
		assertTrue (!d.isOK ( ));
		d = new DateISA (29, 2, 2012);
		assertTrue (d.isOK ( ));
		d = new DateISA (28, 2, 2011);
		assertTrue (d.isOK ( ));
		d = new DateISA (29, 2, 2011);
		assertTrue (!d.isOK ( ));
	}
}

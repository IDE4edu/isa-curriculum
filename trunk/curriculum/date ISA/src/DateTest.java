import junit.framework.TestCase;

public class DateTest extends TestCase {

	// Test nonsense dates, i.e. those with date information negative or way too large.
	public void testNonsenseIsOK ( ) {
		int [ ] [ ] tests = {{-10,4,2012}, {1000,4,2012}, {20,3000,2012}, {20,-8,2012}, {20,3,-27}};
		for (int k=0; k<tests.length; k++) {
			Date d = new Date (tests[k][0], tests[k][1], tests[k][2]);
			assertTrue ("date info is negative or too big", !d.isOK ( ));
		}
	}
	
	// Test for misordering of constructor arguments (month and date-in-month).
	public void testArgMixupIsOK ( ) {
		int [ ] [ ] tests = {{5,30,2012}};
		for (int k=0; k<tests.length; k++) {
			Date d = new Date (tests[k][0], tests[k][1], tests[k][2]);
			assertTrue ("month and date-in-month possibly interchanged in constructor call?", !d.isOK ( ));
		}		
	}
	
	// Test for a month or a date-in-month that's zero.
	public void testForZeroInfo ( ) {
		Date d;
		for (int k=0; k<12; k++) {
			d = new Date (0, k, 2012);
			assertTrue ("dates in month start at 1", !d.isOK ( ));
		}
		d = new Date (1, 0, 2012);
		assertTrue ("month values start at 1", !d.isOK ( ));
	}
	
	// Test months with 31 days (date-in-month of 32 is illegal, 31 is legal).
	public void test31isOK ( ) {
		int [ ] months = {1, 3, 5, 7, 8, 10, 12};
		for (int k=0; k<months.length; k++) {
			Date d = new Date (32, months[k], 2012);
			assertTrue ("too many days in a month that should have only 31", !d.isOK ( ));
			d = new Date (31, months[k], 2012);
			assertTrue ("not enough days in a month that should have 31", d.isOK ( ));
		}
	}
	
	// Test months with 30 days (date-in-month of 31 is illegal, 30 is legal).
	public void test30isOK ( ) {
		int [ ] months = {4, 6, 9, 11};
		for (int k=0; k<months.length; k++) {
			Date d = new Date (31, months[k], 2012);
			assertTrue ("too many days in a month that should have only 30", !d.isOK ( ));
			d = new Date (30, months[k], 2012);
			assertTrue ("not enough days in a month that should have 30", d.isOK ( ));
		}
	}

	// Test February (max date-in-month is 29 if leap year, 28 if not).
	public void testFebisOK ( ) {
		Date d = new Date (30, 2, 2012);
		assertTrue ("too many days in February", !d.isOK ( ));
		d = new Date (29, 2, 2012);
		assertTrue ("2012 is a leap year; February should have 29 days", d.isOK ( ));
		d = new Date (28, 2, 2011);
		assertTrue ("February should have at least 28 days", d.isOK ( ));
		d = new Date (29, 2, 2011);
		assertTrue ("too many days in February 2011 isn't a leap year", !d.isOK ( ));
	}
}

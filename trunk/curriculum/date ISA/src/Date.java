
public class Date {
	
	private int myDateInMonth;	// dates-in-month range from 1 through the number of days in the month
	private int myMonth;		// months range from 1 (January) through 12 (December)
	private int myYear;			// years are between 1000 and 3000 (arbitrary decision)

	public Date (int dateInMonth, int month, int year) {
		myDateInMonth = dateInMonth;
		myMonth = month;
		myYear = year;
	}
	
	// Determine if the date information is internally consistent.
	public boolean isOK ( ) {
		int leapDay;
		if (myYear % 4 != 0) {
			leapDay = 0;
		} else if (myYear % 100 != 0) {
			leapDay = 1;
		} else if (myYear % 400 != 0) {
			leapDay = 0;
		} else {
			leapDay = 1;
		}
		if (myYear < 1000 || myYear > 3000) {
			return false;
		}
		if (myMonth < 1 || myMonth > 12) {
			return false;
		}
		if (myMonth == 1 || myMonth == 3 || myMonth == 5 || myMonth == 7
				|| myMonth == 8 || myMonth == 10 || myMonth == 12) {
			if (myDateInMonth < 1 || myDateInMonth > 31) {
				return false;
			}
			return true;
		} else if (myMonth == 4 || myMonth == 6 || myMonth == 9 || myMonth == 11) {
			if (myDateInMonth < 1 || myDateInMonth > 30) {
				return false;
			}
			return true;
		} else {	// myMonth must be 2
			if (myDateInMonth < 1 || myDateInMonth > 28 + leapDay) {
				return false;
			}
			return true;
		}
	}
}

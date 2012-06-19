
public class DateISA {
	
	private int myDateInMonth;
	private int myMonth;
	private int myYear;

	public DateISA (int dateInMonth, int month, int year) {
		myDateInMonth = dateInMonth;
		myMonth = month;
		myYear = year;
	}
	
	public boolean isOK ( ) {
		int leapDay;
		if (myYear % 4 != 0) {
			leapDay = 1;
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

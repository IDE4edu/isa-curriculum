import java.io.*;

public class DateConverter  {

	// Given a day number in 2008 -- an integer between 1 and 366 --
	// prints the date in month/day format.
	// 
	// Example:
	//    convert(364)
	// should print
	//    12/29
	

	// The code is missing two assignment statements.
	public static void convert (int input) {
		int dayOfYear = input;
		int month, dateInMonth, daysInMonth;
		month = 1;
		daysInMonth = 31;
		while (dayOfYear > daysInMonth) {
			
			// *** Here is one possible place to put assignment statements.
			
			if (month == 2) {
				daysInMonth = 29;
			} else if (month == 4 || month == 6 || month == 9 || month == 11) {
				daysInMonth = 30;
			} else {
				daysInMonth = 31;
			}
			
			// *** Here is another possible place to put assignment statements.

			DateConverterTester.checkForInfiniteLoop(); // code to catch inifite loop bugs
		}
		dateInMonth = dayOfYear;
		System.out.println("Day number " + input +  " is " + month + "/" + dateInMonth);
	}


}
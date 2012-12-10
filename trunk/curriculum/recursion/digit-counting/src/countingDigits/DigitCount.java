package countingDigits;

public class DigitCount {

	public static void main(String[] args) {
	}
	
	// Fix the bug in digitCount, so that it returns correct values.
	// You should only need to change one line!
	public static int digitCount (int value) {
		if (value == 0) {
			return 1;
		} else {
			return 1 + digitCount(value/10);
		}
	}
}

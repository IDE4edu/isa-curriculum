

public class DateConverterTester {


	public static void main(String[] args) {

		// Put tests here, in calls like 
		DateConverter.convert(12);
		DateConverter.convert(34);
		DateConverter.convert(555);
		DateConverter.convert(23);
	}
	
	
	
	
	// Don't worry about this code -- it helps catch infinite loop bugs
	static int counter = 0;
	static int previousInfiniteLoopValue=-1;
	public static void checkInfiniteLoop(int value) {
		if (previousInfiniteLoopValue == value) {
			if (counter++ > 1000) {
				throw new RuntimeException("infinite loop detected!!");
			}
		} else {
			counter=0;
			previousInfiniteLoopValue = value;
		}
	}

}

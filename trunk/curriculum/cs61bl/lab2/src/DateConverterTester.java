

public class DateConverterTester {


	public static void main(String[] args) {

		// Put tests here, in calls like 
		DateConverter.convert(12);
		DateConverter.convert(34);
		DateConverter.convert(555);
		DateConverter.convert(23);
	}
	
	
	
	
	/////////////////////////////////
	// Don't worry about the code below
	//
	// this code helps catch infinite loop bugs
	static final int tooManyLoops = 3000;
	static final long maxDuration = 1000;  // one second
	static int counter = 0;
	static long originalTime = System.currentTimeMillis();
	public static void checkForInfiniteLoop() {
		long currentTime = System.currentTimeMillis();
		if (currentTime < originalTime + maxDuration) {
			if (counter++ > tooManyLoops) {
				throw new RuntimeException("Infinite loop detected !!");
			}
		} else {
			counter=0;
			originalTime = currentTime;
		}
	}

}

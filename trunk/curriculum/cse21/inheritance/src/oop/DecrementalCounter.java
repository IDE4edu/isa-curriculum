package oop;

public class DecrementalCounter extends Counter {

	
	public void decrement() {
		// Fill in this method so that, after innovation,
		// the internal value has been reduced by 1 
		// (or, if the value was 0, remains at 0)
		
		if (value() == 0) {
			return;
		}
		int originalValue = value();
		reset();
		for (int i=0 ; i < (originalValue - 1) ; i++) {
			increment();
		}
		
		
	}
	
}

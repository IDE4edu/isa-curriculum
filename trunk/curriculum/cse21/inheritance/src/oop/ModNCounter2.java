package oop;


/**
 * A different implementation of a cycling counter class
 * Here, increment() will always increase the internal value,
 * potentially past the maximum set by cycleLength.  However,
 * value() will calculate the correct cycled value and return it. 
 * 
 * e.g., A (new) CyclicCounter with a cycleLength (maximum) of 5 will,
 * when increment() is called 7 times, have an internal value of 7 but
 * value() will return 2.
 */
public class ModNCounter2  extends Counter { 


    private int cycleLength; 

    public ModNCounter2 (int n) { 
    	cycleLength = n; 
    } 
 
    
    public int value ( ) { 
    	// fill in this method with the correct value
    	//  note: the MOD (%) operator will be useful here
    	int myValue = super.value();
        return myValue % cycleLength; 
    } 
} 
package oop;

public class SeasonCounter extends CyclicCounter {

	
	private static String[] names =  {"spring", "summer", "fall", "winter"};
	
	
	public SeasonCounter() {
		super(names.length);
	}
	

	@Override
	public String toString() {
		return names[value()];
	}
	
	
}

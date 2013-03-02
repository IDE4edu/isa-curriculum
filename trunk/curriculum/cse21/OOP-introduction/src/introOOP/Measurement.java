package introOOP;

public class Measurement {

	private int inches;
	
	public Measurement() {
		inches = 0;
	}
	
	public Measurement (int inches) {
		this.inches = inches;
	}
	
	public Measurement (int feet, int inches) {
		// Fill in code here
	}
	
	public Measurement (String measure) {
		// Fill in code here
		System.out.println("Make a Measurement with " + parseFeet(measure) +" feet and " + parseInches(measure) + " inches.");
	}
	

	public String toString() {
		// Fill in code here
		return("Feet: " + inches%12 + ", Inches: " + inches/12);
	}
	
	
	private int parseFeet(String measure) {
		return(findIntegerBetweenMarkers(measure, "", "'"));
	}
	
	private int parseInches(String measure) {
		return(findIntegerBetweenMarkers(measure, "'", "\""));
	}

	
	// returns the integer that comes before marker
	// returns 0 if marker isn't found in search
	private int findIntegerBetweenMarkers(String search, String frontMarker, String endMarker) {
		int frontPosition = -1;
		int endPosition = -1;
		int output;
		if (frontMarker != "") {
			frontPosition = search.indexOf(frontMarker) + 1;
		}
		if (endMarker != "") {
			endPosition = search.indexOf(endMarker);
		} 
		if ( (frontPosition == -1) && (endPosition == -1) ) {
			output = 0;
		} else if ( frontPosition == -1 ) {
			output = Integer.parseInt(search.substring(0, endPosition));
		} else if ( endPosition == -1 ) {
			output = Integer.parseInt(search.substring(frontPosition));	
		} else {
			output = Integer.parseInt(search.substring(frontPosition, endPosition));
		}
		return output;
	}

}

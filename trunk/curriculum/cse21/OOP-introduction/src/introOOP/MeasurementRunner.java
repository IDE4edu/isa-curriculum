package introOOP;

public class MeasurementRunner {


	public static void main(String[] args) {

		Measurement m1 = new Measurement();
		Measurement m2 = new Measurement(13);
		Measurement m3 = new Measurement(1,1);
		Measurement m4 = new Measurement("3'4\"");
		Measurement m5 = new Measurement("12'11\"");
		
		System.out.println("Measurement 1 is " + m1);
		System.out.println("Measurement 2 is " + m2);
		System.out.println("Measurement 3 is " + m3);
		System.out.println("Measurement 4 is " + m4);
		System.out.println("Measurement 5 is " + m5);
		
		

	}

}

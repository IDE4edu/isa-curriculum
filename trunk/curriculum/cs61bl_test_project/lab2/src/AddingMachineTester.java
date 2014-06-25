import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;


public class AddingMachineTester {
	
	public static void main(String[] args) {
		
		// these calls mimic the example in the problem statement
		startTest("test1");
		input(0);
		input(5);
		input(6);
		input(0);
		input(-3);
		input(-2);
		input(5);
		input(0);
		input(13);
		input(-13);
		input(8);
		input(0);
		input(0);
		// should print total = 19
		finishTest();

		
		// add more tests here.
	}
	
	
	
	//////////////////////  Testing framework, don't worry about this
	// Hic sunt dracones.
	
	public static StringBuffer buf = new StringBuffer();
	public static void startTest(String testname) {
		buf = new StringBuffer();
		System.out.println("Starting test: " + testname);
	}
	
	public static void input(int in) {
		buf.append(in);
		buf.append(System.getProperty("line.separator"));
	}
	
	public static void finishTest() {
		try {
			InputStream is = new ByteArrayInputStream(buf.toString().getBytes());
			AddingMachine.scanner = new Scanner(is);
			String[] args = {};
			AddingMachine.main(args);
		} catch (java.util.NoSuchElementException e) {
			System.err
					.println("Error: You're AddingMachine was expecting more input when finishTest() was called.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Finished test");
	}
}
	

package tests;

public class UserCode {
	
	public static int num = 5;

	public static void main (String [ ] args) {
		System.out.println ("orig = " + num);
		num++;
		System.out.println ("new = " + num);
//		System.out.println ("foo");
	}
}
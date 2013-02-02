package tests;

import java.util.Scanner;

public class SysoutWithInput {
	
	public static int num = 5;


	public static void main (String [ ] args) {
		Scanner input = new Scanner(System.in);
		System.out.println ("orig = " + num);
		num++;
		System.out.println ("new = " + num);
		System.out.println("gimme an int: ");
		int u = input.nextInt();
		System.out.println("Adding 1 to your number gives us " + (u+1));
//		System.out.println ("foo");
		System.out.println("hello\n" +
				"everyone");
	}
}
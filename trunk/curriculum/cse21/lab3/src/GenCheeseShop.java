import java.util.Random;
import java.util.Scanner;

public class GenCheeseShop {

	public static int MAXCHEESE = 4;
	public static Random ranGen = new Random(100);
	
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		double total = 0, subtotal = 0, discount = 0;

		String[] names = new String[MAXCHEESE];
		double[] prices = new double[MAXCHEESE];
		int[] amounts = new int[MAXCHEESE];

		// Special 3 Cheeses
		if (MAXCHEESE > 0) {
			names[0] = "Dalaran Sharp";
			prices[0] = 1.25;
		}
		if (MAXCHEESE > 1) {
			names[1] = "Stormwind Brie";
			prices[1] = 10.00;
		}
		if (MAXCHEESE > 2) {
			names[2] = "Alterac Swiss";
			prices[2] = 40.00;
		}

		System.out.println("We sell " + MAXCHEESE + " kinds of Cheese");
		if (MAXCHEESE > 0)
			System.out.println(names[0] + ": $" + prices[0] + " per pound");
		if (MAXCHEESE > 1)
			System.out.println(names[1] + ": $" + prices[1] + " per pound");
		if (MAXCHEESE > 2)
			System.out.println(names[2] + ": $" + prices[2] + " per pound");

		for (int i = 3; i < MAXCHEESE; i++) {
			names[i] = "Cheese Type " + (char) ('A' + i);
			prices[i] = ranGen.nextInt(1000) / 100.0;
			amounts[i] = 0;

			System.out.println(names[i] + ": $" + prices[i] + " per pound");
		}

		for (int i = 0; i < MAXCHEESE; i++) {
			System.out.println("Enter the amount of " + names[i] + ":");

			amounts[i] = input.nextInt();

		}

		for (int i = 0; i < MAXCHEESE; i++) {

			subtotal += amounts[i] * prices[i];
		}
		if (subtotal >= 50) {
			discount = 10;
		}
		if (subtotal >= 100) {
			discount += 15;
		}
		total = subtotal - discount;

//		System.out.print("Display the itemized list? (1 for yes) ");
//		int list = input.nextInt();
//
//		if (list == 1) {
			for (int i = 0; i < MAXCHEESE; i++) {
				if (amounts[i] > 0)
					// will students use ">0"?  "==0" will still work, and will have
					// different printouts...
					System.out.println(amounts[i] + " lbs of " + names[i]
							+ " @ " + prices[i] + " = $" + prices[i]
							* amounts[i]);
			}
//		}
		System.out.println("Sub Total: $" + subtotal);

		System.out.println("-Discount: $" + discount);

		System.out.println("Total: $" + total);

	}
}

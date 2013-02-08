import java.util.Random;
import java.util.Scanner;

public class GenCheeseShopv2 {

	public static void intro(String[] names, double[]prices, int[] amounts) {
		// Fill-in
	}

	public static void getAmount(Scanner input, String[] names, int[] amounts) {
		// Fill-in
	}

	public static void itemizedList(String[] names, double[]prices, int[] amounts) {
		// Fill-in
	}

	public static double calcSubTotal(double[] prices, int[] amounts) {
		// Fix
		return 0;
	}

	public static int discount(double subTotal){
		// Fix
		return 0;
	}

	public static void printTotal(double subTotal, int discount) {
		// Fill-in

	}

	public static void main(String[] args) {

		final int MAXCHEESE = 4;

		// DO NOT CHANGE ANYTHING BELOW
		String[] names = new String[MAXCHEESE];
		double[] prices = new double[MAXCHEESE];
		int[] amounts = new int[MAXCHEESE];

		Scanner input = new Scanner(System.in);

		intro(names, prices, amounts);

		getAmount(input, names, amounts);

		double total = calcSubTotal(prices, amounts);
		
		if (MAXCHEESE > 0) {
			System.out.print("Display the itemized list? (1 for yes) ");
			int itemized = input.nextInt();

			if (itemized == 1) {
				itemizedList(names, prices, amounts);
			}
		}

		System.out.println();

		printTotal(total,discount(total));
	}
}
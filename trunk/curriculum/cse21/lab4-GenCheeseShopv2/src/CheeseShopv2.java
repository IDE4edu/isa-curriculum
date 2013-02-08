import java.util.Scanner;

public class CheeseShopv2 {

	public static void intro() {
		// Fill-in
	}

	public static int getAmount(Scanner input, String name) {
		// Fix
		return 0;
	}
	
	public static double calcSubTotal(int sharp, int brie, int swiss) {
		// Fix
		return 0;
	}

	public static void itemizedList(int sharp, int brie, int swiss) {
		// Fill-in
	}

	public static int discount(double subTotal){
		// Fix
		
		return 0;
	}
	
	public static void printTotal(double subTotal, int discount) {
		// Fill-in
	}
	
	public static void main(String[] args) {
		// DO NOT CHANGE ANYTHING BELOW
		Scanner input = new Scanner(System.in);
		
		intro();
		
		int sharp = getAmount(input, "Sharp");
		int brie = getAmount(input, "Brie");
		int swiss = getAmount(input, "Swiss");
	
		double total = calcSubTotal(sharp, brie, swiss);
		
		System.out.print("Display the itemized list? (1 for yes) ");
		int itemized = input.nextInt();
		
		if (itemized == 1) {
			itemizedList(sharp, brie, swiss);
		}
		
		System.out.println();
		
		printTotal(total,discount(total));
	}

}

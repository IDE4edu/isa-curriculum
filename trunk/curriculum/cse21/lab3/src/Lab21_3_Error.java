import java.util.Random;

public class Lab21_3_Error {

	static int MAXCHEESE = 20;
	static Random ranGen = new Random(100);	

	
	public static void main(String[] args) {

		String[] names = new String[MAXCHEESE];
		double[] prices = new double[MAXCHEESE];
		int[] amounts = new int[MAXCHEESE];

		// Special 3 Cheeses
		names[0] = "Dalaran Sharp";
		prices[0] = 1.25;
		
		names[1] = "Stormwind Brie";
		prices[1] = 10.00;
		
		names[2] = "Alterac Swiss";
		prices[2] = 40.00;
		
 		System.out.println("We sell " + MAXCHEESE + " kinds of Cheese");

		System.out.println(names[0] + ": $" + prices[0] + " per pound");
		System.out.println(names[1] + ": $" + prices[1] + " per pound");
		System.out.println(names[2] + ": $" + prices[2] + " per pound");


		for (int i = 3; i < MAXCHEESE; i++) {
			names[i] = "Cheese Type " + (char)('A'+i);
			prices[i] = ranGen.nextInt(1000)/100.0;
			amounts[i] = 0;

			System.out.println(names[i] + ": $" + prices[i] + " per pound");
		}

	}

}

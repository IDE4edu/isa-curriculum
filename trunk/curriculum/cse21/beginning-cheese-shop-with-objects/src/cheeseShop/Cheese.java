package cheeseShop;

public class Cheese {

	protected String name;
	protected double price;
	protected int amount;

	public static int numCheese = 0;
	
	public Cheese() { // initialization 
		name = "";
		price = 0;
		amount = 0;
		numCheese++;
	}

	public Cheese(String name) { // Constructor with name input
		this.name = name;
		price = 0;
		amount = 0;
		numCheese++;
	}

	public Cheese(String name, double price) { // Constructor with 2 inputs
		// Fill-in Code
	}

	public String getName() { 				// Accessor
		return name;
	}

	public void setName(String newName) { 	// Mutator 
		name = newName;
	}

	public double getPrice() {
		// Fix Code
		return 0;
	}

	public void setPrice(double newPrice) {
		// Fill-in Code
	}

	public int getAmount() {
		// Fix Code
		return 0;
	}

	public void setAmount(int newAmount) {
		// Fill-in Code
	}
	
	public String toString() {
		String output = "";
		// Fill-in Code
		return output;
	}
}

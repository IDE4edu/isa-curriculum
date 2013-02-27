package cheeseShop;

public class Shop {

	private String name;
	private Cheese[] inventory = new Cheese[10];   // Students don't know about ArrayLists, do they...
	private int numCheese = 0;

	
	
	public Shop () {
		this.name = "Cheese Shop";
	}
	
	
	public Shop(String name) {
		this.name = name;
	}

	// maybe the students write some constructor stuff here?
	
	public void addCheese() {
		addCheese("some random cheese");
	}

	public void addCheese(String cheeseName) {
		addCheese(cheeseName, 5);
	}
	
	public void addCheese(String cheeseName, int amount) {
		if (numCheese < inventory.length) {
			Cheese cheese = new Cheese(cheeseName, amount);
			inventory[numCheese] = cheese;
			numCheese++;
		}
	}

	
	// Maybe have students combine duplicated entries first?  Or, sort them?    
	public void describe() {
		System.out.println("Welcome to \"" + name + "\"");
		// Finish code here, to print out the Shop inventory
	}

}
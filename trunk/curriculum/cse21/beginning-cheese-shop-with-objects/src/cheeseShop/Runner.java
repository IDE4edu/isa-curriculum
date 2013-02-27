package cheeseShop;

import java.util.*;

public class Runner {

	static String[] shopNames = { "Ye olde cheese shop", "Cheese, please",
			"A cheese a day", "We Do Cheese, Inc.", "The stinky cheese man",
			"Who cut the cheese", "Eat your cheese",
			"Chewy Honorable Extremely Excitable Shop, Esq.",
			"The Grate Cheese Shop" };

	static String[] cheeseNames = { "Swiss", "Brie", "American", "Pepperjack",
			"Linginhallerhamhamham", "Colby", "Provelone", "Muenster", "Gouda", "Head", "Nacho", 
			"Moon dust", "Goat", "Dog", "Iguana", "Bergenost", "Mozzerella", "Cream", 
			"Sharp Cheddar", "Extra sharp cheddar", "Painfully sharp cheddar",
			"Stinky Pete", "Grilled", "String", "Array" };

	static Random randGen = new Random(100);

	public static void main(String[] args) {
		
		Shop shop = new Shop(shopNames[randGen.nextInt(shopNames.length)]);
		
		for (int i = randGen.nextInt(15); i >= 0; i--) {
			shop.addCheese(cheeseNames[randGen.nextInt(cheeseNames.length)]);
		}
		
		System.out.println("We made the following shop:");
		shop.describe();
	}

}

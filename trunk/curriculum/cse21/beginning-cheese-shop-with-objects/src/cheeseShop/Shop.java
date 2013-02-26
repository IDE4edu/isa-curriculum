package cheeseShop;

import java.util.*;

public class Shop {

	private String name;
	private Cheese[] cheeses = new Cheese[10];
	private int numCheese = 0;

	
	
	public Shop () {
		this.name = "Cheese Shop";
	}
	
	
	public Shop(String name) {
		this.name = name;
	}

	
	public void addCheese() {
		addCheese("some random cheese");
	}

	public void addCheese(String cheeseName) {
		addCheese(cheeseName, 5);
	}
	
	public void addCheese(String cheeseName, int amount) {
		if (numCheese < cheeses.length) {
			Cheese cheese = new Cheese(cheeseName, amount);
			cheeses[numCheese] = cheese;
			numCheese++;
		}
	}
	
	public void describe() {
		System.out.println("Welcome to \"" + name + "\"");
		// write code here
	}

}

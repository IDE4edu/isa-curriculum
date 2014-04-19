package io;


public class Person {
	private String name;
	private int age;
	private String location;

	public Person() {
		this.name = "";
		this.age = 0;
		this.location = "";
	}
	public Person(String name, int age, String location) {
		// Fill-in
	}

	public void setName(String name) {
		// Fill-in
	}

	public String getName() {
		// Fix
		return "";
	}

	public void setAge(int age) {
		// Fill-in
	}

	public int getAge() {
		//		Fix	
		return 0;
	}
	public void setLocation(String location) {
		// Fill-in
	}

	public String getLocation() {
		//	Fix
		return "";
	}
	
	
	// every object in java has a toString method.  The @Override line
	// is an annotation telling Java that the definition below should 
	// replace the default method.
	// Fill in the definition below such that it returns a String that
	// describes a particular Person.
	@Override
	public String toString() {
		// fix
		return "a person";
	}

}

package com.geo;

public class Person {

	// Attributes
	private String name;

	// Constructor
	public Person(String name) {
		this.name = name;
	}

	// Getter for name
	public String getName() {
		return name;
	}

	// Method: walk
	protected void walk() {
		System.out.println(name + " is walking.");
	}

}

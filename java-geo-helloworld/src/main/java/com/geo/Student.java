package com.geo;

public class Student extends Person {

	// Additional attribute
	private String studentId;

	// Constructor
	public Student(String name, String studentId) {
		super(name); // Call the constructor of the superclass (Person)
		this.studentId = studentId;
	}

	// Getter for studentId
	public String getStudentId() {
		return studentId;
	}

	// Additional method: learn
	public void learn() {
		System.out.println(getName() + " is learning.");
	}

}

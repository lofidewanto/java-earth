package com.geo;

public class HelloEarth {

	public static void main(String[] args) {
		System.out.println("Welcome to Earth Science Programming!");

		HelloEarth earth = new HelloEarth();
		earth.testPersonAndStudent();
	}

	public void testPersonAndStudent() {
		Person person = new Person("John");
		person.walk();

		Student student = new Student("Alice", "S12345");
		student.walk(); // Inherited from Person
		student.learn(); // Specific to Student
	}

}

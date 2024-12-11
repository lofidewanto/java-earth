package com.geo;

public class HelloEarth {

	public static void main(String[] args) {
		System.out.println("Welcome to Earth Science Programming!");

		HelloEarth earth = new HelloEarth();
		earth.testPersonAndStudent();

		earth.testScanner();
		// Or...
		// You only can use one or another since System.in will be closed after
		// using this try (..)
		// earth.testBufferedReader();

		earth.testOutput();
		earth.testLoops();
	}

	private void testOutput() {
		EarthOutput earthOutput = new EarthOutput();
		earthOutput.setOutput();
	}

	private void testPersonAndStudent() {
		Person person = new Person("John");
		person.walk();

		Student student = new Student("Alice", "S12345");
		student.walk(); // Inherited from Person
		student.learn(); // Specific to Student
	}

	void testScanner() {
		EarthInput earthInput = new EarthInput();
		earthInput.getScannerInput();
	}

	void testBufferedReader() {
		EarthInput earthInput = new EarthInput();
		earthInput.getBufferedReader();
	}

	private void testLoops() {
		LoopExamples examples = new LoopExamples();
		examples.runAllLoops();
	}

}

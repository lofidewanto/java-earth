package com.geo;

public class HelloEarthApp {

	public static void main(String[] args) {
		System.out.println("Welcome to Earth Science Programming!");

		HelloEarthApp earth = new HelloEarthApp();
		earth.testPersonAndStudent();

		earth.testScanner();
		// Or...
		// You only can use one or another since System.in will be closed after
		// using this try (..)
		// earth.testBufferedReader();

		earth.testOutput();
		earth.testLoops();
	}

	// Private visibility:
	// https://chatgpt.com/share/675a9dea-ca8c-800c-89fd-ffa4cd9e5460
	private void testOutput() {
		OutputExamples outputExamples = new OutputExamples();
		outputExamples.setOutput();
	}

	private void testPersonAndStudent() {
		Person person = new Person("John");
		person.walk();

		Student student = new Student("Alice", "S12345");
		student.walk(); // Inherited from Person
		student.learn(); // Specific to Student
	}

	// Package visibility:
	// https://chatgpt.com/share/675a9dea-ca8c-800c-89fd-ffa4cd9e5460
	void testScanner() {
		InputExamples inputExamples = new InputExamples();
		inputExamples.getScannerInput();
	}

	void testBufferedReader() {
		InputExamples inputExamples = new InputExamples();
		inputExamples.getBufferedReader();
	}

	private void testLoops() {
		LoopExamples examples = new LoopExamples();
		examples.runAllLoops();
	}

}

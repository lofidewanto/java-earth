package com.geo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class LoopExamples {

	public void runAllLoops() {
		forLoop();
		whileLoop();
		doWhile();
		forEach();
		streamApiExample();
		recursionPrintNumbers();
		iterateStream();
	}

	public void forLoop() {
		System.out.println("For Loop...");
		for (int i = 0; i < 5; i++) {
			System.out.println("Iteration: " + i);
		}
	}

	public Integer whileLoop() {
		System.out.println("While Loop...");
		int indexAmount = 0;
		while (indexAmount < 5) {
			System.out.println("Iteration: " + indexAmount);
			indexAmount++;
		}

		return indexAmount;
	}

	public void doWhile() {
		System.out.println("Do While...");
		int indexAmount = 0;
		do {
			System.out.println("Iteration: " + indexAmount);
			indexAmount++;
		} while (indexAmount < 5);
	}

	public void forEach() {
		System.out.println("For Each...");
		int[] numbers = { 1, 2, 3, 4, 5 };
		for (int num : numbers) {
			System.out.println(num);
		}
	}

	public void streamApiExample() {
		System.out.println("Stream API...");
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		numbers.stream().filter(n -> n % 2 == 0) // Filter even numbers
				.map(n -> n * n) // Square the numbers
				.forEach(System.out::println); // Print each number
	}

	public void recursionPrintNumbers() {
		System.out.println("Recursion...");
		printNumbers(5);
	}

	private void printNumbers(int n) {
		if (n == 0) {
			return;
		}

		printNumbers(n - 1);
		System.out.println(n);
	}

	public void iterateStream() {
		System.out.println("Stream.iterate...");
		Stream.iterate(0, n -> n + 1).limit(5) // Limit the stream to 5 elements
				.forEach(System.out::println);
	}
}

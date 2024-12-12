package com.geo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class InputExamples {

	public void getScannerInput() {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Enter your name: ");
			String name = scanner.nextLine();

			System.out.print("Enter your age: ");
			int age = scanner.nextInt();

			System.out.println("Hello, " + name + ". You are " + age + " years old.");
		}
	}

	public void getBufferedReader() {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			System.out.print("Enter your name: ");
			String name = reader.readLine();

			System.out.print("Enter your age: ");
			int age;
			try {
				age = Integer.parseInt(reader.readLine());
			} catch (NumberFormatException e) {
				System.out.println("Invalid input for age. Please enter a valid number.");
				return;
			}

			System.out.println("Hello, " + name + ". You are " + age + " years old.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

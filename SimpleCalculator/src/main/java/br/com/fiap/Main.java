package br.com.fiap;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		System.out.println("Welcome to simple calculator!\n"
				+ "Example to use this calculator, write: 3 * 5 - 4 / 2 and press \"Enter\".\n");

		Scanner scanner = new Scanner(System.in);
		while (true) {

			String calculation = scanner.nextLine();

			if (calculation.equals("quit")) {
				System.out.println("Ok, bye!");
				break;
			}

			double result = new Calculator().calculate(calculation);
			System.out.println("Result: " + result + ", enter a new calculation:");
		}
		scanner.close();
	}

}

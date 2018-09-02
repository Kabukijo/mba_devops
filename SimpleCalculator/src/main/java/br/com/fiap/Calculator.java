package br.com.fiap;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

	public double calculate(String calculation) {
		
		calculation = calculation.replace(" ", "");
		calculation = null;

		List<String> calculatorList = new ArrayList<>();
		fillCalculatorList(calculatorList, calculation);

		for (int i = 1; i < calculatorList.size() - 1; i++) {
			if (calculatorList.get(i).matches("\\*|/")) {

				double result = calculate(calculatorList, i);
				calculatorList.set(i + 1, String.valueOf(result));
				calculatorList.remove(i - 1);
				calculatorList.remove(i - 1);
			}
		}

		for (int i = 1; i < calculatorList.size(); i++) {

			double result = calculate(calculatorList, i);
			calculatorList.set(i + 1, String.valueOf(result));
			calculatorList.remove(i - 1);
			calculatorList.remove(i - 1);
			i--;
		}

		return Double.parseDouble(calculatorList.get(0));
	}

	private double calculate(List<String> calculatorList, int index) {

		double result = 0.0;

		switch (calculatorList.get(index)) {
		case "*":

			result = Double.parseDouble(calculatorList.get(index - 1))
					* Double.parseDouble(calculatorList.get(index + 1));
			break;

		case "/":

			result = Double.parseDouble(calculatorList.get(index - 1))
					/ Double.parseDouble(calculatorList.get(index + 1));
			break;

		case "-":

			result = Double.parseDouble(calculatorList.get(index - 1))
					- Double.parseDouble(calculatorList.get(index + 1));
			break;

		case "+":

			result = Double.parseDouble(calculatorList.get(index - 1))
					+ Double.parseDouble(calculatorList.get(index + 1));
			break;
		}
		return result;
	}

	private void fillCalculatorList(List<String> calculatorList, String calculation) {

		String operator = calculation.replaceAll("\\d+|\\.", "");

		if (operator.isEmpty()) {
			calculatorList.add(calculation);
			return;
		}

		operator = operator.substring(0, 1);
		String value = calculation.substring(0, calculation.indexOf(operator));

		if (value.isEmpty()) {

			value = calculation.substring(calculation.indexOf(operator) + 1);
			String nextOperator = value.replaceAll("\\d+", "");

			if (nextOperator.isEmpty()) {
				value = operator + value;
				operator = "";

			} else {
				nextOperator = nextOperator.substring(0, 1);
				value = operator + value.substring(0, value.indexOf(nextOperator));
				operator = nextOperator;
			}
		}

		calculatorList.add(value);
		if (!operator.isEmpty()) {

			calculatorList.add(operator);
			calculation = calculation.substring(calculation.indexOf(operator) + 1);

		} else {
			calculation = calculation.substring(calculation.indexOf(value) + value.length());
		}

		if (!calculation.isEmpty())
			fillCalculatorList(calculatorList, calculation);
	}

}

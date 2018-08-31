package br.com.fiap;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest {

	@Test
	void testCalculateMult() {
		assertEquals(80.0, new Calculator().calculate("20 * 4"));
	}

	@Test
	void testCalculateDiv() {
		assertEquals(20.0, new Calculator().calculate("80 / 4"));
	}

	@Test
	void testCalculateSub() {
		assertEquals(16.0, new Calculator().calculate("20 - 4"));
	}

	@Test
	void testCalculateSum() {
		assertEquals(24.0, new Calculator().calculate("20 + 4"));
	}
}

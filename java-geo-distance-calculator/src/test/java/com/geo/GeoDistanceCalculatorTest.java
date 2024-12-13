package com.geo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GeoDistanceCalculatorTest {

	private static final double DISTANCE_RESULT = 9085.508815906822;

	@Test
	void test() {
		GeoDistanceCalculator calculator = new GeoDistanceCalculator();
		double calculatedDistance = calculator.calculateDistance();

		assertEquals(DISTANCE_RESULT, calculatedDistance);
	}

}

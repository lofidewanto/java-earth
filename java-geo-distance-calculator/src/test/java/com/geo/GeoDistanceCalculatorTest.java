package com.geo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GeoDistanceCalculatorTest {

	private static final double DISTANCE_RESULT_MATH = 9085.508815906822;

	private static final double DISTANCE_RESULT_JTS = 13510.316908993307;

	@Test
	void calc_with_math() {
		GeoDistanceCalculator calculator = new GeoDistanceCalculator();
		double calculatedDistance = calculator.calculateDistanceWithMath();

		assertEquals(DISTANCE_RESULT_MATH, calculatedDistance);
	}

	@Test
	void calc_with_jts() {
		GeoDistanceCalculator calculator = new GeoDistanceCalculator();
		double calculatedDistance = calculator.calculateDistanceWithJts();

		// Note: This result is less accurate than
		// the Haversine formula for real-world spherical distances,
		// as JTS assumes planar geometry unless combined with CRS tools
		// like GeoTools.
		assertEquals(DISTANCE_RESULT_JTS, calculatedDistance);
	}

}

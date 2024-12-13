package com.geo;

public class GeoDistanceCalculator {

	public static void main(String[] args) {
		double calculatedDistance = new GeoDistanceCalculator().calculateDistance();

		// Print the result
		System.out.printf("The distance between Paris and Los Angeles is %.2f kilometers.%n", calculatedDistance);

	}

	double calculateDistance() {
		// Coordinates of Point A (Paris)
		double lat1 = 48.8566;
		double lon1 = 2.3522;

		// Coordinates of Point B (Los Angeles)
		double lat2 = 34.0522;
		double lon2 = -118.2437;

		// Earth's radius in kilometers
		final double R = 6371;

		// Convert latitude and longitude from degrees to radians
		double lat1Rad = Math.toRadians(lat1);
		double lon1Rad = Math.toRadians(lon1);
		double lat2Rad = Math.toRadians(lat2);
		double lon2Rad = Math.toRadians(lon2);

		// Haversine formula
		double deltaLat = lat2Rad - lat1Rad;
		double deltaLon = lon2Rad - lon1Rad;

		double a = Math.pow(Math.sin(deltaLat / 2), 2)
				+ Math.cos(lat1Rad) * Math.cos(lat2Rad) * Math.pow(Math.sin(deltaLon / 2), 2);
		double c = 2 * Math.asin(Math.sqrt(a));

		// Calculate the distance
		double distance = R * c;

		return distance;
	}
}

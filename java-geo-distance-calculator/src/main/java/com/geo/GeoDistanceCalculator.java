package com.geo;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;

public class GeoDistanceCalculator {

	public static void main(String[] args) {
		GeoDistanceCalculator geoDistanceCalculator = new GeoDistanceCalculator();

		double calculatedDistance = geoDistanceCalculator.calculateDistanceWithMath();

		// Print the result Math
		System.out.printf("The distance between Paris and Los Angeles is %.2f kilometers.%n", calculatedDistance);

		calculatedDistance = geoDistanceCalculator.calculateDistanceWithJts();

		// Print the result JTS
		System.out.printf("Distance in kilometers: %.2f km%n", calculatedDistance);
	}

	double calculateDistanceWithMath() {
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

	double calculateDistanceWithJts() {
		// Create a GeometryFactory instance
		GeometryFactory geometryFactory = new GeometryFactory();

		// Define two points using their coordinates
		Point pointA = geometryFactory.createPoint(new Coordinate(2.3522, 48.8566)); // Paris
		Point pointB = geometryFactory.createPoint(new Coordinate(-118.2437, 34.0522)); // Los Angeles

		// Calculate the distance (in degrees; convert as needed for Earth coordinates)
		double distance = pointA.distance(pointB);

		System.out.printf("Distance between Paris and Los Angeles (in degrees): %.4f%n", distance);

		// Convert degrees to kilometers (approximation)
		double earthRadiusKm = 6371.0;
		double distanceInKm = distance * (Math.PI / 180) * earthRadiusKm;

		return distanceInKm;

	}
}

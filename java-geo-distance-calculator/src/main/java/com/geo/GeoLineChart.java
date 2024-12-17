package com.geo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GeoLineChart extends Application {

	@Override
	public void start(Stage primaryStage) {
		// Define canvas size
		double canvasWidth = 800;
		double canvasHeight = 600;

		// Create a Canvas
		Canvas canvas = new Canvas(canvasWidth, canvasHeight);
		GraphicsContext gc = canvas.getGraphicsContext2D();

		// Coordinates of two cities (Paris and Los Angeles)
		double parisLat = 48.8566; // Latitude
		double parisLon = 2.3522; // Longitude

		double laLat = 34.0522; // Latitude
		double laLon = -118.2437; // Longitude

		// Scale lat/lon to canvas coordinates
		Point parisPoint = latLonToCanvas(parisLat, parisLon, canvasWidth, canvasHeight);
		Point laPoint = latLonToCanvas(laLat, laLon, canvasWidth, canvasHeight);

		// Draw the map and line
		drawBackground(gc, canvasWidth, canvasHeight);
		drawAxes(gc, canvasWidth, canvasHeight);
		drawPointsAndLine(gc, parisPoint, laPoint);

		// Create the JavaFX scene
		StackPane root = new StackPane(canvas);
		Scene scene = new Scene(root, canvasWidth, canvasHeight);

		primaryStage.setTitle("Line Between Two Geo Points");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	/**
	 * Converts latitude and longitude to canvas coordinates.
	 */
	private Point latLonToCanvas(double lat, double lon, double width, double height) {
		// Assume latitude ranges from -90 to +90, longitude ranges from -180 to +180
		double x = (lon + 180) * (width / 360);
		double y = (90 - lat) * (height / 180);
		return new Point(x, y);
	}

	/**
	 * Draws the background (simulated map grid).
	 */
	private void drawBackground(GraphicsContext gc, double width, double height) {
		gc.setFill(Color.LIGHTBLUE);
		gc.fillRect(0, 0, width, height);
		gc.setStroke(Color.GRAY);
		gc.setLineWidth(0.5);

		// Draw grid lines
		for (int i = 0; i <= 8; i++) {
			double x = i * width / 8;
			double y = i * height / 8;
			gc.strokeLine(x, 0, x, height);
			gc.strokeLine(0, y, width, y);
		}
	}

	/**
	 * Draws the X and Y axes with numbers.
	 */
	private void drawAxes(GraphicsContext gc, double width, double height) {
		gc.setStroke(Color.BLACK);
		gc.setLineWidth(1.5);

		// Draw X-axis (horizontal)
		gc.strokeLine(0, height / 2, width, height / 2);

		// Draw Y-axis (vertical)
		gc.strokeLine(width / 2, 0, width / 2, height);

		gc.setFill(Color.BLACK);
		gc.setLineWidth(1);
		gc.setFont(javafx.scene.text.Font.font(12));

		// Add numbers on X-axis
		for (int i = -4; i <= 4; i++) {
			double x = width / 2 + i * (width / 8);
			gc.fillText(String.valueOf(i * 45), x - 10, height / 2 + 15);
		}

		// Add numbers on Y-axis
		for (int i = -3; i <= 3; i++) {
			double y = height / 2 - i * (height / 6);
			if (i != 0) {
				gc.fillText(String.valueOf(i * 30), width / 2 + 5, y + 5);
			}
		}
	}

	/**
	 * Draws points and a line between them.
	 */
	private void drawPointsAndLine(GraphicsContext gc, Point p1, Point p2) {
		// Draw points
		gc.setFill(Color.RED);
		gc.fillOval(p1.x - 5, p1.y - 5, 10, 10);
		gc.fillOval(p2.x - 5, p2.y - 5, 10, 10);

		// Draw line
		gc.setStroke(Color.BLUE);
		gc.setLineWidth(2);
		gc.strokeLine(p1.x, p1.y, p2.x, p2.y);
	}

	/**
	 * Inner class to represent a point.
	 */
	private static class Point {
		double x, y;

		Point(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}

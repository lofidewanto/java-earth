package com.geo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class GeoLineChart extends Application {

	@Override
	public void start(Stage stage) {
		// Define the axes for the chart
		NumberAxis xAxis = new NumberAxis(-180, 180, 30); // Longitude
		xAxis.setLabel("Longitude");

		NumberAxis yAxis = new NumberAxis(-90, 90, 15); // Latitude
		yAxis.setLabel("Latitude");

		// Create a ScatterChart
		ScatterChart<Number, Number> chart = new ScatterChart<>(xAxis, yAxis);
		chart.setTitle("Line Connecting Two Geographical Points");

		// Data for Point A (Paris)
		double lat1 = 48.8566; // Latitude
		double lon1 = 2.3522; // Longitude

		// Data for Point B (Los Angeles)
		double lat2 = 34.0522; // Latitude
		double lon2 = -118.2437; // Longitude

		// Add the points to the chart
		XYChart.Series<Number, Number> points = new XYChart.Series<>();
		points.setName("Points");
		points.getData().add(new XYChart.Data<>(lon1, lat1)); // Paris
		points.getData().add(new XYChart.Data<>(lon2, lat2)); // Los Angeles

		// Add the series to the chart
		chart.getData().add(points);

		// Draw a line between the points
		Line connectingLine = new Line(mapToChartX(lon1, xAxis), mapToChartY(lat1, yAxis), // Paris
				mapToChartX(lon2, xAxis), mapToChartY(lat2, yAxis) // Los Angeles
		);
		connectingLine.setStroke(Color.RED);
		connectingLine.setStrokeWidth(2);

		// Add the chart and line to the scene
		chart.setAnimated(false); // Disable animation for consistency
		chart.getChildrenUnmodifiable().add(connectingLine);

		Scene scene = new Scene(chart, 800, 600);
		stage.setScene(scene);
		stage.setTitle("Geographical Line Chart");
		stage.show();
	}

	// Map longitude to the X-axis chart space
	private double mapToChartX(double longitude, NumberAxis xAxis) {
		double axisWidth = xAxis.getUpperBound() - xAxis.getLowerBound();
		double scaleX = xAxis.getWidth() / axisWidth;
		return (longitude - xAxis.getLowerBound()) * scaleX;
	}

	// Map latitude to the Y-axis chart space
	private double mapToChartY(double latitude, NumberAxis yAxis) {
		double axisHeight = yAxis.getUpperBound() - yAxis.getLowerBound();
		double scaleY = yAxis.getHeight() / axisHeight;
		return (yAxis.getUpperBound() - latitude) * scaleY; // Invert Y for correct rendering
	}

	public static void main(String[] args) {
		launch();
	}
}

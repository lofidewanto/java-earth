package com.geo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloWorldJavaFx extends Application {

	@Override
	public void start(Stage primaryStage) {
		// Create a label with "Hello, World!"
		Label helloLabel = new Label("Hello, World!");

		// Create a layout and add the label to it
		StackPane root = new StackPane();
		root.getChildren().add(helloLabel);

		// Create a scene with the layout
		Scene scene = new Scene(root, 300, 200);

		// Set up the primary stage
		primaryStage.setTitle("Hello JavaFX with Java 21");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args); // Launch the JavaFX application
	}
}

package chapter14;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class ShowPolygon extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		int sides = 6;
		
		//Create a pane , a polygon, and place polygon to pane
		Pane pane = new Pane();
		Polygon polygon = new Polygon();
		pane.getChildren().add(polygon);
		polygon.setFill(Color.WHITE);
		polygon.setStroke(Color.BLACK);
		ObservableList<Double> list = polygon.getPoints();
		
		final double WIDTH = 200, HEIGHT = 200;
		double centerX = WIDTH / 2, centerY = HEIGHT / 2;
		double radius = Math.min(WIDTH, HEIGHT) * 0.4;
		
		// Add points to the polygon list
		for (int i = 0; i < sides; i++) {
			list.add(centerX + radius * Math.cos(2 * i * Math.PI / sides));
			list.add(centerY - radius * Math.sin(2 * i * Math.PI / sides));
		} 
		
		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, WIDTH, HEIGHT);
		primaryStage.setTitle("ShowPolygon");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}

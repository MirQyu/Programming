package chapter14;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Test extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		//rotateText(primaryStage);
		
//		showLine(primaryStage);
		
		
		
	}

	public void showLine(Stage primaryStage) {
		Pane pane = new Pane();
		
		Line line = new Line(10, 10, 70, 30);
		line.setStrokeWidth(10);
		pane.getChildren().add(line);
		
		Scene scene = new Scene(pane, 300, 200);
		primaryStage.setTitle("test");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void rotateText(Stage primaryStage) {
		// Create a pane
		StackPane pane = new StackPane();
		
		// Place a text in the pane
		Text text = new Text("hello world");
		//text.setFont(Font.font("Courier", FontWeight.BOLD, 20));
		text.setStroke(Color.BLACK);
		
		text.setRotate(45);
		pane.getChildren().add(text);
		
		// Create a scene, and put it in the stage
		Scene scene = new Scene(pane, 300, 200);
		primaryStage.setTitle("Test");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
		Application.launch(args);
	}
	
}

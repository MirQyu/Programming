package chapter14;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class NodeStyleRotateDemo extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		StackPane pane = new StackPane();
		Button btOK = new Button("OK");
		btOK.setTextFill(Color.color(0.25, 0.14, 0.333, 0.51));
		btOK.setStyle("-fx-border-color: blue;");
		
		pane.getChildren().add(btOK);
		
		pane.setRotate(45);
		pane.setStyle("-fx-border-color: red; -fx-background-color: lightgray;");
		
		Scene scene = new Scene(pane, 200, 250);
		primaryStage.setTitle("NodeStyleRotateDemo");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}

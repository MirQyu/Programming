package chapter15;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MouseEventDemo extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Create a pane and set its properties
		Pane pane = new Pane();
		Text text = new Text(20, 20, "Programming is fun");
		pane.getChildren().add(text);
		text.setOnMouseDragged(e -> {
			text.setX(e.getX());
			text.setY(e.getY());
			System.out.println("X=" + e.getX() + " , Y=" + e.getY() + "\nScreenX=" + e.getSceneX() + " , ScreenY=" + e.getSceneY());
		});
		
		// Create a scene and place
		Scene scene = new Scene(pane, 300, 100);
		primaryStage.setTitle("MounseEventDemo");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}

package chapter15;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class BounceBallControl extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		BallPane ballPane = new BallPane();
		
		// Pause and resume animation
		ballPane.setOnMousePressed(e -> ballPane.pause());
		ballPane.setOnMouseReleased(e -> ballPane.play());
		
		// Increase and decrease animation
		ballPane.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.UP) {
				ballPane.increaseSpeed();
			}
			else if (e.getCode() == KeyCode.DOWN) {
				ballPane.decreaseSpeed();
			}
		});
		
		// Create a scene and place it in the stage
		Scene scene = new Scene(ballPane, 300, 200);
		primaryStage.setTitle("BounceBallControl");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		// Must request focus after the primary stage is displayed
		ballPane.requestFocus();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}

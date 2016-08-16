package chapter15;


import apple.laf.JRSUIConstants.Animating;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Test extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		StackPane pane = new StackPane();
		Text text = new Text(20, 50, "Programming is fun");
		text.setFill(Color.RED);
		pane.getChildren().add(text);
		
		// Create a handler for changing text
		EventHandler<ActionEvent> eventHandler = e -> {
			if (text.getText().length() != 0) {
				text.setText("");
			}
			else {
				text.setText("Programming is fun");
			}
		};
		
		Timeline animation = new Timeline(new KeyFrame(Duration.millis(2000), eventHandler));
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.play();
		
		text.setOnMousePressed(e -> {
			if (animation.getStatus() == Animation.Status.PAUSED) {
				animation.play();
			}
			else {
				animation.pause();
			}
		});
		
		Scene scene = new Scene(pane, 250, 250);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	public static void main(String[] args) {
		Application.launch(args);
	}

}

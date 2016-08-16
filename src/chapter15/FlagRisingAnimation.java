package chapter15;

import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FlagRisingAnimation extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Pane pane = new Pane();
		
		
		ImageView imageView = new ImageView("image/us.gif");
//		imageView.setFitWidth(200);
//		imageView.setFitHeight(200);
		pane.getChildren().add(imageView);
		
		PathTransition pt = new PathTransition(Duration.millis(10000)
				, new Line(100, 200, 100, 0), imageView);
		pt.setCycleCount(5);
		pt.play();
		
		Scene scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}

package chapter14;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ShowBorderPane extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		// create a border pane
		BorderPane pane = new BorderPane();
		
		// Place nodes in the pane
		//pane.setTop(new CustomPane("Top"));
		pane.setRight(new CustomPane("Right"));
		pane.setBottom(new CustomPane("Bottom"));
		pane.setLeft(new CustomPane("Left"));
		pane.setCenter(new CustomPane("Center"));
		
		Scene scene = new Scene(pane, 200, 200);
		primaryStage.setTitle("ShowBorderPane");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	class CustomPane extends StackPane {
		public CustomPane(String title) {
			getChildren().add(new Label(title));
			setStyle("-fx-border-color: red");
			setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		}
	}
}



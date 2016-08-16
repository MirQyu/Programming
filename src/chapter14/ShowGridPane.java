package chapter14;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ShowGridPane extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Create a pane and set its properties
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.BASELINE_RIGHT);
		pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		pane.setHgap(5.5);
		pane.setVgap(5.5);
		
		// Place nodes in the pane
		pane.add(new Label("First Name"), 0, 0);
		pane.add(new TextField(), 1, 0);
		pane.add(new Label("MI: "), 0, 1);
		pane.add(new TextField(), 1, 1);
		pane.add(new Label("Last Name: "), 0, 2);
		pane.add(new TextField(), 1, 2);
		Button button = new Button("Add Name");
		pane.add(button, 1, 3);
		GridPane.setHalignment(button, HPos.RIGHT);
		GridPane.setColumnIndex(button, 0);
		
		
		Scene scene = new Scene(pane, 500, 500);
		primaryStage.setTitle("ShowGridPane");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	public static void main(String[] args) {
		Application.launch(args);
	}
}

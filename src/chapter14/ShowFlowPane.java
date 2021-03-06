package chapter14;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ShowFlowPane extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// create a pane and set its properties
		FlowPane pane = new FlowPane();
//		pane.setAlignment(Pos.BASELINE_RIGHT);
		pane.setOrientation(Orientation.HORIZONTAL);;
		pane.setPadding(new Insets(11, 12, 13, 14));
		pane.setHgap(5);
		pane.setVgap(5);
		
		// place nodes in the pane
		pane.getChildren().addAll(new Label("First Name: "), new TextField(), new Label("MI: "));
		TextField tfMi = new TextField();
		tfMi.setPrefColumnCount(1);
		pane.getChildren().addAll(tfMi, new Label("Last Name: "), new TextField());
		
		Scene scene = new Scene(pane, 200, 250);
		primaryStage.setTitle("ShowFlowPane");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}

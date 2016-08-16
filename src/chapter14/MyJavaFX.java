package chapter14;

import javafx.application.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public final class MyJavaFX extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Button btOk = new Button("Hello World!");
		Scene scene = new Scene(btOk, 500, 500);
		primaryStage.setTitle("MyJavaFX");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
		
		Stage stage = new Stage();
		stage.setTitle("Second Stage");
		
		stage.setScene(new Scene(new Button("New Stage"), 100, 100));
		stage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}

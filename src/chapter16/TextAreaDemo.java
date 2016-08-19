package chapter16;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class TextAreaDemo extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		DescriptionPane pane = new DescriptionPane();
		pane.setTitle("American");
		pane.setImageView(new ImageView("image/us.gif"));
		pane.setDescription("The American national flag...");
		
		Scene scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}

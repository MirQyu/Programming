package chapter16;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ScrollBarDemo extends Application{

	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Text text = new Text(20, 20, "JavaFX Programming");
		
		ScrollBar sbHorizontal = new ScrollBar();
		ScrollBar sbVertical = new ScrollBar();
		sbVertical.setOrientation(Orientation.VERTICAL);
		
		// Create a text in a pane
		Pane paneForText = new Pane();
		paneForText.getChildren().add(text);
		
		BorderPane pane = new BorderPane();
		pane.setCenter(paneForText);
		pane.setBottom(sbHorizontal);
		pane.setRight(sbVertical);
		
		sbHorizontal.valueProperty().addListener(e -> {
			text.setX(paneForText.getWidth() * sbHorizontal.getValue() / sbHorizontal.getMax());
		});
		
		sbVertical.valueProperty().addListener(e -> {
			text.setY(paneForText.getHeight() * sbVertical.getValue() / sbVertical.getMax());
		});
		
		Scene scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}

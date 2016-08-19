package chapter16;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ButtonDemo extends Application{
	protected Text text = new Text(50, 50, "JavaFX Programming");
	
	
	protected BorderPane getPane() {
		HBox paneForButtons = new HBox(20);
		Button btLeft = new Button("Left", new ImageView("image/left.png"));
		Button btRight = new Button("Right", new ImageView("image/right.png"));
		btRight.setContentDisplay(ContentDisplay.RIGHT);
		paneForButtons.getChildren().addAll(btLeft, btRight);
		paneForButtons.setAlignment(Pos.CENTER);
		paneForButtons.setStyle("-fx-border-color: blue");
		
		BorderPane pane = new BorderPane();
		pane.setBottom(paneForButtons);
		
		Pane paneForText = new Pane();
		paneForText.getChildren().add(text);
		pane.setCenter(paneForText);
	
		btLeft.setOnAction(e -> text.setX(text.getX() > 10 ? text.getX() - 10 : text.getX()));
		btRight.setOnAction(e -> text.setX(text.getX() < paneForText.getWidth() - 10 ? text.getX() + 10 : text.getX()));
		
		return pane;
	}
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Scene scene = new Scene(getPane(), 450, 200);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
		
	public static void main(String[] args) {
		Application.launch(args);
	}
}

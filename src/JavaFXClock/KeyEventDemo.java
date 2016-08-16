package JavaFXClock;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import oracle.jrockit.jfr.events.EventHandlerImpl;
import javafx.scene.input.KeyEvent;

public class KeyEventDemo extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Create a pane and set it properties
		Pane pane = new Pane();
		Text text = new Text(20, 20, "A");
		
		pane.getChildren().add(text);
//		text.setOnKeyPressed(e -> {
//			switch (e.getCode()) {
//			case DOWN: 
//				text.setY(text.getY() + 10);
//				break;
//			case UP:
//				text.setY(text.getY() - 10);
//				break;
//			case LEFT:
//				text.setX(text.getX() - 10);
//				break;
//			case RIGHT:
//				text.setX(text.getX() + 10);
//				break;
//			default:
//				if (Character.isLetterOrDigit(e.getText().charAt(0)));
//				text.setText(e.getText());
//			}
//		});
		text.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent e) {
				// TODO Auto-generated method stub
				switch (e.getCode()) {
				case DOWN: 
					text.setY(text.getY() + 10);
					break;
				case UP:
					text.setY(text.getY() - 10);
					break;
				case LEFT:
					text.setX(text.getX() - 10);
					break;
				case RIGHT:
					text.setX(text.getX() + 10);
					break;
				default:
					if (Character.isLetterOrDigit(e.getText().charAt(0)));
					text.setText(e.getText());
				}
			}
			
		});
		
		// Create a scene and place
		Scene scene = new Scene(pane);
		primaryStage.setTitle("KeyEventDemo");
		primaryStage.setScene(scene);
		primaryStage.show();	
		
		text.requestFocus();
	}
	public static void main(String[] args) {
		Application.launch(args);
	}

}


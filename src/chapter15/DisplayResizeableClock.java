package chapter15;

import JavaFXClock.ClockPane;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class DisplayResizeableClock extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		ClockPane clock = new ClockPane();
		String timeString =clock.getHour() + ":" + clock.getMinute()
			+  ":" + clock.getSecond();
		Label lblCurrentTime = new Label(timeString);
		
		BorderPane pane = new BorderPane();
		pane.setCenter(clock);
		pane.setBottom(lblCurrentTime);
		BorderPane.setAlignment(lblCurrentTime, Pos.TOP_CENTER);
		
		Scene scene = new Scene(pane, 250, 250);
		primaryStage.setTitle("DisplayClock");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		scene.widthProperty().addListener(ov -> {
			clock.setW(pane.getWidth());
		});
		
		scene.heightProperty().addListener(ov -> 
			clock.setH(pane.getHeight())
		);
		
	}
	public static void main(String[] args) {
		Application.launch(args);
	}

}

package guiMap;


import chapter14.ShowBorderPane;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class MyMain extends Application implements EventHandler{

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		BorderPane pane = new BorderPane();
		Image image = new Image("image/map-1.jpg", 1200, 600, false, true);
		ImageView map = new ImageView(image);
		Pane mapPane = new Pane();
		mapPane.getChildren().add(map);
		pane.setCenter(mapPane);
		
		mapPane.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent e) {
				// TODO Auto-generated method stub
				if (true) {
					Circle c = new Circle(e.getX(), e.getY(), 10);
					c.setStroke(Color.YELLOW);
					c.setFill(Color.RED);
					mapPane.getChildren().add(c);
				}
				System.out.println(e.getX() + " " + e.getY());
			}

		});
		pane.setOnMouseClicked(e -> {
			System.out.println("x = " + e.getX() + ", y = " + e.getY());
		});
		
		HBox hbox = new HBox(10);
		Button showPathButton = new Button("显示路径");
		showPathButton.setOnAction(e -> {
			
		});
		Button restoreButton = new Button("还原");
		Button helpButton = new Button("帮助");
		Button exitButton = new Button("退出");
		
		hbox.getChildren().addAll(showPathButton, restoreButton, helpButton, exitButton);
		hbox.setAlignment(Pos.BOTTOM_RIGHT);
		pane.setBottom(hbox);
		
		Scene scene  = new Scene(pane);
		primaryStage.setTitle("test");
		primaryStage.setScene(scene);
		primaryStage.show();
		System.err.println(mapPane.getWidth() + " " + mapPane.getHeight());
		
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void handle(Event event) {
		// TODO Auto-generated method stub
		
	}
	

}

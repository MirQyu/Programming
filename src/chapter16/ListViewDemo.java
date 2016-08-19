package chapter16;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ListViewDemo extends Application{

	private String[] flagTitles = {"Canada", "China", "Denmark",
			"France", "Germany", "India", "Norway", "United Kingdom",
			"United States of America"
	};
	
	// Declare an ImageView array for the national flags of 9 countries
	private ImageView[] flagImage = {
			new ImageView("image/ca.gif"),
			new ImageView("image/china.gif"),
			new ImageView("image/denmark.gif"),
			new ImageView("image/fr.gif"),
			new ImageView("image/germany.gif"),
			new ImageView("image/india.gif"),
			new ImageView("image/norway.gif"),
			new ImageView("image/uk.gif"),
			new ImageView("image/us.gif")
	};
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		BorderPane pane = new BorderPane();
		
		FlowPane imagePane = new FlowPane(10, 10);
		imagePane.setOrientation(Orientation.HORIZONTAL);
		ObservableList<String> items = FXCollections.observableArrayList(flagTitles);
		ListView<String> lv = new ListView<>(items);
		lv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		lv.setPrefSize(200, 200);
		
		pane.setCenter(new ScrollPane(imagePane));
		pane.setLeft(new ScrollPane(lv));
		
		
		lv.getSelectionModel().selectedItemProperty().addListener(e -> {
			imagePane.getChildren().clear();
			System.err.println("begin");
			for (Integer i : lv.getSelectionModel().getSelectedIndices()) {
				if (i >= 0 && i <= 8)
					imagePane.getChildren().add(flagImage[i]);
				System.err.println(i);
			}
			System.err.println("end");

		});
		
		Scene scene = new Scene(pane, 450, 170);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}

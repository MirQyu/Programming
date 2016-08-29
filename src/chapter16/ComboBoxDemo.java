package chapter16;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ComboBoxDemo extends Application{
	// Declare an array of Strings for flag titles
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
	
	// Declare an array of strings for flag descriptions
	private String[] flagDecription = new String[9];
	
	// Declare and create a description pane
	private DescriptionPane descriptionPane = new DescriptionPane();
	
	// Create a combo box for selecting countries
	private ComboBox<String> cbo = new ComboBox<>();
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// Set text description
		flagDecription[0] = "The Canadian national flag...";
		flagDecription[1] = "Description for China...";
		flagDecription[2] = "Description for Denmark...";
		flagDecription[3] = "Description for France...";
		flagDecription[4] = "Description for Germany...";
		flagDecription[5] = "Description for India...";
		flagDecription[6] = "Description for Norway...";
		flagDecription[7] = "Description for UK...";
		flagDecription[8] = "Description for US...";
	
		// Set the first country for display
		setDisplay(0);
		
		// Add combo box and description pane to the border pane
		BorderPane pane = new BorderPane();
		
		BorderPane paneForComboBox = new BorderPane();
		Label lbl = new Label("Select a country: ");
		paneForComboBox.setLeft(lbl);
		BorderPane.setAlignment(lbl, Pos.CENTER_RIGHT);
		paneForComboBox.setCenter(cbo);
		pane.setTop(paneForComboBox);
		cbo.setPrefWidth(400);
		cbo.setValue(flagTitles[0]);
		
		ObservableList<String> items = FXCollections.observableArrayList(flagTitles);
		//cbo.setItems(items);
		cbo.getItems().addAll(items);
		cbo.setVisibleRowCount(3);
		
		pane.setCenter(descriptionPane);
		
		cbo.setEditable(true);
		// Display the selected country
		cbo.setOnAction(e -> {
			int i = items.indexOf(cbo.getValue());
			setDisplay(i != -1 ? i : 0);
		});
		
		// Create a scene and place it in the stage
		Scene scene = new Scene(pane);
		primaryStage.setTitle("ComboBoxDemo");
		primaryStage.setScene(scene);
		primaryStage.show();
	}


	private void setDisplay(int i) {
		// TODO Auto-generated method stub
		descriptionPane.setTitle(flagTitles[i]);
		descriptionPane.setImageView(flagImage[i]);
		descriptionPane.setDescription(flagDecription[i]);
	}

	
	public static void main(String[] args) {
		Application.launch(args);
	}
}

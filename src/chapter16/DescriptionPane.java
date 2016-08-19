package chapter16;

import javafx.geometry.Insets;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;

public class DescriptionPane extends BorderPane{
	
	private static final int HEIGHT = 200;

	private Label lblImageTitle = new Label();
	
	private TextArea taDescription = new TextArea();
	
	public DescriptionPane() {
		lblImageTitle.setContentDisplay(ContentDisplay.TOP);
		lblImageTitle.setPrefHeight(HEIGHT);
		
		lblImageTitle.setFont(new Font("SansSerif", 16));
		taDescription.setFont(new Font("Serif", 14));
		
		taDescription.setWrapText(true);
		taDescription.setPrefColumnCount(15);
		taDescription.setEditable(true);
		taDescription.setPrefHeight(HEIGHT);
		
		
		// Create a scroll pane to hold the text area
		ScrollPane scrollPane = new ScrollPane(taDescription);

		
		// Place label and scroll pane in the border pane
		setLeft(lblImageTitle);
		setCenter(scrollPane);
		setPadding(new Insets(5));
	}
	
	public void setTitle(String title) {
		lblImageTitle.setText(title);
	}
	
	public void setImageView(ImageView icon) {
		Image image = icon.getImage();
		double scale = image.getWidth() / image.getHeight();
		icon.setFitHeight(HEIGHT-20);
		icon.setFitWidth(scale * (HEIGHT-20));
		lblImageTitle.setGraphic(icon);
	}
	
	public void setDescription(String text) {
		taDescription.setText(text);
	}

}

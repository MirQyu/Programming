package chapter16;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class TextFieldDemo extends RadioButtonDemo{
	
	@Override
	protected BorderPane getPane() {
		BorderPane borderPane = super.getPane();
		
		BorderPane paneForTextField = new BorderPane();
		paneForTextField.setPadding(new Insets(5));
		paneForTextField.setStyle("-fx-border-color: green");
		paneForTextField.setLeft(new Label("Enter a new message: "));
		
		TextField tf = new TextField();
		tf.setAlignment(Pos.BOTTOM_RIGHT);
		paneForTextField.setCenter(tf);
		borderPane.setTop(paneForTextField);
		
		tf.setOnAction(e -> text.setText(tf.getText()));
		
		return borderPane;
		
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}

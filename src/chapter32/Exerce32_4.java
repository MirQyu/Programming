package chapter32;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exerce32_4 extends Application{
	// Statement for executing queries
	private Connection connection;
	private PreparedStatement preStmt;
	private TextField tfSSN = new TextField();
	private List<Label> lblList = new ArrayList<>();
	private TextArea ta = new TextArea();
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// Initialize database connection and create a Statement object
		initializaeDB();
		
		Button btShowGrade = new Button("Show Grade");
		HBox hBox = new HBox(5);
		hBox.getChildren().addAll(new Label("SSN"), tfSSN, btShowGrade);
		
		VBox vBox = new VBox(10);
		vBox.getChildren().add(hBox);
		ta.setEditable(false);
		vBox.getChildren().add(ta);
		
		
		tfSSN.setPrefColumnCount(6);
		btShowGrade.setOnAction(e -> showGrade());
		
		// Create a scene and place it in the stage
		Scene scene = new Scene(vBox, 420, 80);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void showGrade() {
		String ssn = tfSSN.getText();
		System.err.println(ssn);
		try {
			preStmt.setString(1, ssn);
			
			ResultSet rset = preStmt.executeQuery();
			boolean hasResult = false;
			ta.clear();
			while (rset.next()) {
				String firstName = rset.getString(1);
				String lastName = rset.getString(2);
				String title = rset.getString(3);
				String grade = rset.getString(4);
				
				hasResult = true;
				//lblList.clear();
				// Display result in a label
//				Label lblStatus = new Label();
//				lblStatus.setText(firstName + " " +
//						lastName + "'s grade on course -" + title + "- is " +
//						grade);
//				lblList.add(lblStatus);
				
				ta.setText(ta.getText() + "\n" +  firstName + " " +
						lastName + "'s grade on course -" + title + "- is " +
						grade);
				
			} 
			if (!hasResult) {
				ta.setText("Not found!");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	private void initializaeDB() {
	
		try {
			// Load the JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded");
			
			// Establish a connection
			connection = DriverManager.getConnection
					("jdbc:mysql://localhost/javabook", "scott", "tiger");
			System.out.println("Database connected");
			
			// Create a statement
			String queryString = "select firstName, lastName, title, grade " +
					 "from Student, Enrollment, Course " +
					 "where Student.ssn = ? "
					 + "and Enrollment.ssn = Student.ssn "
					 + "and Enrollment.courseId = Course.courseId";
			
			preStmt = connection.prepareStatement(queryString);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}

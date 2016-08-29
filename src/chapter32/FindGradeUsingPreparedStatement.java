package chapter32;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FindGradeUsingPreparedStatement extends Application{

	private PreparedStatement prepareStatement;
	private TextField tfSSN = new TextField();
	private TextField tfCourseId = new TextField();
	private Label lblStatus = new Label();
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// initialize database
		initializeDB();
		
		Button btShowGrade = new Button("Show Grade");
		HBox hBox = new HBox(5);
		hBox.getChildren().addAll(new Label("SSN"), tfSSN,
				new Label("Course ID"), tfCourseId, btShowGrade);
		
		VBox vBox = new VBox(10);
		vBox.getChildren().addAll(hBox, lblStatus);
		
		tfSSN.setPrefColumnCount(6);
		tfCourseId.setPrefColumnCount(6);
		btShowGrade.setOnAction(e -> showGrade());
		
		Scene scene = new Scene(vBox, 420, 90);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void showGrade() {
		String ssn = tfSSN.getText();
		String courseId = tfCourseId.getText();
		
		try {
			prepareStatement.setString(1, ssn);
			prepareStatement.setString(2, courseId);
			ResultSet rset = prepareStatement.executeQuery();
			
			if (rset.next()) {
				String firstName = rset.getString(1);
				String mi = rset.getString(2);
				String lastName = rset.getString(3);
				String title = rset.getString(4);
				String grade = rset.getString(5);
				
				lblStatus.setText(firstName + " " + mi +
						" " + lastName + "'s grade on course " + title + " is " +
						grade);
			} else {
				lblStatus.setText("Not Found");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	private void initializeDB() {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded");
			
			Connection connection = DriverManager.getConnection
					("jdbc:mysql://localhost/javabook", "scott", "tiger");
			System.out.println("Database connected");
			
			String queryString = "select firstName, mi, lastName, title, grade " +
								"from Student, Enrollment, Course " +
								"where Student.ssn = ? and Enrollment.courseId = ? " +
								"and Enrollment.ssn = Student.ssn and Enrollment.courseId = Course.courseId";
			
			prepareStatement = connection.prepareStatement(queryString);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}

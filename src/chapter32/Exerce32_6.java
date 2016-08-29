package chapter32;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exerce32_6 extends Application{

	private Connection connection;
	private PreparedStatement preStmt;
	private Statement stmt;
	private DatabaseMetaData dbMetaData;
	private ComboBox<String> cbList = new ComboBox<>();
	private TextArea tArea = new TextArea();
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		initDB();
		
		
		ResultSet rsTables = dbMetaData.getTables(null, null, null, null);
		//ResultSetMetaData rsTablesMetaData = rsTables.getMetaData();
		while (rsTables.next()) {
			cbList.getItems().add(rsTables.getString("TABLE_NAME"));
		}
		Button btShowContent = new Button("ShowContent");
		btShowContent.setOnAction(e -> {
			showContent();
		});
		
		HBox hBox = new HBox(5);
		hBox.getChildren().addAll(new Label("Tables Name: "), cbList, btShowContent);
		VBox vBox = new VBox(10);
		vBox.getChildren().addAll(hBox, tArea);
		
		Scene scene = new Scene(vBox, 420, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
	}


	private void showContent(){
		// TODO Auto-generated method stub
		String s = cbList.getValue();
		
		try {
			String queryString = "select * from " + s;
			
			ResultSet rs =  stmt.executeQuery(queryString);
			ResultSetMetaData rsMD = rs.getMetaData();
			StringBuilder result = new StringBuilder();
			for (int i = 1; i <= rsMD.getColumnCount(); i++) {
				result.append(String.format("%-18s", rsMD.getColumnName(i)));
			}
			result.append('\n');
			
			
			while (rs.next()) {
				for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
					result.append(String.format("%-18s", rs.getObject(i)));
				}
				result.append('\n');
			}
			
			tArea.clear();
			tArea.setText(result.toString());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	private void initDB() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.jdbc.Driver");
		
		connection = DriverManager.getConnection("jdbc:mysql://localhost/javabook", "scott", "tiger");
		
		dbMetaData = connection.getMetaData();
		
		//preStmt = connection.prepareStatement("select * from ?");
		stmt = connection.createStatement();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}

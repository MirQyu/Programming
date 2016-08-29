package chapter32;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SimpleJdbc {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Load the JDBC driver
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver loaded");
		
		// Connect to a database
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/javabook", "scott", "tiger");
		System.out.println("Database connected");
		
		// Create a statement
		Statement statement = connection.createStatement(); 
		
		// Execute a statement
		ResultSet resultSet = statement.executeQuery("select firstName, mi, lastName "
				+ "from Student where lastName = 'Smith'");
		
		// 
		while (resultSet.next()) {
			System.out.println(resultSet.getString(1) + "\t" +
					resultSet.getString(2) + "\t" + resultSet.getString(3));
		}
		
		// Close the connection
		connection.close();
	}
}

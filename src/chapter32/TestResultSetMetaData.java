package chapter32;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class TestResultSetMetaData {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection
				("jdbc:mysql://localhost/javabook", "scott", "tiger");
		
		Statement statement = connection.createStatement();
		String queryString = "select * from Enrollment";
		
		ResultSet resultSet =  statement.executeQuery(queryString);
		ResultSetMetaData rsMetaData = resultSet.getMetaData();
		
		for (int i = 1; i <= rsMetaData.getColumnCount(); i++) {
			System.out.printf("%-12s\t", rsMetaData.getColumnName(i));
		}
		System.err.println();
		
		while (resultSet.next()) {
			for (int i = 1; i <= rsMetaData.getColumnCount(); i++)
				System.out.printf("%-12s\t", resultSet.getObject(i));
			System.out.println();
		}
		
		connection.close();
	}

}


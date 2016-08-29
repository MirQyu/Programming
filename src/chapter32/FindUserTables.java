package chapter32;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FindUserTables {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection
				("jdbc:mysql://localhost/javabook", "scott", "tiger");
		DatabaseMetaData databaseMetaData = connection.getMetaData();
		
		ResultSet rsTables = databaseMetaData.getTables(null, null, null,new String[] {"TABLE"});
		
		while (rsTables.next()) {
			System.out.print(rsTables.getString("TABLE_NAME") + " ");
		}
		
		connection.close();
	}

}

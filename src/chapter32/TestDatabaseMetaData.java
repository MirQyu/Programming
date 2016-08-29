package chapter32;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class TestDatabaseMetaData {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver loaded");
	
		Connection connection = DriverManager.getConnection
				("jdbc:mysql://localhost/javabook", "scott", "tiger");
		System.out.println("Database connected");
		
		DatabaseMetaData dbMetaData = connection.getMetaData();
		
		System.out.println("database URL: " + dbMetaData.getURL());
		System.out.println("database username: " + dbMetaData.getUserName());
		System.out.println("database product name: " + dbMetaData.getDatabaseProductName());
		
		System.out.println("database product version: " + dbMetaData.getDatabaseProductVersion());
		System.out.println("JDBC dirver name: " + dbMetaData.getDriverName());
		System.out.println("JDBC driver version: " + dbMetaData.getDriverVersion());
		System.out.println("JDBC driver major version: " + dbMetaData.getDriverMajorVersion());
		System.out.println("JDBC driver minor version: "+ dbMetaData.getDriverMinorVersion());
		System.out.println("Max number of connection: " + dbMetaData.getMaxConnections());
		System.out.println("MaxTableNameLength: " + dbMetaData.getMaxTableNameLength());
		System.out.println("MaxColumnsTable: " + dbMetaData.getMaxColumnsInTable());
		
		ResultSet rsTables = dbMetaData.getTables("javabook", null, null, null);
		ResultSetMetaData rsTMD = rsTables.getMetaData();
		for (int i = 1; i <= rsTMD.getColumnCount(); i++) {
			System.out.printf("%-18s\t", rsTMD.getColumnName(i));
		}
		System.out.println();
		
		while (rsTables.next()) {
			for (int i = 1; i <= rsTMD.getColumnCount(); i++) {
				System.out.printf("%-18s\t", rsTables.getObject(i));
			}
			System.out.println();
		}
		
//		ResultSet rsTypeInfo =  dbMetaData.getTypeInfo();
//		ResultSetMetaData rsTypeInfoMeta = rsTypeInfo.getMetaData();
//		for (int i = 1; i < rsTypeInfoMeta.getColumnCount(); i++) {
//			System.err.printf("%-18s\t", rsTypeInfoMeta.getColumnName(i));
//		}
//		System.err.println();
//		
//		while (rsTypeInfo.next()) {
//			for (int i = 1; i < rsTypeInfoMeta.getColumnCount(); i++) {
//				System.out.printf("%-18s\t", rsTypeInfo.getObject(i));
//			}
//			System.out.println();
//		}
		
//		System.err.println("Available function: " + dbMetaData.getStringFunctions());
		
		connection.close();
	}

}

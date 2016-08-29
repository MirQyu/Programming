package chapter32;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Exerce32_8 {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/javabook", "scott", "tiger");
		
		Statement statement = connection.createStatement();
		statement.execute("drop table if exists Salary");
		statement.execute("create table Salary("
						+ "firstName varchar(100),"
						+ "lastName varchar(100),"
						+ "rank varchar(15),"
						+ "salary float)");
			
		Scanner input = new Scanner(new File("text/salary.txt"));
		while (input.hasNext()) {
			//System.err.println("come");
			String firstName = input.next();
			String lastName = input.next();
			String rank = input.next();
			float salary = input.nextFloat();
			
			statement.execute("insert into Salary values ('"
							+ firstName + "','"
							+ lastName + "','"
							+ rank + "',"
							+ salary + ")");
		}
		
		input.close();	
		connection.close();
	}

}

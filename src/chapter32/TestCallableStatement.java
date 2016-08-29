package chapter32;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class TestCallableStatement {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection
				("jdbc:mysql://localhost/javabook", "scott", "tiger");
		
		CallableStatement callableStatement = connection.prepareCall
				("? = call studentFound(?, ?)}");
		
		java.util.Scanner input = new java.util.Scanner(System.in);
		System.out.println("Enter student's first name: ");
		String firstName = input.nextLine();
		System.out.println("Enter student's last name: ");
		String lastName = input.nextLine();
		input.close();
		
		callableStatement.setString(1, firstName);
		callableStatement.setString(2, lastName);
		callableStatement.registerOutParameter(3, Types.INTEGER);
		callableStatement.execute();
		
		if (callableStatement.getInt(3) >= 1) 
			System.out.println(firstName + " " + lastName + 
					" is in the database");
		else 
			System.out.println(firstName + " " + lastName + 
					" is not in the database");
		
	}
}

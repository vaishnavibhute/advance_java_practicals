package jdbc.update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentUpdate {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		using reference variable
		
		String className="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/student";
		String username="root";
		String password="root";
		String query="UPDATE STUINFO SET NAME='PIKA' WHERE ID=1";
		
		
		Class.forName(className);
		Connection connection=DriverManager.getConnection(url, username, password);
		Statement statement=connection.createStatement();
		statement.execute(query);
		connection.close();
	}
}

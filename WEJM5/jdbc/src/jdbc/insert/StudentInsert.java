package jdbc.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentInsert {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
//		1.Load & Register the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
//		2.Establish Connection
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
		
//		3.Create Statement
		Statement statement=connection.createStatement();
		
//		4.Establish Statement
		statement.execute("INSERT INTO STUINFO VALUES (5,'VAISHU',9271668100,'PUNE')");
		//statement.execute("INSERT INTO STUINFO VALUES (3,'VAISHU',9271668100,'PUNE'),(4,'VAIBHU',9271668100,'PUNE')");
		
//		5.Close Connection
		connection.close();
	}
}

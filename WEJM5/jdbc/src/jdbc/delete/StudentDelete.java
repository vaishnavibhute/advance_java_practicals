package jdbc.delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDelete {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		String className="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/student";
		String username="root";
		String password="root";
		String query="DELETE FROM STUINFO WHERE ID=5";
		
		Class.forName(className);
		Connection connection=DriverManager.getConnection(url, username, password);
		Statement statement=connection.createStatement();
		int res=statement.executeUpdate(query);
		if(res==1) {
			System.out.println("Record Deleted Successfully");
		}
		else {
			System.out.println("Not Deleted");
		}
		connection.close();
		}
}

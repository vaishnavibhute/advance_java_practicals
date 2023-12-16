package jdbc.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class StudentFetch {
	public static void main(String[] args) throws SQLException {
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the id");
		int id=scanner.nextInt();
		
		String url="jdbc:mysql://localhost:3306/studentdb?user=root&password=root";
		String query="SELECT * FROM STUDENT WHERE ID=?";
		
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		
		Connection connection=DriverManager.getConnection(url);
		
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		
		preparedStatement.setInt(1, id);
		
		ResultSet resultset=preparedStatement.executeQuery();
		
		while (resultset.next()) {
			System.out.println(resultset.getInt(1));
			System.out.println(resultset.getString(2));
			System.out.println(resultset.getLong("phone"));
			System.out.println(resultset.getInt("marks"));
			System.out.println(resultset.getString("email"));
		} 
		
		connection.close();
	}
}

package jdbc.preparedstatement;

import java.sql.Connection;
import java.sql.Driver;//for driver interface
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

//import com.mysql.cj.jdbc.Driver; //for driver class

public class StudentDelete {
	public static void main(String[] args) throws SQLException {
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the id");
		int id=scanner.nextInt();
		
		String url="jdbc:mysql://localhost:3306/studentdb?user=root&password=root";
		String query="DELETE FROM STUDENT WHERE ID=?";
		
		//Driver driver=new Driver();//by creating object of driver class
		Driver driver=new com.mysql.cj.jdbc.Driver();//by using upcasting i.e. driver class constructor stored in driver interface
		DriverManager.registerDriver(driver);
		
		Connection connection=DriverManager.getConnection(url);
		
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		preparedStatement.setInt(1, id);
		
		int res=preparedStatement.executeUpdate();
		
		if(res==1) {
			System.out.println("Deleted");
		}
		else {
			System.out.println("Not Deleted");
		}
		
		connection.close();
	}
}

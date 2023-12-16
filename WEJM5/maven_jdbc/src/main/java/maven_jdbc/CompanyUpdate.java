package maven_jdbc;

import java.io.FileInputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.Scanner;

public class CompanyUpdate {
	public static void main(String[] args) throws Exception {

		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the id");
		int id=scanner.nextInt();
		System.out.println("Enter the name");
		String name=scanner.next();
		System.out.println("Enter the gst");
		String gst=scanner.next();
		System.out.println("Enter the address");
		String address=scanner.next();
		System.out.println("Enter the phone");
		long phone=scanner.nextLong();
		
		FileInputStream fileInputStream = new FileInputStream("companydb.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);

		Class.forName(properties.getProperty("className"));
		Connection connection = DriverManager.getConnection(properties.getProperty("url"),
				properties.getProperty("user"), properties.getProperty("password"));

		CallableStatement callableStatement = connection.prepareCall("call companydb.company_update(?,?,?,?,?)");
	
		callableStatement.setString(1, name);
		callableStatement.setString(2, gst);
		callableStatement.setString(3, address);
		callableStatement.setLong(4, phone);
		callableStatement.setInt(5, id);
		
		int count=callableStatement.executeUpdate();
		if (count == 1) {
			System.out.println("Updated Successfully");
		} else {
			System.out.println("Failed to Update");
		}
		connection.close();
	}
}

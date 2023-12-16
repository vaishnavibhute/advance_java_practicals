package maven_jdbc;

import java.io.FileInputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

public class CompanySelectbyId {
	public static void main(String[] args) throws Exception {

		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the id");
		int id=scanner.nextInt();
		
		FileInputStream fileInputStream = new FileInputStream("companydb.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);

		Class.forName(properties.getProperty("className"));
		Connection connection = DriverManager.getConnection(properties.getProperty("url"),
				properties.getProperty("user"), properties.getProperty("password"));

		CallableStatement callableStatement = connection.prepareCall("call companydb.company_selectid(?)");
	
		callableStatement.setInt(1, id);
		ResultSet resultset=callableStatement.executeQuery();
		
		while (resultset.next()) {
			System.out.println(resultset.getInt(1));
			System.out.println(resultset.getString(2));
			System.out.println(resultset.getString(3));
			System.out.println(resultset.getString("address"));
			System.out.println(resultset.getLong("phone"));
		} 

		connection.close();
	}
}

package jdbc_wejm5_simple_maven;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class PersonCrud {
public Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
		
		FileInputStream fileInputStream=new FileInputStream("dbconfigperson.properties");
		
		Properties properties=new Properties();
		properties.load(fileInputStream);
		
		Class.forName(properties.getProperty("className"));
		Connection connection=DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("user"),properties.getProperty("password"));
		
		return connection;
	}
	
	public void savePerson(int id,String name,long phone) throws ClassNotFoundException, IOException, SQLException {
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO PERSON VALUES(?,?,?)");
		
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2, name);
		preparedStatement.setLong(3, phone);
		
		int count=preparedStatement.executeUpdate();
		
		if(count==1) {
			System.out.println("Inserted");
		}else {
			System.out.println("Not Inserted");
		}
		connection.close();
	}
}

package jdbc_maven_person;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;


public class PersonCrud {
	public Connection getConnection() throws Exception {
		FileInputStream fileInputStream = new FileInputStream("persondbconfig.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);
		
		Class.forName(properties.getProperty("className"));
		Connection connection = DriverManager.getConnection(properties.getProperty("url"),
					properties.getProperty("user"), properties.getProperty("password"));
		return connection;
	}
	
	public void savePerson(int id, String name,long contact) throws Exception  {
		Connection connection = getConnection();	
		PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO PERSON VALUES(?,?,?)");
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2, name);
		preparedStatement.setLong(3, contact);
		
		int count = preparedStatement.executeUpdate();
		if(count==1) {
			System.out.println("Inserted");
		}else {
			System.out.println("Not Inserted");
		}
		
		connection.close();
	}
	
	public void updatePerson(Person person) throws Exception {
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("UPDATE PERSON SET NAME=?,PHONE=? WHERE ID=?");
		preparedStatement.setString(1, person.getName());
		preparedStatement.setLong(2, person.getPhone());
		preparedStatement.setInt(3, person.getId());
		
		int count=preparedStatement.executeUpdate();
		if (count==1) {
			System.out.println("Updated");
		} else {
             System.out.println("Not updated");
		}
		connection.close();
	}
	
	public void deletePerson(int id) throws Exception {
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("DELETE FROM PERSON WHERE ID=?");
		preparedStatement.setInt(1,id);
		int count=preparedStatement.executeUpdate();
		if (count==1) {
			System.out.println("Deleted");
		} else {
           System.out.println("Not Deleted");
		}
		connection.close();
	}
	
	public void fetchPerson(int id) throws Exception {
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM PERSON WHERE ID=?");
		preparedStatement.setInt(1,id);
		ResultSet resultSet=preparedStatement.executeQuery();
		while(resultSet.next()) {
			System.out.println(resultSet.getInt(1));
			System.out.println(resultSet.getString(2));
			System.out.println(resultSet.getLong(3));
			
		}
		connection.close();
	}
	
	public void fetchAllPerson(Person person) throws Exception {
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM PERSON ");
		
		ResultSet resultSet=preparedStatement.executeQuery();
		while(resultSet.next()) {
			System.out.println(resultSet.getInt(1));
			System.out.println(resultSet.getString(2));
			System.out.println(resultSet.getLong(3));
			
		}
		connection.close();
	}
}

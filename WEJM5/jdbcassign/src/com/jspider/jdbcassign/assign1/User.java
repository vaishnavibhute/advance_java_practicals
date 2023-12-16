package com.jspider.jdbcassign.assign1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class User {
public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String className="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/userdb?user=root&password=root";
		//String username="root";
		//String password="root";
		
		String query1="INSERT INTO USER VALUES (1,'VAISHU',9028668100,'VAISHU@10','v1234','PUNE'),(2,'VAIBHU',9028668100,'VAIBHU@10','f45234','PUNE'),(3,'ABHI',9028668100,'ABHI@89','AV748','HADPSAR'),(4,'TRUPTI',9028668100,'VTRU@738','trRH34','PUNE')";
		String query2="UPDATE USER SET NAME='PIKA' WHERE ID=1";
		String query3="DELETE FROM USER WHERE ID=1";
		String query4="SELECT * FROM USER";
		
		Class.forName(className);
		Connection connection=DriverManager.getConnection(url);
		Statement statement=connection.createStatement();
		statement.execute(query1);
		
		statement.execute(query2);
		
		int res=statement.executeUpdate(query3);
		if(res==1) {
			System.out.println("Deleted");
		}
		else {
			System.out.println("Not Deleted");
		}
		
		ResultSet resultSet=statement.executeQuery(query4);
		while(resultSet.next()) {
			System.out.println(resultSet.getInt(1));
			System.out.println(resultSet.getString(2));
			System.out.println(resultSet.getLong(3));
			System.out.println(resultSet.getString(4));
			System.out.println(resultSet.getString(5));
			System.out.println(resultSet.getString(6));
			System.out.println("******************************************");
		}
		
		connection.close();
	}
}

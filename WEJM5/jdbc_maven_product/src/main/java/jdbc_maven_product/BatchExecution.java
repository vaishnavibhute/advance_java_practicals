package jdbc_maven_product;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class BatchExecution {

	public static void main(String[] args) throws IOException, SQLException  {
		
		Product product1=new Product();
		product1.setId(1);
		product1.setName("TV");
		product1.setCost(45000);
		product1.setManufacturer("LG");
		
		Product product2=new Product();
		product2.setId(2);
		product2.setName("Maggi");
		product2.setCost(100);
		product2.setManufacturer("Nestle");
		
		Product product3=new Product();
		product3.setId(3);
		product3.setName("Mobile");
		product3.setCost(20000);
		product3.setManufacturer("ASUS");
		
		List<Product> list=new ArrayList<Product>();
		list.add(product1);
		list.add(product2);
		list.add(product3);
		
		Driver driver=new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		
		FileInputStream fileInputStream=new FileInputStream("productdbconfig.properties");
		Properties properties=new Properties();
		properties.load(fileInputStream);
		
		Connection connection=DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("user"),properties.getProperty("password"));
		
		PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO PRODUCT VALUES (?,?,?,?)");
		for(Product product: list) {
			preparedStatement.setInt(1, product.getId());
			preparedStatement.setString(2, product.getName());
			preparedStatement.setInt(3, product.getCost());
			preparedStatement.setString(4, product.getManufacturer());
			
			preparedStatement.addBatch();
		}
		
		preparedStatement.executeBatch();
		System.out.println("Records Saved in database");
		connection.close();
	}
}

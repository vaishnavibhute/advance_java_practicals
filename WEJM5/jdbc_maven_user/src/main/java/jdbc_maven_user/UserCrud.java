package jdbc_maven_user;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.cj.QueryReturnType;

public class UserCrud {

	public Connection getConnection() throws Exception {
		FileInputStream fileInputStream = new FileInputStream("dbconfiguser.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);

		Class.forName(properties.getProperty("className"));

		Connection connection = DriverManager.getConnection(properties.getProperty("url"),
				properties.getProperty("user"), properties.getProperty("password"));

		return connection;
	}

	public void signupUser(User user) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("INSERT INTO USER_PASS(ID,NAME,EMAIL,PASSWORD,ADDRESS) VALUES (?,?,?,?,?)");
		preparedStatement.setInt(1, user.getId());
		preparedStatement.setString(2, user.getName());
		preparedStatement.setString(3, user.getEmail());
		preparedStatement.setString(4, user.getPassword());
		preparedStatement.setString(5, user.getAddress());

		int count = preparedStatement.executeUpdate();
		if (count == 1) {
			System.out.println("SignUp Successfully");
		} else {
			System.out.println("Failed to SignUp");
		}
		connection.close();
	}

	public boolean loginUser(User user) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM USER_PASS WHERE EMAIL=?");
		preparedStatement.setString(1, user.getEmail());
		ResultSet resultSet = preparedStatement.executeQuery();
		String password = null;
		while (resultSet.next()) {
			password = resultSet.getString("password");
		}
		connection.close();
		if (password.equals(user.getPassword())) {
			return true;
		}
		return false;
	}

	public void displayPassword(String email) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM USER_PASS WHERE EMAIL=?");
		preparedStatement.setString(1, email);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			System.out.println("The Saved Passwords are: ");
			System.out.println("Facebook :" + resultSet.getString("facebook"));
			System.out.println("whatsapp :" + resultSet.getString("whatsapp"));
			System.out.println("snapchat :" + resultSet.getString("snapchat"));
			System.out.println("twitter :" + resultSet.getString("twitter"));
			System.out.println("instagram :" + resultSet.getString("instagram"));
		}
		connection.close();
	}

	public void updatePassword(User user) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(
				"UPDATE USER_PASS SET FACEBOOK=?,WHATSAPP=?,SNAPCHAT=?,TWITTER=?,INSTAGRAM=? WHERE EMAIL=?");
		preparedStatement.setString(1, user.getFacebook());
		preparedStatement.setString(2, user.getWhatsapp());
		preparedStatement.setString(3, user.getSnapchat());
		preparedStatement.setString(4, user.getTwitter());
		preparedStatement.setString(5, user.getInstagram());
		preparedStatement.setString(6, user.getEmail());

		int count = preparedStatement.executeUpdate();
		if (count == 1) {
			System.out.println("Updated Successfully");
		} else {
			System.out.println("Failed to Update");
		}
		connection.close();
	}
}

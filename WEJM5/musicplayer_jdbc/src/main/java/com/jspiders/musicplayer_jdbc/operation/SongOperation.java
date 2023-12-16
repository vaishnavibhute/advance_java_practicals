package com.jspiders.musicplayer_jdbc.operation;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Properties;

import com.jspiders.musicplayer_jdbc.entity.Song;

public class SongOperation {
		
	public Connection getConnection() throws ClassNotFoundException, IOException, SQLException{
		FileInputStream fileInputStream=new FileInputStream("musicdbconfig.properties");
		
		Properties properties=new Properties();
		properties.load(fileInputStream);
	
		Class.forName(properties.getProperty("className"));
		
		Connection connection=DriverManager.getConnection(properties.getProperty("url"),
				properties.getProperty("user"),properties.getProperty("password"));
		
		return connection;
		
	}
	
	public void saveSong(int id, String title,double duration,String singer) throws SQLException, ClassNotFoundException, IOException {
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO SONG VALUES(?,?,?,?)");
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2, title);
		preparedStatement.setDouble(3, duration);
		preparedStatement.setString(4, singer);
		
		int count=preparedStatement.executeUpdate();
		if(count==1) {
			System.out.println("Inserted");
		}
		else {
			System.out.println("Not Inserted");
		}
		connection.close();
	}
	
	public void updateSong(Song song) throws ClassNotFoundException, IOException, SQLException {
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("UPDATE SONG SET TITLE=?,DURATION=?,SINGER=? WHERE ID=?");
		preparedStatement.setString(1, song.getTitle());
		preparedStatement.setDouble(2, song.getDuration());
		preparedStatement.setString(3, song.getSinger());
		preparedStatement.setInt(4, song.getId());
		
		int count=preparedStatement.executeUpdate();
		if(count==1) {
			System.out.println("Updated");
		}
		else {
			System.out.println("Not Updated");
		}
		connection.close();
	}
	
	public void deleteSong(int id) throws ClassNotFoundException, IOException, SQLException {
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("DELETE FROM SONG WHERE ID=?");
	
		preparedStatement.setInt(1, id);
		
		int count=preparedStatement.executeUpdate();
		if(count==1) {
			System.out.println("Deleted");
		}
		else {
			System.out.println("Not Deleted");
		}
		connection.close();
	}
	
	public void fetchSong(int id) throws ClassNotFoundException, IOException, SQLException {
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM SONG WHERE ID=?");
	
		preparedStatement.setInt(1, id);
		
		ResultSet resultset= preparedStatement.executeQuery();
		while(resultset.next()) {
			System.out.println(resultset.getInt(1));
			System.out.println(resultset.getString(2));
			System.out.println(resultset.getDouble(3));
			System.out.println(resultset.getString(4));
			}
		connection.close();
		}
	
	public void fetchAllSong(Song song) throws ClassNotFoundException, IOException, SQLException {
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM SONG");
		
		ResultSet resultset= preparedStatement.executeQuery();
		while(resultset.next()) {
			System.out.println(resultset.getInt(1));
			System.out.println(resultset.getString(2));
			System.out.println(resultset.getDouble(3));
			System.out.println(resultset.getString(4));
			}
		connection.close();
		}
}

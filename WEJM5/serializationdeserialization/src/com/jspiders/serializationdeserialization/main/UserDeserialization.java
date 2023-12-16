package com.jspiders.serializationdeserialization.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import com.jspiders.serializationdeserialization.object.User;

public class UserDeserialization {
public static void main(String[] args) {
		
		try {
			
			File file = new File("User.txt");
			if(file.exists()) {
				
				FileInputStream fileInputStream = new FileInputStream(file);
				
				ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
				
				System.out.println("Reading object from file");
				
			    User user=(User) inputStream.readObject();
			    
			    System.out.println(user);
			    
			    fileInputStream.close();
			    inputStream.close();
			} else {
				System.out.println("file does not exist");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}

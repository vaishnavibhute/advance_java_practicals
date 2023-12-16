package com.jspiders.fileHandling.create;

import java.io.File;
import java.io.IOException;

public class FileCreate3 {
	public static void main(String[] args) {
		File file=new File("C:\\Users\\Vaishnavi\\OneDrive\\Desktop\\J2EE setup & Notes\\wejm5.txt");
		
		if(file.exists()) {
			System.out.println("File already exist...!!!");
		}
		else {
			try {
				file.createNewFile();
				System.out.println("File created successfully...!!!");
			} catch (IOException e) {
				System.out.println("File not created...!!!");			}
		}
	}
}

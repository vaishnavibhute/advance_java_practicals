package com.jspiders.fileHandling.write;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteWrite {
	public static void main(String[] args) {
	
		File file=new File("Byte.txt");
		
		if(file.exists()) {
			System.out.println("File already exists...!!!");
		}
		else {
			try {
				file.createNewFile();
				System.out.println("File created successfully...!!!");
			} catch (IOException e) {
				System.out.println("File not created...!!!");
			}
		}
		

//		char a= 45;
//		System.out.println(a);
		
//		char a='-';
//		int b=a;
//		System.out.println(b);
		
		try {
			FileOutputStream fileOutputStream= new FileOutputStream(file);
			fileOutputStream.write(45);
			System.out.println("Data written to file...!!!");
			fileOutputStream.close();
		} catch (FileNotFoundException e1) {
			System.out.println("File Not Found...!!!");
		} catch (IOException e) {
			System.out.println("Unable to write data to file...!!!");
		}
		
	}
}

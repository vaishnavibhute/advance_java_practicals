package com.jspiders.fileHandling.read;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ByteRead {
	public static void main(String[] args) {
		
		File file=new File("Byte.txt");
		
		if(file.exists()) {
			
			try {
				FileInputStream fileInputStream=new FileInputStream(file);
				System.out.println(fileInputStream.read()); 
				
//				or
//				int read = fileInputStream.read();
//				System.out.println(read);
				
				fileInputStream.close();
			} catch (FileNotFoundException e) {
				System.out.println("File Not Found...!!!");
			} catch (IOException e) {
				System.out.println("Unable to read from file...!!!");
			}
			
		}
		
		else {
			System.err.println("File does not exists...!!!");
		}
	}
}

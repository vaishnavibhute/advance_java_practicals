package com.jspiders.fileHandling.info;

import java.io.File;
import java.io.IOException;

public class FileInfo {
	public static void main(String[] args) {
		File file=new File("wejm5.txt");
		
		if(file.exists()) {
			System.out.println("File is already exist...!!!");
		}
		else {
			try {
				file.createNewFile();
				System.out.println("File is created successfully");
			} catch (IOException e) {
				System.out.println("File is not created");
			}		
		}
		
		System.out.println("Name of the file:"+file.getName());
		System.out.println("Path of the file:"+file.getAbsolutePath());
		System.out.println("Length of the file:"+file.length());
		
		if(file.canRead()) {
			System.out.println("File is Readable");
		}
		else {
			System.out.println("File is not Readable");
		}
		
		if(file.canWrite()) {
			System.out.println("File is Writable");
		}
		else {
			System.out.println("File is not Writable");
		}
		
		if(file.canExecute()) {
			System.out.println("File is Executable");
		}
		else {
			System.out.println("File is not Executable");
		}
	}
}

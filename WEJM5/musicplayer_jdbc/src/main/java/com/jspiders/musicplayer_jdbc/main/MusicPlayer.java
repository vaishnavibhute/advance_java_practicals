package com.jspiders.musicplayer_jdbc.main;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

import com.jspiders.musicplayer_jdbc.entity.Song;
import com.jspiders.musicplayer_jdbc.operation.SongOperation;


public class MusicPlayer {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		
		Song song=new Song();
		SongOperation songOperation=new SongOperation(); 
				
		boolean condition=true;
		do {
			System.out.println("Enter your choice \n1.Add Song \n2.Update Song \n3.Delete Song \n4.Display Songs by id \n5.Display all Songs list \n6.Exit");
			
			int choice=scanner.nextInt();
			
			switch(choice) {
			case 1:{
				System.out.println("Enter id:");
				int id=scanner.nextInt();
				System.out.println("Enter title of the song:");
				String title=scanner.next();
				System.out.println("Enter duration:");
				double duration=scanner.nextDouble();
				System.out.println("Enter name of singer:");
				String singer=scanner.next();
				
				song.setId(id);
				song.setTitle(title);
				song.setDuration(duration);
				song.setSinger(singer);
				
				songOperation.saveSong(id, title, duration, singer);
			}break;
			case 2:{
				System.out.println("Enter id:");
				int id=scanner.nextInt();
				System.out.println("Enter title of the song:");
				String title=scanner.next();
				System.out.println("Enter duration:");
				double duration=scanner.nextDouble();
				System.out.println("Enter name of singer:");
				String singer=scanner.next();
				
				song.setId(id);
				song.setTitle(title);
				song.setDuration(duration);
				song.setSinger(singer);
				
				songOperation.updateSong(song);
			}break;
			case 3:{
				System.out.println("Enter id:");
				int id=scanner.nextInt();
				
				songOperation.deleteSong(id);
			}break;
			case 4:{
				System.out.println("Enter id:");
				int id=scanner.nextInt();
				
				songOperation.fetchSong(id);
			}break;
			case 5:{
				songOperation.fetchAllSong(song);
			}break;
			case 6:System.out.println("Exit");
			
			break;
			default:{
				condition=false;
				break;
			}
			}
		}while(condition==true);
	
	}
}

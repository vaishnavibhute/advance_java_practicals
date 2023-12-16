package com.jspiders.musicplayer.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

import com.jspiders.musicplayer.entity.Song;
import com.jspiders.musicplayer.operations.SongOperation;

public class MusicPlayer {

	private static Scanner scanner = new Scanner(System.in);
	 private static ArrayList<SongOperation> albums = new ArrayList<>();
	 private static LinkedList<Song> list1 = new LinkedList();
	 static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		musicPlayerMenu();
		scanner.close();
		
		
	
	}
	
	private static void add() {
		
		System.out.println("Enter the count:\n");
		int n = sc.nextInt();
		
		SongOperation album = new SongOperation("first");
		for(int i = 0;i<n;i++) {
			System.out.println("Enter name:\n");
			String name = sc.next();
			System.out.println("Enter duration:\n");
			double duration = sc.nextDouble();
			System.out.println("Enter singer:\n");
			String singer = sc.next();
			album.addSong(name, duration, singer);
			albums.add(album);
			albums.get(i).addToPlayList(name, list1);
		}
			
	}
	
	private static void showAll(LinkedList<Song> playList) {

		Iterator<Song> iterator = list1.iterator();
       System.out.println("-----------------");

       while (iterator.hasNext()){
           System.out.println(iterator.next());
       }
       System.out.println(list1.size()); 

       System.out.println("-----------------");
		
	}
	private static void chooseRandom(LinkedList<Song> playList) {
		int n = playList.size();
		int randNum = (int) (Math.random()*n+1);
       System.out.println("-----------------");

       
       System.out.println(playList.get(randNum));
      

       System.out.println("-----------------");
	}
	
	private static void delete(LinkedList<Song> playList) {
		ListIterator<Song> listIterator = playList.listIterator();
		listIterator.next();
		listIterator.remove();
		if(playList.size()>0) {
			if(listIterator.hasNext()){
               System.out.println("now playing "+listIterator.next().toString());
           }
           else {
               if(listIterator.hasPrevious())
               System.out.println("now playing "+listIterator.previous().toString());
           }
		}
	}
	private static void musicPlayerMenu() {
		System.out.println("please first add some songs\n");
		System.out.println("1.Play Song\n"+"2.Add/Remove Song\n"+"3.Exit");
		int n = list1.size();
		int randNum = (int) (Math.random()*n+1);
		System.out.println(randNum);
		boolean quit = false;
		Scanner sc = new Scanner(System.in);
		while(!quit) {
			int action;
			int act;
			action  = sc.nextInt();
			
			sc.nextLine();
			switch(action) {
			
			case 1:System.out.println("1.play all songs\n"+"2.play random\n"+"3.Go Back\n");
			act  = sc.nextInt();
				switch(act) {
					case 1:System.out.println("playall");;
					showAll(list1);
					break;
					case 2:System.out.println("play random");
					chooseRandom(list1);
					break;
					case 3:System.out.println("go back");
							
					break;
			
			
			}
			
			break;
			case 2:System.out.println("1.Add songs\n"+"2.remove song\n"+"3.Go Back\n");
			act  = sc.nextInt();
			switch(act) {
				case 1:add();
				break;
				case 2:delete(list1);
				
				break;
				case 3:System.out.println("go back");
						
				break;
		
		
			}
		
			break;
			
			case 3:
			 System.out.println("Playlist complete");
            quit = true;
            break;
			
			
			}
		}
		
		
		
	}
}


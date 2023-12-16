package com.jspiders.musicplayer.operations;

import java.util.ArrayList;
import java.util.LinkedList;

import com.jspiders.musicplayer.entity.Song;

public class SongOperation {
	private String name;
	private String artist;
	private ArrayList<Song> songs;
	
	public SongOperation(String name){
		this.name = name;
		
		this.songs = new ArrayList<Song>();
	}
	
	public Song findSong(String title) {
		for(Song checkSong:songs) {
			if(checkSong.getTitle().equals(title)) {
				return checkSong;
			}
			
		}
		return null;
	}
	
	public boolean addSong(String title, double duration,String singer){
        if(findSong(title) == null){
            songs.add(new Song(title,duration,singer));
            System.out.println(title + " successfully added to the list");
            return true;
        }
        else {
            System.out.println("Song with name "+ title+ " already exist in the list");
            return false;
        }
    }
	
	public boolean addToPlayList(String title,LinkedList<Song> PlayList) {
		for(Song checkSong:this.songs) {
			if(checkSong.getTitle().equals(title)) {
				PlayList.add(checkSong);
				return true;
			}
			
		}
		return false;
	}
		
}

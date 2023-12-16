package com.jspiders.musicplayer_jdbc.entity;

public class Song {
	private int id;
	private String title;
	private double duration;
	private String singer;
	
	@Override
	public String toString() {
		return "Title: "+title+" duration: "+duration+" singer: "+singer;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	public String getTitle() {
		return title;
	}
	
	public double getDuration() {
		return duration;
	}
	
	public String getSinger() {
		return singer;
	}

	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

}

package com.winway.wwapp2;

public class AlbumItem {
	private String name;
	private String folder;
	
	public AlbumItem(){}

	public AlbumItem(String name,String folder){
		this.name  = name;
		this.folder  = folder;		
	}
	public String getName(){
		return this.name;
	}
	public String getFolder(){
		return this.folder;
	}
	public void setFolder(String folder){
		this.folder = folder;
	}
	public void setName(String name){
		this.name =name;
	}
}

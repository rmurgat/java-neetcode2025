package com.pattern.adapter;

public class SimpleBook {
	private String title;
	private String author;
	
	public SimpleBook(String title, String author) {
		super();
		this.title = title;
		this.author = author;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
}

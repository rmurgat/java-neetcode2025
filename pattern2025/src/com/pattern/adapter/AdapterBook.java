package com.pattern.adapter;

public class AdapterBook implements Book {
	
	private SimpleBook book;
	
	public AdapterBook(SimpleBook book) {
		super();
		this.book = book;
	}

	@Override
	public String getTitleAndAuthor() {
		return book.getTitle() + " by " + book.getAuthor();
	}

}

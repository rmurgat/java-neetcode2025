package com.pattern.adapter;

public class Main {

	public static void main(String[] args) {
		Book book;
		book = new AdapterBook(new SimpleBook("Lord of the ring", "Tolkien"));
		System.out.println(book.getTitleAndAuthor());
	}
}

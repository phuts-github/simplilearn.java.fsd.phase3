package com.simplilearn.spring.dependency.injection.autowiring.bytype;

public class Library {
	
//	private String bookType;
	private Book book;
	
	public Library() {
		super();
		System.out.println("Library is created..");
	}
//	public String getBookType() {
//		return bookType;
//	}
//	public void setBookType(String bookType) {
//		this.bookType = bookType;
//	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	
	public void libraryInfo() {
//		System.out.println("Library book type: " + bookType);
		System.out.println("Library book: " + book);
	}

	public void display() {
		libraryInfo();
		book.bookInfo();
	}
}

package com.simplilearn.spring.dependency.injection.autowiring.byname;

public class Book {
	private String isbn;
	private double price;
	private String bookType;
	
	public Book() {
		super();
		System.out.println("Book is create..d");
	}
	
	
	
	public Book(String isbn, double price, String bookType) {
		super();
		this.isbn = isbn;
		this.price = price;
		this.bookType = bookType;
	}



	public void bookInfo() {
		System.out.println("Book isbn: " + isbn);
		System.out.println("Book price: " + price);
		System.out.println("Book book type: " + bookType);
	}



	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", price=" + price + ", bookType=" + bookType + "]";
	}


	
	
}

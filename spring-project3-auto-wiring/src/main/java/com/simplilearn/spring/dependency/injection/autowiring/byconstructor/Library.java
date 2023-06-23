package com.simplilearn.spring.dependency.injection.autowiring.byconstructor;

public class Library {
	
//	private String bookType;
	private Book book;
	
	private Employee employee;
	
	public Library() {
		super();
		System.out.println("ByConstructor Library is created..");
	}
	
	public Library(Book book) {
		super();
		this.book = book;
	}

	public Library(Book book, Employee employee) {
		super();
		this.book = book;
		this.employee = employee;
	}


	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	
	public void libraryInfo() {
		System.out.println("Library book: " + book);
	}

	public void display() {
		libraryInfo();
		book.bookInfo();
		employee.employeeInfo();
	}
}

package com.springboot.web.crud.journalentry.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class JournalEntry {
	
	@Id	// primary key for the table
	private int id;
	private String title;
	private String category;
	
	// getters methods and setters methods
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	// to string method
	@Override
	public String toString() {
		return "JournalEntry [id=" + id + ", title=" + title + ", category=" + category + "]";
	}
	
	
}

package com.simplilearn.spring.dependency.injection.constructor.collection.map;

public class Answer {
	private String id;
	private String name;
	public Answer(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Answer [id=" + id + ", name=" + name + "]";
	}
	

	
}

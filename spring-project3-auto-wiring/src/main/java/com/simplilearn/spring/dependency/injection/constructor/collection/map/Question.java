package com.simplilearn.spring.dependency.injection.constructor.collection.map;

public class Question {
	private String id;
	private String name;
	public Question(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Question [id=" + id + ", name=" + name + "]";
	}


}

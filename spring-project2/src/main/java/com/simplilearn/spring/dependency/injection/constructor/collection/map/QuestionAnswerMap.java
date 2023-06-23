package com.simplilearn.spring.dependency.injection.constructor.collection.map;

import java.util.Map;

public class QuestionAnswerMap {

	private int id;
	private Map<Question, Answer> questionAnswerMap;
	
	public QuestionAnswerMap(int id, Map<Question, Answer> questionAnswerMap) {
//		super();
		this.id = id;
		this.questionAnswerMap = questionAnswerMap;
	}
	
	@Override
	public String toString() {
		return "QuestionAnswerMap [id=" + id + ", questionAnswerMap=" + questionAnswerMap + "]";
	}

}

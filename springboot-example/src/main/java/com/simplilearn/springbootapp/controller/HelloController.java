package com.simplilearn.springbootapp.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController 
public class HelloController {
	
	@RequestMapping("/") 
	public String hello() {
		return "Hello Everyone!!!";
	}
}

//no need to build response. it will be configured automatically by RestController

package com.simplilearn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpringMVCControllerView {
	
	@RequestMapping("/hello")
	public String redirect() {
		System.out.println("View Controller Called...");
		return "view";
	}

}

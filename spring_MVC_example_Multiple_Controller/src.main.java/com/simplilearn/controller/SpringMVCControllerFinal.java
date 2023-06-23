package com.simplilearn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpringMVCControllerFinal {
	@RequestMapping("/helloagain")
	public String display() {
		System.out.println("Final Controller Called...");
		return "final";
	}
	
}

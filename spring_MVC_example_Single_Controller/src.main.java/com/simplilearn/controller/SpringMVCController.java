package com.simplilearn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpringMVCController {
	@RequestMapping("/helloagain")
	public String display() {
		return "final";
	}
	
	@RequestMapping("/hello")
	public String redirect() {
		return "viewpage";
	}

}

package com.simplilearn.springbootmvcapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// We will be returning jsp, so we use annotation @Controller instead of @RestController
//@Controller
//public class HomeController {
//	
//	@RequestMapping("/")
//	public String home() {
//		return "home.jsp";
//	}
//}


@RestController
public class HomeController {
		
		@GetMapping("/hello")
		public String home() {
			return "Hello user, how are you";
		}

}

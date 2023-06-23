package com.simplilearn.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpringMVCControllerView {
	
	@RequestMapping("/view")
	public String display(HttpServletRequest req, Model m) {
		System.out.println("View Controller Called...");
		// read information from user
		String name = req.getParameter("name");
		String pass = req.getParameter("pass");
		String msg;
		if (pass.equals("admin")) {
			msg = "Hello " + name;
			m.addAttribute("message", msg);
			return "view";
		}
		else {
			msg = "Sorry " + name + ". Wrong password entered";
			m.addAttribute("message", msg);
			return "error";
		}
	}

}

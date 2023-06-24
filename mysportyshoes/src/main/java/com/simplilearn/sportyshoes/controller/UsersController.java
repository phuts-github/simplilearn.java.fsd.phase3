package com.simplilearn.sportyshoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.simplilearn.sportyshoes.models.Users;
import com.simplilearn.sportyshoes.repository.UsersRepository;

//@RestController
@Controller
public class UsersController {
	@Autowired
	private UsersRepository usersRepository;

//	@RequestMapping("/")
//	public ModelAndView home() {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("home.jsp");
//		return mv;
//	}

	@RequestMapping("/userAddUpdate")
	public ModelAndView userAddUpdate(
			@RequestParam int id, 
			@RequestParam String email,
			@RequestParam String name,
			@RequestParam String pass, 
			@RequestParam String admin,
			@RequestParam String adminPass,	
			@RequestParam String address			
			) {

		ModelAndView mv = new ModelAndView();

		if (
			email == "" ||
			name == "" || 
			pass == "" || 
			admin == "" || 
			adminPass == "" ||
			address == "" 
				) {
			mv.addObject("entry", "Enter all fields");
			mv.setViewName("user-add.jsp");
			return mv;
		} else {
			Users users = new Users();
			users.setId(id);
			users.setEmail(email);
			users.setName(name);
			users.setPass(pass);
			users.setAdmin(admin);
			users.setAdminPass(adminPass);
			users.setAddress(address);
			usersRepository.save(users);

			usersRepository.flush();
			mv.addObject("entry", "Added/Updated ID " + users.getId());
			mv.setViewName("user-add.jsp");
			return mv;
		}
	}

	@RequestMapping("/userList")
	public ModelAndView userList() {
		ModelAndView mv = new ModelAndView();

		List<Users> entries = usersRepository.findAll();

		if (entries.isEmpty()) {
			mv.addObject("entry", "No Users Available");
			mv.setViewName("user-add.jsp");
			return mv;
		} else {
			mv.addObject("entries", entries);
			mv.setViewName("user-add.jsp");
			return mv;
		}
	}

	@RequestMapping("/userById")
	public ModelAndView userById(@RequestParam int id) {

		ModelAndView mv = new ModelAndView();

		if (id == 0) {
			mv.addObject("entry", "ID required");
			mv.setViewName("user-add.jsp");
			return mv;
		} else {
			Integer uId = Integer.valueOf(id);

			Users entry = usersRepository.findById(uId).orElse(new Users());

			if (entry.getId() == 0) {
				mv.addObject("entry", "No Users Found");
				mv.setViewName("user-add.jsp");
				return mv;
			} else {
				mv.addObject("entry", entry);
				mv.setViewName("user-add.jsp");
				return mv;
			}
		}
	}
}

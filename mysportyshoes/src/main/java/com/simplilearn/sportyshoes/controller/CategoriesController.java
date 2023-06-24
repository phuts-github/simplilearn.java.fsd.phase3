package com.simplilearn.sportyshoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.simplilearn.sportyshoes.models.Categories;
import com.simplilearn.sportyshoes.repository.CategoriesRepository;

//@RestController
@Controller
public class CategoriesController {
	@Autowired
	private CategoriesRepository categoriesRepository;

//	@RequestMapping("/")
//	public ModelAndView home() {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("home.jsp");
//		return mv;
//	}

	@RequestMapping("/categoryAddUpdate")
	public ModelAndView categoryAddUpdate(
			@RequestParam int id, 
			@RequestParam String code,
			@RequestParam String name			
			) {

		ModelAndView mv = new ModelAndView();

		if (
			code == "" ||
			name == ""
				) {
			mv.addObject("entry", "Enter all fields");
			mv.setViewName("category-add.jsp");
			return mv;
		} else {
			Categories categories = new Categories();
			categories.setId(id);
			categories.setCode(code);
			categories.setName(name);
			categoriesRepository.save(categories);

			categoriesRepository.flush();
			mv.addObject("entry", "Added/Updated ID " + categories.getId());
			mv.setViewName("category-add.jsp");
			return mv;
		}
	}

	@RequestMapping("/categoryList")
	public ModelAndView categoryList() {
		ModelAndView mv = new ModelAndView();

		List<Categories> entries = categoriesRepository.findAll();

		if (entries.isEmpty()) {
			mv.addObject("entry", "No Categories Available");
			mv.setViewName("category-add.jsp");
			return mv;
		} else {
			mv.addObject("entries", entries);
			mv.setViewName("category-add.jsp");
			return mv;
		}
	}

	@RequestMapping("/categoryById")
	public ModelAndView categoryById(@RequestParam int id) {

		ModelAndView mv = new ModelAndView();

		if (id == 0) {
			mv.addObject("entry", "ID required");
			mv.setViewName("category-add.jsp");
			return mv;
		} else {
			Integer uId = Integer.valueOf(id);

			Categories entry = categoriesRepository.findById(uId).orElse(new Categories());

			if (entry.getId() == 0) {
				mv.addObject("entry", "No Categories Found");
				mv.setViewName("category-add.jsp");
				return mv;
			} else {
				mv.addObject("entry", entry);
				mv.setViewName("category-add.jsp");
				return mv;
			}
		}
	}
}

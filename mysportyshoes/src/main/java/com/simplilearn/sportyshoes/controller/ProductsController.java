package com.simplilearn.sportyshoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.simplilearn.sportyshoes.models.Products;
import com.simplilearn.sportyshoes.repository.ProductsRepository;

//@RestController
@Controller
public class ProductsController {
	@Autowired
	private ProductsRepository productsRepository;

//	@RequestMapping("/")
//	public ModelAndView home() {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("home.jsp");
//		return mv;
//	}

	@RequestMapping("/productAddUpdate")
	public ModelAndView productAddUpdate(
			@RequestParam int id, 
			@RequestParam String type,
			@RequestParam String brand,
			@RequestParam String code, 
			@RequestParam String descr,
			@RequestParam String color,			
			@RequestParam int size, 
			@RequestParam String status,
			@RequestParam Double price			
			) {

		ModelAndView mv = new ModelAndView();

		if (
			type == "" ||
			brand == "" || 
			code == "" ||				
			descr == "" ||
			color == "" || 
			size == 0 || 
			status == "" || 
			price == 0.00
				) {
			mv.addObject("entry", "Enter all fields");
			mv.setViewName("product-add.jsp");
			return mv;
		} else {
			Products products = new Products();
			products.setId(id);
			products.setType(type);
			products.setBrand(brand);
			products.setCode(code);
			products.setDescr(descr);
			products.setColor(color);
			products.setSize(size);
			products.setStatus(status);			
			products.setPrice(price);
			productsRepository.save(products);

			productsRepository.flush();
			mv.addObject("entry", "Added/Updated ID " + products.getId());
			mv.setViewName("product-add.jsp");
			return mv;
		}
	}

	@RequestMapping("/productList")
	public ModelAndView productList() {
		ModelAndView mv = new ModelAndView();

		List<Products> entries = productsRepository.findAll();

		if (entries.isEmpty()) {
			mv.addObject("entry", "No Products Available");
			mv.setViewName("product-add.jsp");
			return mv;
		} else {
			mv.addObject("entries", entries);
			mv.setViewName("product-add.jsp");
			return mv;
		}
	}

	@RequestMapping("/productById")
	public ModelAndView productById(@RequestParam int id) {

		ModelAndView mv = new ModelAndView();

		if (id == 0) {
			mv.addObject("entry", "ID required");
			mv.setViewName("product-add.jsp");
			return mv;
		} else {
			Integer uId = Integer.valueOf(id);

			Products entry = productsRepository.findById(uId).orElse(new Products());

			if (entry.getId() == 0) {
				mv.addObject("entry", "No Products Found");
				mv.setViewName("product-add.jsp");
				return mv;
			} else {
				mv.addObject("entry", entry);
				mv.setViewName("product-add.jsp");
				return mv;
			}
		}
	}
}

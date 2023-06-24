package com.simplilearn.sportyshoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.simplilearn.sportyshoes.models.Orders;
import com.simplilearn.sportyshoes.repository.OrdersRepository;

//@RestController
@Controller
public class OrdersController {
	@Autowired
	private OrdersRepository ordersRepository;

//	@RequestMapping("/")
//	public ModelAndView home() {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("home.jsp");
//		return mv;
//	}

	@RequestMapping("/orderAddUpdate")
	public ModelAndView orderAddUpdate(
			@RequestParam int id, 
			@RequestParam int productId,
			@RequestParam String code,
			@RequestParam Double quantity, 
			@RequestParam Double unitPrice,
			@RequestParam Double totalPrice,
			@RequestParam Double postage,	
			@RequestParam Double finalPrice			
			) {

		ModelAndView mv = new ModelAndView();

		if (
			productId == 0 ||
			code == "" || 
			quantity == 0 || 
			unitPrice == 0 || 
			totalPrice == 0 ||
			finalPrice == 0 
				) {
			mv.addObject("entry", "Enter all fields");
			mv.setViewName("order-add.jsp");
			return mv;
		} else {
			Orders orders = new Orders();
			orders.setId(id);
			orders.setProductId(productId);
			orders.setCode(code);			
			orders.setQuantity(quantity);
			orders.setUnitPrice(unitPrice);
			orders.setTotalPrice(totalPrice);
			orders.setPostage(postage);
			orders.setFinalPrice(finalPrice);
			ordersRepository.save(orders);

			ordersRepository.flush();
			mv.addObject("entry", "Added/Updated ID " + orders.getId());
			mv.setViewName("order-add.jsp");
			return mv;
		}
	}

	@RequestMapping("/orderList")
	public ModelAndView orderList() {
		ModelAndView mv = new ModelAndView();

		List<Orders> entries = ordersRepository.findAll();

		if (entries.isEmpty()) {
			mv.addObject("entry", "No Orders Available");
			mv.setViewName("order-add.jsp");
			return mv;
		} else {
			mv.addObject("entries", entries);
			mv.setViewName("order-add.jsp");
			return mv;
		}
	}

	@RequestMapping("/orderById")
	public ModelAndView orderById(@RequestParam int id) {

		ModelAndView mv = new ModelAndView();

		if (id == 0) {
			mv.addObject("entry", "ID required");
			mv.setViewName("order-add.jsp");
			return mv;
		} else {
			Integer uId = Integer.valueOf(id);

			Orders entry = ordersRepository.findById(uId).orElse(new Orders());

			if (entry.getId() == 0) {
				mv.addObject("entry", "No Orders Found");
				mv.setViewName("order-add.jsp");
				return mv;
			} else {
				mv.addObject("entry", entry);
				mv.setViewName("order-add.jsp");
				return mv;
			}
		}
	}
}

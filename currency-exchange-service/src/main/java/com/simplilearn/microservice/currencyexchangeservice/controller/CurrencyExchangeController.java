package com.simplilearn.microservice.currencyexchangeservice.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.microservice.currencyexchangeservice.model.ExchangeValue;
import com.simplilearn.microservice.currencyexchangeservice.repository.ExchangeValueRepository;

@RestController
public class CurrencyExchangeController {
	
	// autowire interface
	@Autowired
	private ExchangeValueRepository exchangeValueRepository; 
	
	//http://localhost:8011/currency-exchange/from/USD/to/INR
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		//return new ExchangeValue(101L,from,to,BigDecimal.valueOf(80));
		return exchangeValueRepository.findByFromAndTo(from, to);
	}

}

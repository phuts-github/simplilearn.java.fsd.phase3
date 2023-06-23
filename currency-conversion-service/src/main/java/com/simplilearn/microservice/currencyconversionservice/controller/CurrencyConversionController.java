package com.simplilearn.microservice.currencyconversionservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.simplilearn.microservice.currencyconversionservice.model.CurrencyConversionBean;

@RestController
public class CurrencyConversionController {

	// method to expose as Endpoint
	// http://localhost:8011/currency-conversion/from/USD/to/INR/quantity/100
	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		// return new CurrencyConversionBean(100L, from, to, new BigDecimal(80),new
		// BigDecimal(100),new BigDecimal(8000));

		// map containing hash keys for the {from} and {to} variable parameter
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);

		// invoke rest template object in the controller
		// invoke endpoint of exchange service
		ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8011/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class,
				uriVariables);
		
		CurrencyConversionBean currencyConversionBean = responseEntity.getBody();
		System.out.println(", from - " + from + ", to - " + to + ", currencyConversionBean " + currencyConversionBean.toString() );
		System.out.println("quantity - " + quantity.toString());
		System.out.println("currencyConversionBean.getId() - " + currencyConversionBean.getId().toString());
		System.out.println("currencyConversionBean.getConversionMultiple() - " + currencyConversionBean.getConversionMultiple().toString());
		System.out.println("multiply - " + quantity.multiply(currencyConversionBean.getConversionMultiple()).toString());
		return new CurrencyConversionBean(currencyConversionBean.getId(), from, to,
				currencyConversionBean.getConversionMultiple(), quantity, 
				quantity.multiply(currencyConversionBean.getConversionMultiple()));
	}

}

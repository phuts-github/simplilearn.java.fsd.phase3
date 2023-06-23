package com.simplilearn.microservice.currencyexchangeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.microservice.currencyexchangeservice.model.ExchangeValue;

//public JournalEntryRepository { 
public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {
	
	ExchangeValue findByFromAndTo(String from, String to);
}
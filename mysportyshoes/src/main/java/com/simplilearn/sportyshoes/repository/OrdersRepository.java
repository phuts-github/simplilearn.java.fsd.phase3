package com.simplilearn.sportyshoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.sportyshoes.models.Orders;

public interface OrdersRepository extends JpaRepository <Orders,Integer>{

}

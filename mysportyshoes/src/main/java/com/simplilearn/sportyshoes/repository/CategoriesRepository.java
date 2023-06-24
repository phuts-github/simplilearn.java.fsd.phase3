package com.simplilearn.sportyshoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.sportyshoes.models.Categories;

public interface CategoriesRepository extends JpaRepository <Categories,Integer>{

}

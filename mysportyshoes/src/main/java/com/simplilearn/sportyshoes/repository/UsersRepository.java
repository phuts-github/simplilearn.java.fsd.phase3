package com.simplilearn.sportyshoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.sportyshoes.models.Users;

public interface UsersRepository extends JpaRepository <Users,Integer>{

}

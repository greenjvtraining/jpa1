package com.example.simpleBbs_jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.simpleBbs_jpa.entity.User;

public interface UserRepository extends JpaRepository<User, String>{
	User findByUsernameAndPassword(String username, String password);
}

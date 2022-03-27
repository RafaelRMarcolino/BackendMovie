package com.rafael.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafael.dsmovie.entities.User;

public interface UserRepositories extends JpaRepository<User, Long> {

	User findByEmail(String email);
}
	
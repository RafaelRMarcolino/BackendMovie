package com.rafael.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafael.dsmovie.entities.Movie;

public interface MovieRepositories extends JpaRepository<Movie, Long> {

}
	
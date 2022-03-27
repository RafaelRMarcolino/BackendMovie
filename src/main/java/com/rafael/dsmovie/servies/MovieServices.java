package com.rafael.dsmovie.servies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rafael.dsmovie.dto.MovieDTO;
import com.rafael.dsmovie.entities.Movie;
import com.rafael.dsmovie.repositories.MovieRepositories;

@Service
public class MovieServices {
 
	@Autowired
	private MovieRepositories respository;
	
	@Transactional(readOnly = true)
	public Page<MovieDTO> findAll(Pageable pageable){
		
		Page<Movie> result = respository.findAll(pageable);
		Page<MovieDTO> page = result.map(x -> new MovieDTO(x));
		return page;
		
	}
	
	@Transactional(readOnly = true)
	public MovieDTO findById(Long id){
		
		Movie result = respository.findById(id).get();
		MovieDTO dto = new MovieDTO(result);
		return dto;
		
	}
}





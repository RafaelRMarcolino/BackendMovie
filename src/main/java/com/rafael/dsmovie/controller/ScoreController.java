package com.rafael.dsmovie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafael.dsmovie.dto.MovieDTO;
import com.rafael.dsmovie.dto.ScoreDTO;
import com.rafael.dsmovie.servies.ScoreServices;

@RestController
@RequestMapping(value = "/score")
public class ScoreController {
	
	@Autowired
	private ScoreServices service;
	
	@PutMapping
	public MovieDTO saveScore(@RequestBody ScoreDTO dto){
		
		MovieDTO movieDTO = service.saveScore(dto);
		return movieDTO;
	}
	
}

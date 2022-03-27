package com.rafael.dsmovie.servies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rafael.dsmovie.dto.MovieDTO;
import com.rafael.dsmovie.dto.ScoreDTO;
import com.rafael.dsmovie.entities.Movie;
import com.rafael.dsmovie.entities.Score;
import com.rafael.dsmovie.entities.User;
import com.rafael.dsmovie.repositories.MovieRepositories;
import com.rafael.dsmovie.repositories.ScoreRepositories;
import com.rafael.dsmovie.repositories.UserRepositories;

@Service
public class ScoreServices {
 
	@Autowired
	private MovieRepositories movieRespository;
	
	@Autowired
	private UserRepositories userRespository;
	
	@Autowired
	private ScoreRepositories scoreRespository;
	
	@Transactional
	public MovieDTO saveScore(ScoreDTO dto) {
		
		User user = userRespository.findByEmail(dto.getEmail());
		if(user == null) {
			user = new User();
			user.setEmail(dto.getEmail());
			user = userRespository.saveAndFlush(user);
		}
		
		Movie movie = movieRespository.findById(dto.getMovieId()).get();
		
		Score score = new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(dto.getScore());
		
		score = scoreRespository.saveAndFlush(score);
		
		double sum = 0.0;
		for (Score s : movie.getScores()) {
			
			sum = sum + s.getValue();
		}
		
		double avg = sum / movie.getScores().size();
		
		movie.setScore(avg);
		movie.setCount(movie.getScores().size());
		
		movie = movieRespository.save(movie);
		
		return new MovieDTO(movie);
		
	}
}





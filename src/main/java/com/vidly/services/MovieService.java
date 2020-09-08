package com.vidly.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.vidly.exceptions.MovieException;
import com.vidly.models.Movie;
import com.vidly.models.MovieBlobs;
import com.vidly.repositories.MovieRepository;

@Service
public class MovieService {

	private final MovieRepository repository;
	
	public MovieService(MovieRepository repository) {
		this.repository = repository;
	}
	
	public Movie getOne(Long id) {
		return repository.findById(id).orElseThrow(()-> new MovieException("Movies doesn't exist."));
	}
	
	public List<Movie> getAll() {
		return repository.findAll();
	}
	
	public Movie addMovie( Movie movie) {
		if(movie == null) throw new MovieException("Movie object can not be null");
		
		if(movie.getId() != null) {
		return repository
				.findById(movie.getId())
				.map(m -> {
					m.setTitle(movie.getTitle());
					m.setGenre(movie.getGenre());
					m.setDailyRentalRate(movie.getDailyRentalRate());
					m.setNumberInStock(movie.getNumberInStock());
					return repository.save(m);})
				.orElse(repository.save(movie));
		}
		
		return repository.save(movie);	
	}
	
	public MovieBlobs addMovieCover() {
		
	}
	
	public ResponseEntity<Object> deleteMovie(Long id) {
		if(id == null) throw new MovieException("Movie object can not be null");
		
		try {
			repository.deleteById(id);
		}catch (Exception e) {
			throw new MovieException("Movie has already been deleted.");
		}
		
		return new ResponseEntity<Object>(HttpStatus.OK);
		
	}

}

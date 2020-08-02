package com.vidly.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vidly.models.Movie;
import com.vidly.services.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {

	private final MovieService service;
	
	public MovieController(MovieService service) {
		this.service = service;
	}
	
	@CrossOrigin
	@GetMapping("/{id}")
	public Movie getMovie(@PathVariable Long id) {
		return service.getOne(id);
	}

	
	@CrossOrigin
	@GetMapping()
	public List<Movie> getAllMovies(){
		return service.getAll();
	}

	@CrossOrigin
	@PostMapping()
	public Movie addMovie(@RequestBody Movie movie){
		return service.addMovie(movie);
	}
	

	@CrossOrigin
	@DeleteMapping("/{id}")
	public ResponseEntity.BodyBuilder deleteMovie(@PathVariable Long id){
		return service.deleteMovie(id);
	}
	
}

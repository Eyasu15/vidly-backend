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
@CrossOrigin
public class MovieController {

	private final MovieService service;

	public MovieController(MovieService service) {
		this.service = service;
	}

	@GetMapping("/{id}")
	public Movie getMovie(@PathVariable Long id) {
		return service.getOne(id);
	}
	
	@GetMapping()
	public List<Movie> getAllMovies() {
		return service.getAll();
	}

	@PostMapping()
	public Movie addMovie(@RequestBody Movie movie) {
		return service.addMovie(movie);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteMovie(@PathVariable Long id) {
		return service.deleteMovie(id);
	}
}

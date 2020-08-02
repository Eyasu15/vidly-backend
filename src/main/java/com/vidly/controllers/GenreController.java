package com.vidly.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vidly.models.Genre;
import com.vidly.services.GenreService;

@RestController
@RequestMapping("/genres")
public class GenreController {

	
	private final GenreService service;
	
	public GenreController(GenreService service) {
		this.service = service;
	}
	
	@CrossOrigin
	@GetMapping()
	public List<Genre> getAllGenres() {
		return service.getAll();
	}
	
}

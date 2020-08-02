package com.vidly.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vidly.models.Genre;
import com.vidly.repositories.GenreRepository;

@Service
public class GenreService {

	
	private final GenreRepository repository;
	
	public GenreService(GenreRepository repository) {
		this.repository = repository;
	}

	public List<Genre> getAll() {
		return repository.findAll();
	}	
	
}

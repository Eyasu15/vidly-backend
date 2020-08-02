package com.vidly.services;

import org.springframework.stereotype.Service;

import com.vidly.exceptions.UserExistsException;
import com.vidly.models.User;
import com.vidly.repositories.UserRepository;

@Service
public class UserService {

	private final UserRepository repository;
	
	public UserService(UserRepository repository) {
		this.repository = repository;
	}
	
	public User registerUser(User newUser ) {
		if(repository.findByEmail(newUser.getEmail()).isPresent()) {
			throw new UserExistsException("Email already used.");
		}
		return repository.save(newUser);
	}
	
}

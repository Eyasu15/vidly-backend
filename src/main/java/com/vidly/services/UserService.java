package com.vidly.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.vidly.exceptions.UserException;
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
			throw new UserException("Email already used.");
		}
		return repository.save(newUser);
	}
	
	public ResponseEntity<Object> deleteUser(Long id) {
		try {
			repository.deleteById(id);
		}catch(Exception e) {
			throw new UserException("User already deleted");
		}
		
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}

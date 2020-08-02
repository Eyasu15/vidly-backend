package com.vidly.services;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vidly.exceptions.UserExistsException;
import com.vidly.models.User;
import com.vidly.repositories.UserRepository;

@RestController
@RequestMapping("/users")
public class UserService {

	private final UserRepository repository;
	
	public UserService(UserRepository repository) {
		this.repository = repository;
	}
	
	//get user
	
	//register user
	@CrossOrigin
	@PostMapping
	public User registerUser(@RequestBody User newUser ) {
		if(repository.findByEmail(newUser.getEmail()).isPresent()) {
			throw new UserExistsException("Email already used.");
		}
		return repository.save(newUser);
	}
	
	//delete user
	//return  status
}

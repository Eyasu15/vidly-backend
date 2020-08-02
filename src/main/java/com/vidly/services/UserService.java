package com.vidly.services;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	@PostMapping
	public User registerUser(@RequestBody User newUser ) {
		return repository
				.findById(newUser.getId()).map(user -> {
					user.setName(newUser.getName());
					user.setEmail(newUser.getEmail());
					return user;
				})
				.orElse(repository.save(newUser));
	}
	
	//delete user
	//return  status
}

package com.vidly.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vidly.models.AuthRequest;
import com.vidly.models.User;
import com.vidly.services.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "localhost:3000")
public class UserController {

	private final UserService service;

	public UserController(UserService service) {
		this.service = service;
	}
	
	@PostMapping("/register")
	public User register(@RequestBody User user) {
		return service.registerUser(user);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable Long id) {
		return service.deleteUser(id);
	}
	
	
	@PostMapping("/login")
	public String login(@RequestBody AuthRequest authRequest) {
		return service.generateToken(authRequest);
	}
	
}

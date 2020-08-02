package com.vidly.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vidly.models.User;
import com.vidly.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	private final UserService service;
	
	public UserController(UserService service) {
		this.service = service;
	}
	@CrossOrigin
	@PostMapping
	public User register(@RequestBody User user) {
		return service.registerUser(user);
	}
}

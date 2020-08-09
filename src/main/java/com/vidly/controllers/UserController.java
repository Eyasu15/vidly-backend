package com.vidly.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vidly.exceptions.UserException;
import com.vidly.models.AuthRequest;
import com.vidly.models.User;
import com.vidly.services.UserService;
import com.vidly.util.JwtUtil;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {

	private final UserService service;
	private final JwtUtil jwtUtil;
	private final AuthenticationManager authManager;
	
	public UserController(UserService service, JwtUtil jwtUtil, AuthenticationManager authManager) {
		this.service = service;
		this.jwtUtil = jwtUtil;
		this.authManager = authManager;
	}
	
	
	@PostMapping
	public User register(@RequestBody User user) {
		return service.registerUser(user);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable Long id) {
		return service.deleteUser(id);
	}
	
	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthRequest authRequest) {
		try {
			authManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						authRequest.getEmail(), authRequest.getPassword()));
		} catch (Exception ex) {
			throw new UserException("Invalid username/password");
		}
		
		return jwtUtil.generateToken(authRequest.getEmail());
	}
	
}

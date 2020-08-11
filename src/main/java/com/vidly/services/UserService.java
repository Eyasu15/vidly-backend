package com.vidly.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.vidly.exceptions.UserException;
import com.vidly.models.AuthRequest;
import com.vidly.models.User;
import com.vidly.repositories.UserRepository;
import com.vidly.util.JwtUtil;

@Service
public class UserService {

	private final UserRepository repository;
	private final JwtUtil jwtUtil;
	private final AuthenticationManager authManager;
	private BCryptPasswordEncoder encoder;
	
	public UserService(UserRepository repository, JwtUtil jwtUtil, AuthenticationManager authManager, BCryptPasswordEncoder encoder) {
		this.jwtUtil = jwtUtil;
		this.authManager = authManager;
		this.encoder = encoder;
		this.repository = repository;
	}
	
	public User registerUser(User newUser ) {
		if(repository.findByEmail(newUser.getEmail()).isPresent()) {
			throw new UserException("Email already used.");
		}
		newUser.setPassword(encoder.encode(newUser.getPassword()));
		
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
	
	public String generateToken(AuthRequest authRequest) {
		try {
			authManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						authRequest.getEmail(), authRequest.getPassword()));
		} catch (Exception ex) {
			throw new UserException("Invalid username/password");
		}
		
		User user = repository.findByEmail(authRequest.getEmail()).get();
		
		return jwtUtil.generateToken(user);
	}
	
}

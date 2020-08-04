package com.vidly.services;

import org.springframework.stereotype.Service;

import com.vidly.repositories.CustomerRepository;

@Service
public class CustomerService {
	
	private final CustomerRepository repository;
	
	public CustomerService(CustomerRepository repository) {
		this.repository = repository;
	}

}

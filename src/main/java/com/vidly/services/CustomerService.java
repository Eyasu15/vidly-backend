package com.vidly.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vidly.models.Customer;
import com.vidly.repositories.CustomerRepository;

@Service
public class CustomerService {
	
	private final CustomerRepository repository;
	
	public CustomerService(CustomerRepository repository) {
		this.repository = repository;
	}

	public Customer getCustomer(Long id) {
		Optional<Customer> result = repository.findById(id);
		if(result.isPresent()) return result.get();
		throw new CustomerException("Customer not found.");
	}
}

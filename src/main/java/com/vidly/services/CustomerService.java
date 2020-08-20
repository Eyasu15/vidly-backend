package com.vidly.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.vidly.exceptions.CustomerException;
import com.vidly.models.Customer;
import com.vidly.repositories.CustomerRepository;

@Service
public class CustomerService {
	
	private final CustomerRepository repository;
	
	public CustomerService(CustomerRepository repository) {
		this.repository = repository;
	}
	
	public List<Customer> getAllCustomers(){
		return repository.findAll();
	}

	public Customer getCustomer(Long id) {
		return repository
				.findById(id)
				.orElseThrow(() -> new CustomerException("Customer not found."));
	}
	
	public Customer addCustomer(Customer newCustomer) {
		if(newCustomer == null) throw new CustomerException("Customer can't be null");
		
		return repository.save(newCustomer);
	}
	
	public ResponseEntity<Object> deleteCustomer(Long id){
		try {
			repository.deleteById(id);
		} catch (Exception e) {
			throw new CustomerException("Customer doesn't exists");
		}
		
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
}

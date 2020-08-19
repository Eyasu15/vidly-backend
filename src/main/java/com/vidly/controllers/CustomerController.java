package com.vidly.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vidly.models.Customer;
import com.vidly.services.CustomerService;

@RestController
@RequestMapping("/customers")
@CrossOrigin
public class CustomerController {

	private final CustomerService service;
	
	public CustomerController(CustomerService service) {
		this.service = service;
	}
	
	@GetMapping("/{id}")
	public Customer getCustomer(@PathVariable Long id) {
		return service.getCustomer(id);
	}
	
	@GetMapping()
	public List<Customer> getAllCustomers() {
		return service.getAllCustomers();
	}
	
	@PostMapping()
	public Customer addCustomer(@RequestBody Customer newCustomer) {
		return service.addCustomer(newCustomer);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteCustomer(@PathVariable Long id) {
		return service.deleteCustomer(id);
	}
}

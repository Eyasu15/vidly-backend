package com.vidly.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.vidly.services.CustomerService;

@RestController
public class CustomerController {

	private final CustomerService service;
	
	public CustomerController(CustomerService service) {
		this.service = service;
	}
	
	
}

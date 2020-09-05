package com.vidly.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vidly.models.Rental;
import com.vidly.services.RentalService;

@RestController
@RequestMapping("/rentals")
public class RentalController {

	private final RentalService service;

	public RentalController(RentalService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/{id}")
	public Rental getOne(@PathVariable Long id) {
		return service.getOneRental(id);
	}

	@GetMapping
	public List<Rental> getAll(){
		return service.getAllRentals();
	}
	
	@PostMapping
	public Rental rentMovie(@RequestBody Rental rental) {
		return service.rentMovie(rental);
	}
	
	@PutMapping("/{id}")
	public Rental returnMovie(@PathVariable Long id, @RequestBody Rental rental) {
		return service.returnMovie(rental, id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteRental(@PathVariable Long id) {
		return service.deleteRental(id);
	}
	
}

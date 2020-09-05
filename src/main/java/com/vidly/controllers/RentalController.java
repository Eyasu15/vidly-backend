package com.vidly.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vidly.models.Rental;
import com.vidly.services.RentalService;

@RestController
@RequestMapping("/rentals")
@CrossOrigin
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
	
	@PostMapping()
	public Rental rentMovie(@RequestBody Rental rental, @RequestParam Long movieId, @RequestParam Long customerId) {
		return service.rentMovie(rental, movieId, customerId);
	}
	
	@PutMapping
	public Rental returnMovie(@RequestBody Rental rental) {
		return service.returnMovie(rental);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteRental(@PathVariable Long id) {
		return service.deleteRental(id);
	}
	
}

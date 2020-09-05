package com.vidly.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.vidly.models.Rental;
import com.vidly.repositories.RentalRepository;

@Service
public class RentalService {

	private final RentalRepository repository;

	public RentalService(RentalRepository repository) {
		super();
		this.repository = repository;
	}
	
	public Rental rentMovie(Rental rental) {
		return repository.save(rental);
	}

	public Rental returnMovie(Rental rental, Long id) {
		rental.returnMovie();
		
		Rental returnedRental = repository.findById(id)
			.map(r -> {
				r.setDateReturned(rental.getDateReturned());
				r.setIsReturned(rental.getIsReturned());
				r.setRentalFee(rental.getRentalFee());
				return r;
			}).orElse(repository.save(rental));
		
		return repository.save(returnedRental);
	}

	public List<Rental> getAllRentals() {
		return repository.findAll();
	}

	public Rental getOneRental(Long id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Rental doesn't exist"));
	}

	public ResponseEntity<Object> deleteRental(Long id) {
		try { 
			repository.deleteById(id);
		}catch(Exception e) {
			throw new EntityNotFoundException("Rental doesn't exist.");
		}
		
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}

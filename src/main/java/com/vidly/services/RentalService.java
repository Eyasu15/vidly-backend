package com.vidly.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.vidly.models.Customer;
import com.vidly.models.Movie;
import com.vidly.models.Rental;
import com.vidly.models.Status;
import com.vidly.repositories.CustomerRepository;
import com.vidly.repositories.MovieRepository;
import com.vidly.repositories.RentalRepository;

@Service
public class RentalService {

	private final RentalRepository repository;
	private final MovieRepository movieRepository;
	private final CustomerRepository customerRepository;

	

	public RentalService(RentalRepository repository, MovieRepository movieRepository,
			CustomerRepository customerRepository) {
		super();
		this.repository = repository;
		this.movieRepository = movieRepository;
		this.customerRepository = customerRepository;
	}

	public Rental rentMovie(Rental rental, Long movieId, Long customerId) {
		Customer customer = customerRepository.findById(customerId).get();
		Movie movie = movieRepository.findById(movieId).get();
		
		rental.setCustomer(customer);
		rental.setMovie(movie);
		rental.setCustomerName(customer.getName());
		rental.setMovieTitle(movie.getTitle());
		rental.setStatus(Status.RENTED);
		
		return repository.save(rental);
	}

	public Rental returnMovie(Long id) {
		
		Rental rental = repository.findById(id).get();
		rental.returnMovie();
			
		
		return repository.save(rental);
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

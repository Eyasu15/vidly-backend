package com.vidly.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Rental {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Customer customer;
	
	@OneToOne
	private Movie movie;
	private LocalDate dateOut;
	private LocalDate dateReturned;
	private Double rentalFee;
	
	public void returnMovie() {
		dateReturned = LocalDate.now();
		int rentalDays = dateReturned.getDayOfYear() - dateOut.getDayOfYear();
		rentalFee = Double.valueOf(rentalDays * movie.getDailyRentalRate());
	}
}

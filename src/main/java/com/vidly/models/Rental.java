package com.vidly.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Rental {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JsonIgnore
	private Customer customer;
	
	private String customerName;
	private String movieTitle;
	
	@OneToOne
	@JsonIgnore
	private Movie movie;
	private LocalDate dateOut;
	private LocalDate dateReturned;
	private Boolean isPaid = false;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	private Double rentalFee;
	
	public void returnMovie() {
		dateReturned = LocalDate.now();
		int rentalDays = dateReturned.getDayOfYear() - dateOut.getDayOfYear();
		rentalFee = Double.valueOf(rentalDays * movie.getDailyRentalRate());
		status = Status.RETURNED;
		isPaid = true;
	}
}

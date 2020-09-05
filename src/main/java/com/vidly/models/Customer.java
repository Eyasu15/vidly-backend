package com.vidly.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private Boolean isGold;
	private String phone;
	
	@OneToMany
	private List<Rental> moviesRented;

	@OneToMany(mappedBy = "customer")
	private List<Review> reviews;

}

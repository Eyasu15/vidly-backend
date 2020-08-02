package com.vidly.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
public class Movie {

	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String title;

	@OneToOne
	private Genre genre;
	
	@Min(0) @Max(255)
	private Integer numberInStock;
	
	@Min(0) @Max(10)
	private Double dailyRentalRate;

	
}

package com.vidly.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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

	@Embedded
	private Rating rate;
	
	@OneToMany
	private List<Review> reviews= new ArrayList<Review>();
	private Double averageReviews;
	
	
	public void setAverageReviews() {
		
		double average = 0;
		
		if(reviews.size() > 0) {
			int total = 0;
			for(Review review : reviews) {
				total += review.getRate();
			}
			average = total / reviews.size();
		}
		averageReviews = average;
	}
}

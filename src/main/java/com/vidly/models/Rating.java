package com.vidly.models;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Rating {

	private String rate;
	private String info;
	private String description;
	
}

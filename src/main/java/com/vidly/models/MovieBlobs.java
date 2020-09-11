package com.vidly.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class MovieBlobs {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Lob
	private Byte[] cover;
	
	@OneToOne
	private Movie movie;
}

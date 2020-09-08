package com.vidly.models;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class MovieBlobs {

	@Lob
	private Byte[] cover;
	
	@OneToOne
	private Movie movie;
}

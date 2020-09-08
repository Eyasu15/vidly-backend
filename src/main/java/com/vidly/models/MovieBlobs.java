package com.vidly.models;

import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

@Entity
public class MovieBlobs {

	@Lob
	private Blob cover;
	
	@OneToOne
	private Movie movie;
}

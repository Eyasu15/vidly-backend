package com.vidly.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.Data;

@Data
@Entity
public class User {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Min(2) @Max(50)
	private String name;
	@Email
	private String email;
	@Min(5) @Max(255)
	private String password;
	private Boolean isAdmin;
}

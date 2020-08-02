package com.vidly.exceptions;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorDetails {
	
	private LocalDate timestamp;
	private String message;
	private String details;
	
	
	
}

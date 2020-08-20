package com.vidly.exceptions;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import java.time.LocalDate;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request){
		ErrorDetails error = new ErrorDetails(LocalDate.now(),ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<Object>(error, INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(MovieException.class)
	public final ResponseEntity<Object> handleMovieException(Exception ex, WebRequest request){
		ErrorDetails error = new ErrorDetails(LocalDate.now(),ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<Object>(error, BAD_REQUEST);
	}
	
	@ExceptionHandler(UserException.class)
	public final ResponseEntity<Object> handleUserException(Exception ex, WebRequest request){
		ErrorDetails error = new ErrorDetails(LocalDate.now(),ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<Object>(error, BAD_REQUEST);
	}
	
	@ExceptionHandler(CustomerException.class)
	public final ResponseEntity<Object> handleCustomerException(Exception ex, WebRequest request){
		ErrorDetails error = new ErrorDetails(LocalDate.now(),ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<Object>(error, BAD_REQUEST);
	}
	
}

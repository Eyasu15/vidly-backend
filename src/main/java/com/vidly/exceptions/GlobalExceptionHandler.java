package com.vidly.exceptions;

import java.time.LocalDate;

import static org.springframework.http.HttpStatus.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
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
}

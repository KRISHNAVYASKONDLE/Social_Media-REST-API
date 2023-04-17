package com.in28Minutes.rest.webservices.restfulwebservices.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.in28Minutes.rest.webservices.restfulwebservices.User.UserNotFoundException;

@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<ErrorDetails> handlUsernotFoundException(Exception ex, WebRequest request) throws Exception {
		
		ErrorDetails ed=new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));

				return new ResponseEntity<ErrorDetails>(ed,HttpStatus.NOT_FOUND);
}
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) 
	{
		
		ErrorDetails ed=new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<Object>(ed,HttpStatus.BAD_REQUEST);	
	}
}

	
	

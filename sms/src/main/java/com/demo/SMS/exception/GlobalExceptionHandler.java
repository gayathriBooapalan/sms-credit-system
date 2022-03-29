package com.demo.SMS.exception;

import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	//Handle SPecific exceptions and global exception
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleGlobalException(Exception exception,WebRequest request)
	{
	  ErrorDetails errorDetails=new ErrorDetails(new Date(),exception.getMessage(),request.getDescription(false));
	  return new ResponseEntity(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	//Hansdles Api Error
	@ExceptionHandler(ApiException.class)
	public ResponseEntity<ErrorDetails> handleApiException(ApiException exception,WebRequest request)
	{
		System.out.println("Appi exception");
	  ErrorDetails errorDetails=new ErrorDetails(new Date(),exception.getMessage(),request.getDescription(false));
	  return new ResponseEntity(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception,WebRequest request)
	{
	  ErrorDetails errorDetails=new ErrorDetails(new Date(),exception.getMessage(),request.getDescription(false));
	  return new ResponseEntity(errorDetails,HttpStatus.NOT_FOUND);
	}
}

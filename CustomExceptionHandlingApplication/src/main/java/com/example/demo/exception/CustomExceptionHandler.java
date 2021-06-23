package com.example.demo.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	
	@ExceptionHandler(UnathorizedException.class)
	public ResponseEntity<Object> handlingResourceNotFound(UnathorizedException ex){
		
		List<String> details=new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		ErrorResponse error=new ErrorResponse(ex.getMessage(), HttpStatus.UNAUTHORIZED,details);
		
		return new ResponseEntity<>(error,error.getStatus());
		
	}
	
	@ExceptionHandler(ResourceNotFound.class)
	public ResponseEntity<Object> handlingResourceNotFound(ResourceNotFound ex){
		
		List<String> details=new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		ErrorResponse error=new ErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND,details);
		
		return new ResponseEntity<>(error,error.getStatus());
		
	}
	
	  @ExceptionHandler(Exception.class) 
	  public final ResponseEntity<Object>  handleAllExceptions(Exception ex, WebRequest request) { 
		
		  List<String> details = new ArrayList<>(); 
		  details.add(ex.getLocalizedMessage()); 
		  ErrorResponse  error = new ErrorResponse("Server Error", details); 
		  
		  return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
		  
	  }
	  
	  @Override
	  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders
	  headers, HttpStatus status, WebRequest request) {
	   
	  List<String> details = new
	  ArrayList<>(); for (ObjectError error : ex.getBindingResult().getAllErrors())
	  { 
		  details.add(error.getDefaultMessage()); 
	  } 
	  ErrorResponse error = new  ErrorResponse("Validation Failed",HttpStatus.BAD_REQUEST, details); 
	  return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST); }
	 
}

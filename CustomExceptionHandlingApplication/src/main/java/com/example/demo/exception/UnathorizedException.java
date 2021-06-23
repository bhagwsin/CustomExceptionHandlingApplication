package com.example.demo.exception;

public class UnathorizedException extends RuntimeException {

	private String message;
	
	public UnathorizedException(String message) {
		this.message=message;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}

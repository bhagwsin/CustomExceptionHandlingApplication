package com.example.demo.exception;

public class ResourceNotFound extends RuntimeException {

	private String message;

	public ResourceNotFound(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}

package com.epsilon.training.utils;

public class InvalidIdException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public InvalidIdException() {
	}
	
	public InvalidIdException(String message) {
		super(message);
	}
	
	public InvalidIdException(Throwable cause) {
		super(cause);
	}
}

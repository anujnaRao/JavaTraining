package com.epsilon.training.utils;

public class InvalidSalaryException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public InvalidSalaryException() {
	}

	public InvalidSalaryException(String message) {
		super(message);
	}

	public InvalidSalaryException(Throwable cause) {
		super(cause);
	}
}

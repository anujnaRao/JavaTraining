package com.epsilon.training.exception;

public class NotJsonSerializableException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public NotJsonSerializableException() {
		super();
		
	}
	public NotJsonSerializableException(String msg) {
		super(msg);
	}
}

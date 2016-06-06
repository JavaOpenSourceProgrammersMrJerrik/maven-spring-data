package com.mangocity.spring.common.exception;

public class CheckedException extends Exception {
	private String message;

	public CheckedException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}

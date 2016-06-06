package com.mangocity.spring.common.exception;

public class UtilException extends CheckedException {
	private String message;

	public UtilException(String message) {
		super(message);
		
	}

}

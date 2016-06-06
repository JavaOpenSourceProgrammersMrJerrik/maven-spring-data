package com.mangocity.spring.common.exception;

import com.google.common.util.concurrent.UncheckedExecutionException;

public class PersistenceException extends UncheckedExecutionException {
	private String message;

	public PersistenceException(String message) {
		super();
		this.message = message;
	}
	
}

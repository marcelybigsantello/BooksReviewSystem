package com.masantello.booksreviewsystem.services.exception;

public class DataIntegrityViolationsException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DataIntegrityViolationsException(String message) {
		super(message);
	}
}

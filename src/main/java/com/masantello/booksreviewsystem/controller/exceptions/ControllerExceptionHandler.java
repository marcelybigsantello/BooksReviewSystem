package com.masantello.booksreviewsystem.controller.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.masantello.booksreviewsystem.services.exception.ObjectNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<StandardError> getObjectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError error = new StandardError(System.currentTimeMillis(), status.value(), "Não encontrado",
				e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(error);
	}
}

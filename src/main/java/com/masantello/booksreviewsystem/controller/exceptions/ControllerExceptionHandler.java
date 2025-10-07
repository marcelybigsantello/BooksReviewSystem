package com.masantello.booksreviewsystem.controller.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.masantello.booksreviewsystem.services.exception.BadRequestException;
import com.masantello.booksreviewsystem.services.exception.DataIntegrityViolationsException;
import com.masantello.booksreviewsystem.services.exception.ConflictException;
import com.masantello.booksreviewsystem.services.exception.ObjectNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {
	
	private ControllerExceptionHandler() {
		
	}
	
	@ExceptionHandler
	public static ResponseEntity<StandardError> getObjectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError error = new StandardError(System.currentTimeMillis(), status.value(), "Não encontrado",
				e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(error);
	}
	
	@ExceptionHandler
	public static ResponseEntity<StandardError> getDataIntegrityViolation(DataIntegrityViolationsException e, 
			HttpServletRequest request) {
		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.PRECONDITION_FAILED.value(), 
				"Pre condição violada",
				e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(error);
	}
	
	@ExceptionHandler
	public static ResponseEntity<StandardError> getBadRequest(BadRequestException e, 
			HttpServletRequest request) {
		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), 
				"Estrutura incorreta de requisição",
				e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
	@ExceptionHandler
	public static ResponseEntity<StandardError> getConflict(ConflictException e, 
			HttpServletRequest request) {
		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.CONFLICT.value(), "Registro já existe.",
				e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
	}

}

package com.masantello.booksreviewsystem.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.masantello.booksreviewsystem.domain.Author;
import com.masantello.booksreviewsystem.dto.AuthorDTO;
import com.masantello.booksreviewsystem.services.AuthorService;

@RestController
@RequestMapping(value = "/authors")
public class AuthorController {
	
	private final AuthorService service;
	
	@Autowired
	public AuthorController(AuthorService service) {
		this.service = service;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<AuthorDTO>> findAll() {
		List<Author> authors = service.findAll();
		List<AuthorDTO> authorsDto = authors.stream().map(author -> new AuthorDTO(author)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(authorsDto);
	}

}

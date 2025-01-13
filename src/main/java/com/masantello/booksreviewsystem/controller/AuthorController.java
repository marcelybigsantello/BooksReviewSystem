package com.masantello.booksreviewsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.masantello.booksreviewsystem.domain.Author;
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
	public ResponseEntity<List<Author>> findAll() {
		List<Author> authors = service.findAll();
		
		return ResponseEntity.ok().body(authors);
	}

}

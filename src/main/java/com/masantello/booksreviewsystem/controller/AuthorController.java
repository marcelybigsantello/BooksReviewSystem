package com.masantello.booksreviewsystem.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<AuthorDTO> findById(@PathVariable String id) {
		Author author = service.findById(id);
		return ResponseEntity.ok().body(new AuthorDTO(author));
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody AuthorDTO authorDto) {
		Author author = service.fromDto(authorDto);
		author = service.insert(author);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(author.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<AuthorDTO> delete(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}

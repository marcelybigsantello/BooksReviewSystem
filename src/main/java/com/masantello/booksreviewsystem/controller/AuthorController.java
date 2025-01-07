package com.masantello.booksreviewsystem.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.masantello.booksreviewsystem.domain.Author;
import com.masantello.booksreviewsystem.domain.enums.Genrer;

@RestController
@RequestMapping(value = "/authors")
public class AuthorController {
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Author>> findAll() {
		Author a1 = new Author("1", "George Orwell", "georgeorwell@gmail.com", LocalDate.of(1903, 06, 25), Genrer.DYSTOPIAN);
		Author a2 = new Author("2", "Kiera Cass", "kieracass@gmail.com", LocalDate.of(1981, 05, 19), Genrer.ROMANCE);
		List<Author> authors = new ArrayList<>();
		authors.addAll(Arrays.asList(a1, a2));
		
		return ResponseEntity.ok().body(authors);
	}

}

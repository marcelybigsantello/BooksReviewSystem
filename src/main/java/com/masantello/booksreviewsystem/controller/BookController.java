package com.masantello.booksreviewsystem.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.masantello.booksreviewsystem.domain.Book;
import com.masantello.booksreviewsystem.dto.BookDTO;
import com.masantello.booksreviewsystem.services.BookService;

@RestController
@RequestMapping(value = "/books")
public class BookController {
	
	private final BookService bookService;
	
	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<BookDTO>> findAll() {
		List<Book> books = bookService.findAll();
		
		List<BookDTO> booksDto = books.stream().map(book -> new BookDTO(book)).collect(Collectors.toList());
		return ResponseEntity.ok().body(booksDto);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<BookDTO> findOne(@PathVariable String id) {
		Book book = bookService.findById(id);
		
		return ResponseEntity.ok().body(new BookDTO(book));
	}

}

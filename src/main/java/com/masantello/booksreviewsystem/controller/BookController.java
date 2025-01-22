package com.masantello.booksreviewsystem.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.masantello.booksreviewsystem.domain.Author;
import com.masantello.booksreviewsystem.domain.Book;
import com.masantello.booksreviewsystem.domain.enums.Genrer;
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
		//List<Book> books = bookService.findAll();
		Author author = new Author("06", "George Orwell", "georgeorwellofficial@gmail.com", LocalDate.now(), Genrer.DYSTOPIAN);
		List<Book> books = new ArrayList<>();
		books.add(new Book("01", "A Revolução dos Bichos", "Teste", "Editora Arqueiro", (short) 90, 
				LocalDate.of(2005, 9, 01), (float) 19.90, 100, author));
		
		List<BookDTO> booksDto = books.stream().map(book -> new BookDTO(book)).collect(Collectors.toList());
		return ResponseEntity.ok().body(booksDto);
	}

}

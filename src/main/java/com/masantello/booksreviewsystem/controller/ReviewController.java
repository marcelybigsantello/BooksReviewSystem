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

import com.masantello.booksreviewsystem.domain.BookReview;
import com.masantello.booksreviewsystem.dto.BookReviewDTO;
import com.masantello.booksreviewsystem.services.BookReviewService;

@RestController
@RequestMapping(value = "/reviews")
public class ReviewController {

	private final BookReviewService service;
	
	@Autowired
	public ReviewController(BookReviewService service) {
		this.service = service;
	}
	
	//INSERT
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<BookReviewDTO> insert(@RequestBody BookReviewDTO reviewDto) {
		BookReview bookReview = service.fromDto(reviewDto);
		bookReview = service.insert(bookReview);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(bookReview.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	//FINDALL
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<BookReviewDTO>> findAll() {
		List<BookReview> bookReviews = service.findAll();
		List<BookReviewDTO> bookReviewsDto = bookReviews.stream().map(review -> new BookReviewDTO(review))
				.collect(Collectors.toList());
		
		return ResponseEntity.ok().body(bookReviewsDto);
	}
	
	//UPDATE
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<BookReviewDTO> update(@RequestBody BookReviewDTO reviewDto, @PathVariable String id) {
		BookReview bookReview = service.fromDto(reviewDto);
		bookReview.setId(id);
		bookReview = service.update(bookReview);
		
		return ResponseEntity.ok().body(new BookReviewDTO(bookReview));
	}
	
}

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

import com.masantello.booksreviewsystem.domain.Review;
import com.masantello.booksreviewsystem.dto.BookDTO;
import com.masantello.booksreviewsystem.dto.ReviewDTO;
import com.masantello.booksreviewsystem.services.ReviewService;

@RestController
@RequestMapping(value = "/reviews")
public class ReviewController {

	private final ReviewService service;
	
	@Autowired
	public ReviewController(ReviewService service) {
		this.service = service;
	}
	
	//INSERT
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ReviewDTO> insert(@RequestBody ReviewDTO reviewDto) {
		Review bookReview = service.fromDto(reviewDto);
		bookReview = service.insert(bookReview);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(bookReview.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	//FINDALL
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ReviewDTO>> findAll() {
		List<Review> bookReviews = service.findAll();
		List<ReviewDTO> bookReviewsDto = bookReviews.stream().map(review -> new ReviewDTO(review))
				.collect(Collectors.toList());
		
		return ResponseEntity.ok().body(bookReviewsDto);
	}
	
	//UPDATE
	@RequestMapping(value = "/{count}", method = RequestMethod.PUT)
	public ResponseEntity<ReviewDTO> update(@RequestBody ReviewDTO reviewDto, @PathVariable Integer count) {
		Review bookReview = service.fromDto(reviewDto);
		bookReview.setCount(count);
		bookReview = service.update(bookReview);
		
		return ResponseEntity.ok().body(new ReviewDTO(bookReview));
	}
	
	//FindAllByBook
	@RequestMapping(value = "/allReviewsFromOneBook", method = RequestMethod.GET)
	public ResponseEntity<List<ReviewDTO>> findAllByBook(@RequestBody BookDTO bookDto) {
		List<Review> bookReview = service.findByBookTitle(bookDto.getTitle());

		List<ReviewDTO> responseDTO = bookReview.stream().map(review -> new ReviewDTO(review))
				.collect(Collectors.toList());
		
		return ResponseEntity.ok().body(responseDTO);
	}
	
}

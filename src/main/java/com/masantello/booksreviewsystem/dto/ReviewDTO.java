package com.masantello.booksreviewsystem.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.masantello.booksreviewsystem.domain.Review;

public class ReviewDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private Float rating;
	private String text;
	private LocalDateTime date;
	private BookSimplifiedDTO book;
	
	public ReviewDTO() {
		
	}
	
	public ReviewDTO(Review review) {
		this.id = review.getId();
		this.rating = review.getRating();
		this.text = review.getText();
		this.date = review.getDate();
		this.book = review.getBook();
	}

	public ReviewDTO(Float rating, String text, LocalDateTime date, BookSimplifiedDTO book) {
		this.rating = rating;
		this.text = text;
		this.date = date;
		this.book = book;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Float getRating() {
		return rating;
	}

	public void setRating(Float rating) {
		this.rating = rating;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public BookSimplifiedDTO getBook() {
		return book;
	}

	public void setBook(BookSimplifiedDTO book) {
		this.book = book;
	}
	
}
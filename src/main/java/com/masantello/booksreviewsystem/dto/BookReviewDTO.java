package com.masantello.booksreviewsystem.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.masantello.booksreviewsystem.domain.BookReview;

public class BookReviewDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private short numberOfStars;
	private String text;
	private LocalDateTime date;
	private BookSimplifiedDTO book;
	
	public BookReviewDTO() {
		
	}
	
	public BookReviewDTO(BookReview review) {
		this.id = review.getId();
		this.numberOfStars = review.getNumberOfStars();
		this.text = review.getText();
		this.date = review.getDate();
		this.book = review.getBook();
	}

	public BookReviewDTO(short numberOfStars, String text, LocalDateTime date, BookSimplifiedDTO book) {
		this.numberOfStars = numberOfStars;
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

	public short getNumberOfStars() {
		return numberOfStars;
	}

	public void setNumberOfStars(short numberOfStars) {
		this.numberOfStars = numberOfStars;
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
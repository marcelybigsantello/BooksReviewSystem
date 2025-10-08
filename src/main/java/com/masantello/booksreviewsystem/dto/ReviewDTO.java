package com.masantello.booksreviewsystem.dto;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;

import com.masantello.booksreviewsystem.domain.Review;

public class ReviewDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Float rating;
	private String text;
	private String date;
	private BookSimplifiedDTO book;
	private Integer count;
	
	
	public ReviewDTO() {
		
	}
	
	public ReviewDTO(Review review) {
		this.rating = review.getRating();
		this.text = review.getText();
		this.date = review.getDate() == null ? null : review.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss"));
		this.book = review.getBook();
		this.count = review.getCount();
	}

	public ReviewDTO(Float rating, String text, String date, BookSimplifiedDTO book) {
		this.rating = rating;
		this.text = text;
		this.date = date;
		this.book = book;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public BookSimplifiedDTO getBook() {
		return book;
	}

	public void setBook(BookSimplifiedDTO book) {
		this.book = book;
	}
	
	public Integer getCount() {
		return count;
	}
	
}
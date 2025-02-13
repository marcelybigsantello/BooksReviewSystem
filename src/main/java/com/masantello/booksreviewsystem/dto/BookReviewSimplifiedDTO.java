package com.masantello.booksreviewsystem.dto;

public class BookReviewSimplifiedDTO {

	private Float rating;
	private String text;
	
	public BookReviewSimplifiedDTO() {
		
	}	

	public BookReviewSimplifiedDTO(Float rating, String text) {
		this.rating = rating;
		this.text = text;
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
	
}

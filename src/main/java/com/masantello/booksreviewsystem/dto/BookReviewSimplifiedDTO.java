package com.masantello.booksreviewsystem.dto;

public class BookReviewSimplifiedDTO {

	private String id;
	private Float rating;
	private String text;
	
	public BookReviewSimplifiedDTO() {
		
	}

	public BookReviewSimplifiedDTO(String id, Float rating, String text) {
		this.id = id;
		this.rating = rating;
		this.text = text;
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
	
}

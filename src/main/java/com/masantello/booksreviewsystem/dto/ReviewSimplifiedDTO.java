package com.masantello.booksreviewsystem.dto;

public class ReviewSimplifiedDTO {

	private Float rating;
	private String text;
	
	public ReviewSimplifiedDTO() {
		
	}	

	public ReviewSimplifiedDTO(Float rating, String text) {
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

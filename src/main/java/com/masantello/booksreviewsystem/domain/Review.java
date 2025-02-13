package com.masantello.booksreviewsystem.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.masantello.booksreviewsystem.dto.BookSimplifiedDTO;

@Document(collection = "reviews")
public class Review implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private Float rating;
	private String text;
	private LocalDateTime date;
	
	private BookSimplifiedDTO book;
	
	public Review() {
		
	}
	
	public Review(Float rating, String text, LocalDateTime date, BookSimplifiedDTO book) {
		this.rating = rating;
		this.text = text;
		this.date = date;
		this.book = book;
	}
	
	public Review(String id, Float rating, String text, LocalDateTime date, BookSimplifiedDTO book) {
		this.id = id;
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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Review other = (Review) obj;
		return Objects.equals(id, other.id);
	}
}

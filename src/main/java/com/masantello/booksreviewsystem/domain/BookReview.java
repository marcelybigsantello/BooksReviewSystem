package com.masantello.booksreviewsystem.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.masantello.booksreviewsystem.dto.BookSimplifiedDTO;

@Document(collection = "reviews")
public class BookReview implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private short numberOfStars;
	private String text;
	private LocalDateTime date;
	
	private BookSimplifiedDTO book;
	
	public BookReview() {
		
	}

	public BookReview(short numberOfStars, String text, LocalDateTime date, BookSimplifiedDTO book) {
		this.numberOfStars = numberOfStars;
		this.text = text;
		this.date = date;
		this.book = book;
	}

	public BookReview(String id, short numberOfStars, String text, LocalDateTime date, 
			BookSimplifiedDTO book) {
		this.id = id;
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
		BookReview other = (BookReview) obj;
		return Objects.equals(id, other.id);
	}
}

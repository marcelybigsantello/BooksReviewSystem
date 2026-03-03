package com.masantello.booksreviewsystem.models;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.masantello.booksreviewsystem.dto.BookSimplifiedDTO;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "reviews")
public class Review implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private Float rating;
	private String text;
	private LocalDateTime date;
	private Integer count;
	
	private BookSimplifiedDTO book;
	
	public Review(Float rating, String text, LocalDateTime date, BookSimplifiedDTO book) {
		this.rating = rating;
		this.text = text;
		this.date = date;
		this.book = book;
	}
	
	public Review(Float rating, String text, String date, BookSimplifiedDTO book) {
		this.rating = rating;
		this.text = text;
		this.date = date == null ? null : LocalDateTime.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss"));
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
		Review other = (Review) obj;
		return Objects.equals(id, other.id);
	}
}

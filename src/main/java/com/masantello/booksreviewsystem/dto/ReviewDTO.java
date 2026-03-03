package com.masantello.booksreviewsystem.dto;

import java.io.Serial;
import java.io.Serializable;
import java.time.format.DateTimeFormatter;

import com.masantello.booksreviewsystem.models.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;
	
	private Float rating;
	private String text;
	private String date;
	private BookSimplifiedDTO book;
	private Integer count;
	
	public ReviewDTO(Review review) {
		this.rating = review.getRating();
		this.text = review.getText();
		this.date = review.getDate() == null ? null : review.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss"));
		this.book = review.getBook();
		this.count = review.getCount();
	}
	
}
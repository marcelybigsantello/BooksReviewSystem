package com.masantello.booksreviewsystem.dto;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.masantello.booksreviewsystem.models.Book;
import com.masantello.booksreviewsystem.models.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	private String id;
	private String title;
	private String description;
	private String editor;
	private short numberOfPages;
	private LocalDate releaseDate;
	private Float price;
	private int quantityInSupply;
	private AuthorSimplifiedDTO author;
	private List<ReviewSimplifiedDTO> reviews = new ArrayList<>();

	public BookDTO(Book book) {
		this.id = book.getId();
		this.title = book.getTitle();
		this.description = book.getDescription();
		this.editor = book.getEditor();
		this.numberOfPages = book.getNumberOfPages();
		this.releaseDate = book.getReleaseDate();
		this.price = book.getPrice();
		this.quantityInSupply = book.getQuantityInSupply();
		this.author = book.getAuthor();
		this.reviews = mapToReviewDTO(book.getReviews());
	}

	private List<ReviewSimplifiedDTO> mapToReviewDTO(List<Review> reviews) {
		return reviews.stream().map(review -> 
			new ReviewSimplifiedDTO(review.getRating(), review.getText())).toList();
	}

}

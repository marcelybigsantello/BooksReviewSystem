package com.masantello.booksreviewsystem.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.masantello.booksreviewsystem.domain.Book;
import com.masantello.booksreviewsystem.domain.Review;

public class BookDTO implements Serializable {
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

	public BookDTO() {

	}

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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public short getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(short numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public int getQuantityInSupply() {
		return quantityInSupply;
	}

	public void setQuantityInSupply(int quantityInSupply) {
		this.quantityInSupply = quantityInSupply;
	}

	public AuthorSimplifiedDTO getAuthor() {
		return author;
	}

	public List<ReviewSimplifiedDTO> getReviews() {
		return reviews;
	}

	private List<ReviewSimplifiedDTO> mapToReviewDTO(List<Review> reviews) {
		return reviews.stream().map(review -> 
			new ReviewSimplifiedDTO(review.getRating(), review.getText())).toList();
	}

}

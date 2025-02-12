package com.masantello.booksreviewsystem.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.masantello.booksreviewsystem.dto.AuthorSimplifiedDTO;
import com.masantello.booksreviewsystem.dto.BookReviewSimplifiedDTO;

@Document(collection = "book")
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String title;
	private String description;
	private String editor;
	private short numberOfPages;
	private LocalDate releaseDate;
	private Float price;
	private int quantityInSupply;
	private AuthorSimplifiedDTO authorDto;

	@DBRef
	private List<BookReviewSimplifiedDTO> reviews = new ArrayList<>();
	
	public Book(String id, String title, String description, String editor, short numberOfPages, LocalDate releaseDate,
			Float price, int quantityInSupply, AuthorSimplifiedDTO authorDto) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.editor = editor;
		this.numberOfPages = numberOfPages;
		this.releaseDate = releaseDate;
		this.price = price;
		this.quantityInSupply = quantityInSupply;
		this.authorDto = authorDto;
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

	public AuthorSimplifiedDTO getAuthorDto() {
		return authorDto;
	}
		
	public void setAuthorDto(AuthorSimplifiedDTO authorDto) {
		this.authorDto = authorDto;
	}
	
	public List<BookReviewSimplifiedDTO> getReviews() {
		return reviews;
	}
	
	public void addReview(BookReviewSimplifiedDTO reviewDto) {
		reviews.add(reviewDto);
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
		Book other = (Book) obj;
		return Objects.equals(id, other.id);
	}

}

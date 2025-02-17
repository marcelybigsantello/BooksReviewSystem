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
	private AuthorSimplifiedDTO author;

	@DBRef
	private List<Review> reviews = new ArrayList<>();
	
	public Book(String id, String title, String description, String editor, short numberOfPages, LocalDate releaseDate,
			Float price, int quantityInSupply, AuthorSimplifiedDTO author) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.editor = editor;
		this.numberOfPages = numberOfPages;
		this.releaseDate = releaseDate;
		this.price = price;
		this.quantityInSupply = quantityInSupply;
		this.author = author;
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
		
	public void setAuthor(AuthorSimplifiedDTO author) {
		this.author = author;
	}
	
	public List<Review> getReviews() {
		return reviews;
	}
	
	public void addReview(Review review) {
		this.reviews.add(review);
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

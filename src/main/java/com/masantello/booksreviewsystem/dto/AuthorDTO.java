package com.masantello.booksreviewsystem.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import com.masantello.booksreviewsystem.domain.Author;
import com.masantello.booksreviewsystem.domain.Book;
import com.masantello.booksreviewsystem.domain.enums.Genrer;

public class AuthorDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String email;
	private LocalDate birthDate;
	private Genrer genrer;
	private List<Book> books;
	
	public AuthorDTO() {
		
	}

	public AuthorDTO(Author author) {
		super();
		this.id = author.getId();
		this.name = author.getName();
		this.email = author.getEmail();
		this.birthDate = author.getBirthDate();
		this.genrer = author.getGenrer();
		this.books = author.getBooks();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public Genrer getGenrer() {
		return genrer;
	}

	public void setGenrer(Genrer genrer) {
		this.genrer = genrer;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
		
}
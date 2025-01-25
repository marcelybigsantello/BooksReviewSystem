package com.masantello.booksreviewsystem.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.masantello.booksreviewsystem.domain.enums.Genrer;

@Document(collection = "author")
public class Author implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String name;
	private String email;
	private LocalDate birthDate;
	private Genrer genrer;
	
	@DBRef
	private List<Book> books = new ArrayList<>();
	
	public Author() {
		
	}

	public Author(String id, String name, String email, LocalDate birthDate, Genrer genrer) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
		this.genrer = genrer;
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
	
	public void addBook(Book book) {
		this.books.add(book);
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
		Author other = (Author) obj;
		return Objects.equals(id, other.id);
	}
}

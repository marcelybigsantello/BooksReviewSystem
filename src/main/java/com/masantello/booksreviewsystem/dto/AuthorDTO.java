package com.masantello.booksreviewsystem.dto;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import com.masantello.booksreviewsystem.models.Author;
import com.masantello.booksreviewsystem.models.Book;
import com.masantello.booksreviewsystem.models.enums.LiteraryGenre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDTO implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String email;
	private LocalDate birthDate;
	private LiteraryGenre literaryGenre;
	private List<String> books;

	public AuthorDTO(Author author) {
		this.id = author.getId();
		this.name = author.getName();
		this.email = author.getEmail();
		this.birthDate = author.getBirthDate();
		this.literaryGenre = author.getLiteraryGenre();
		this.books = mapFromTitle(author.getBooks());
	}
	
	private List<String> mapFromTitle(List<Book> books) {

		return books.stream().map(book -> book.getTitle()).toList();
	}

}
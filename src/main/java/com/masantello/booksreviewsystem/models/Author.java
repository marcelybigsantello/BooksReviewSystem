package com.masantello.booksreviewsystem.models;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.masantello.booksreviewsystem.models.enums.LiteraryGenre;

@Document(collection = "author")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Author implements Serializable {
	@Serial
    private static final long serialVersionUID = 1L;
	
	@Id
	@NonNull
	private String id;
	@NonNull
	private String name;
	@NonNull
	private String email;
	@NonNull
	private LocalDate birthDate;
	@NonNull
	private LiteraryGenre literaryGenre;
	
	@DBRef
	private List<Book> books = new ArrayList<>();

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

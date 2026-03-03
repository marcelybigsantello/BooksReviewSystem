package com.masantello.booksreviewsystem.models;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jdk.jfr.SettingDefinition;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.masantello.booksreviewsystem.dto.AuthorSimplifiedDTO;

@Document(collection = "book")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Book implements Serializable {
	@Serial
    private static final long serialVersionUID = 1L;
	
	@Id
	@NonNull
	private String id;
	@NonNull
	private String title;
	@NonNull
	private String description;
	@NonNull
	private String editor;
	@NonNull
	private Short numberOfPages;
	@NonNull
	private LocalDate releaseDate;
	@NonNull
	private Float price;
	@NonNull
	private Integer quantityInSupply;
	@NonNull
	private AuthorSimplifiedDTO author;

	@DBRef
	private List<Review> reviews = new ArrayList<>();


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

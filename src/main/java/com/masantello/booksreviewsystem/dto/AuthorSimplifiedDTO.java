package com.masantello.booksreviewsystem.dto;

import java.io.Serial;
import java.io.Serializable;

import com.masantello.booksreviewsystem.models.enums.LiteraryGenre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AuthorSimplifiedDTO implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	private String name;
	private String literaryGenre;
}
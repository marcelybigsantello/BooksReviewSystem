package com.masantello.booksreviewsystem.dto;

import java.io.Serializable;

import com.masantello.booksreviewsystem.domain.enums.Genrer;

public class AuthorSimplifiedDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;
	private String genrer;
	
	public AuthorSimplifiedDTO() {

	}

	public AuthorSimplifiedDTO(String name, Genrer genrer) {
		super();
		this.name = name;
		this.genrer = genrer.getDescription();
	}

	public String getName() {
		return name;
	}

	public String getGenrer() {
		return genrer;
	}
}
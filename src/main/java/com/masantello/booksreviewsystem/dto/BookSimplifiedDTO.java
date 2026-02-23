package com.masantello.booksreviewsystem.dto;

import java.io.Serializable;

public class BookSimplifiedDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String title;
	private AuthorSimplifiedDTO authorDto;
	
	public BookSimplifiedDTO() {
		
	}
	
	public BookSimplifiedDTO(String title) {
		super();
		this.title = title;
	}

	public BookSimplifiedDTO(String title, AuthorSimplifiedDTO authorDto) {
		super();
		this.title = title;
		this.authorDto = authorDto;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public AuthorSimplifiedDTO getAuthorDto() {
		return authorDto;
	}

	public void setAuthorDto(AuthorSimplifiedDTO authorDto) {
		this.authorDto = authorDto;
	}
	
}

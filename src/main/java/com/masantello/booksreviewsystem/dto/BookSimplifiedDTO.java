package com.masantello.booksreviewsystem.dto;

import java.io.Serializable;

public class BookSimplifiedDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String title; 
	
	public BookSimplifiedDTO() {
		
	}
	
	public BookSimplifiedDTO(String title) {
		super();
		this.title = title;
	}

	public BookSimplifiedDTO(String id, String title) {
		super();
		this.id = id;
		this.title = title;
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
}

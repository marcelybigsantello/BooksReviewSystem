package com.masantello.booksreviewsystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masantello.booksreviewsystem.domain.Author;
import com.masantello.booksreviewsystem.repositories.AuthorRepository;

@Service
public class AuthorService {

	private final AuthorRepository authorRepository;
	
	@Autowired
	public AuthorService(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}
	
	public List<Author> findAll(){
		return authorRepository.findAll();
	}
}

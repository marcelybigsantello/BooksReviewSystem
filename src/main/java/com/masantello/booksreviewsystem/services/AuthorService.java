package com.masantello.booksreviewsystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masantello.booksreviewsystem.domain.Author;
import com.masantello.booksreviewsystem.dto.AuthorDTO;
import com.masantello.booksreviewsystem.repositories.AuthorRepository;
import com.masantello.booksreviewsystem.services.exception.ObjectNotFoundException;

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
	
	public Author findById(String id) {
		Optional<Author> author = authorRepository.findById(id);
		if (author.isEmpty()) {
			throw new ObjectNotFoundException("Autor não encontrado");
		}
		
		return author.get();
	}
	
	public Author insert(Author author) {
		return authorRepository.insert(author);
	}
	
	public Author fromDto(AuthorDTO authorDto) {
		return new Author(authorDto.getId(), authorDto.getName(), authorDto.getEmail(), 
				authorDto.getBirthDate(), authorDto.getGenrer());
	}
}

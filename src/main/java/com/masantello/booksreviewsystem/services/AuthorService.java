package com.masantello.booksreviewsystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masantello.booksreviewsystem.domain.Author;
import com.masantello.booksreviewsystem.dto.AuthorDTO;
import com.masantello.booksreviewsystem.repositories.AuthorRepository;
import com.masantello.booksreviewsystem.services.exception.DataIntegrityViolationsException;
import com.masantello.booksreviewsystem.services.exception.ObjectNotFoundException;
import com.masantello.booksreviewsystem.utils.Constants;

@Service
public class AuthorService {

	private final AuthorRepository authorRepository;

	@Autowired
	public AuthorService(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}

	public Author insert(Author author) {
		return authorRepository.insert(author);
	}

	public List<Author> findAll() {
		return authorRepository.findAll();
	}

	public Author findById(String id) {
		Optional<Author> author = authorRepository.findById(id);
		if (author.isEmpty()) {
			throw new ObjectNotFoundException(Constants.AUTHOR_NOT_FOUND_ERROR);
		}

		return author.get();
	}
	
	public Optional<Author> findByName(String name) {
		var author = authorRepository.findByName(name);
		if (author.isEmpty()) {
			throw new ObjectNotFoundException(Constants.AUTHOR_NOT_FOUND_ERROR);
		}
		
		return author;
	}
	
	public Optional<Author> findByNameAndGenrer(String name, String genrer) {
		var author = authorRepository.findByNameAndGenrer(name, genrer);
		if (author.isEmpty()) {
			throw new ObjectNotFoundException(Constants.AUTHOR_NOT_FOUND_ERROR);
		}
		
		return author;
	}
	

	public Author update(Author author) {
		Author newDataAuthor = findById(author.getId());
		newDataAuthor.setName(author.getName());
		newDataAuthor.setEmail(author.getEmail());
		newDataAuthor.setBirthDate(author.getBirthDate());
		newDataAuthor.setGenrer(author.getGenrer());
		authorRepository.save(newDataAuthor);
		
		return newDataAuthor;
	}
	
	public void addNewBookOfAuthor(Author author) {
		authorRepository.save(author);	
	}
	
	public void delete(String id) {
		Author author = findById(id);
		if (author.getBooks() != null && !author.getBooks().isEmpty()) {
			throw new DataIntegrityViolationsException(Constants.AUTHOR_DOES_NOT_HAVE_BOOKS);
		}

		authorRepository.delete(author);
	}

	public Author fromDto(AuthorDTO authorDto) {
		return new Author(authorDto.getId(), authorDto.getName(), authorDto.getEmail(), 
				authorDto.getBirthDate(), authorDto.getGenrer());
	}

	

}

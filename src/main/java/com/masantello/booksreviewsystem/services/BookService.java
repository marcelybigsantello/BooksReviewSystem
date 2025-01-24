package com.masantello.booksreviewsystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masantello.booksreviewsystem.domain.Book;
import com.masantello.booksreviewsystem.dto.BookDTO;
import com.masantello.booksreviewsystem.repositories.AuthorRepository;
import com.masantello.booksreviewsystem.repositories.BookRepository;
import com.masantello.booksreviewsystem.services.exception.DataIntegrityViolationsException;
import com.masantello.booksreviewsystem.services.exception.ObjectNotFoundException;

@Service
public class BookService {

	private final BookRepository bookRepository;
	private final AuthorRepository authorRepository;

	@Autowired
	public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
		this.bookRepository = bookRepository;
		this.authorRepository = authorRepository;
	}

	public Book insert(Book book) {
		/*Optional<Author> author = authorRepository.findById(book.getAuthor().getId());
		if (author.isEmpty()) {
			throw new DataIntegrityViolationsException("Não foi possível inserir o livro. Favor cadastrar o autor.");
		}*/
		return bookRepository.insert(book);
	}

	public List<Book> findAll() {
		return bookRepository.findAll();
	}

	public Book findById(String id) {
		Optional<Book> book = bookRepository.findById(id);
		if (book.isEmpty()) {
			throw new ObjectNotFoundException("Livro não encontrado");
		}

		return book.get();
	}

	public Book update(Book book) {
		Book newDataBook = findById(book.getId());
		newDataBook.setTitle(book.getTitle());
		newDataBook.setDescription(book.getDescription());
		newDataBook.setEditor(book.getEditor());
		newDataBook.setNumberOfPages(book.getNumberOfPages());
		newDataBook.setReleaseDate(book.getReleaseDate());
		newDataBook.setPrice(book.getPrice());
		newDataBook.setQuantityInSupply(book.getQuantityInSupply());
		newDataBook.setAuthor(book.getAuthor());
		bookRepository.save(newDataBook);
		return newDataBook;
	}
	
	public void delete(String id) {
		Book book = findById(id);
		if (book.getQuantityInSupply() > 0) {
			throw new DataIntegrityViolationsException("Não é possível excluir o livro, "
					+ "pois possui exemplares em estoque.");
		}
		bookRepository.delete(book);
	}

	public Book fromDto(BookDTO bookDto) {
		return new Book(bookDto.getId(), bookDto.getTitle(), bookDto.getDescription(), bookDto.getEditor(),
				bookDto.getNumberOfPages(), bookDto.getReleaseDate(), bookDto.getPrice(), 
				bookDto.getQuantityInSupply(), bookDto.getAuthor());
	}

}

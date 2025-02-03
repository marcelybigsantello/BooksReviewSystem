package com.masantello.booksreviewsystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masantello.booksreviewsystem.domain.Author;
import com.masantello.booksreviewsystem.domain.Book;
import com.masantello.booksreviewsystem.dto.BookDTO;
import com.masantello.booksreviewsystem.repositories.BookRepository;
import com.masantello.booksreviewsystem.services.exception.DataIntegrityViolationsException;
import com.masantello.booksreviewsystem.services.exception.ObjectNotFoundException;

@Service
public class BookService {

	private final BookRepository bookRepository;
	private final AuthorService authorService;

	@Autowired
	public BookService(BookRepository bookRepository, AuthorService authorService) {
		this.bookRepository = bookRepository;
		this.authorService = authorService;
	}

	public Book insert(Book book) {
		var result = bookRepository.insert(book);

		Optional<Author> author = authorService.findByNameAndGenrer(book.getAuthorDto().getName(),
				book.getAuthorDto().getGenrer());
		if (author.isEmpty()) {
			throw new DataIntegrityViolationsException("Não foi possível inserir o livro. Favor cadastrar o autor.");
		}

		author.get().addBook(book);
		authorService.addNewBookOfAuthor(author.get());

		return result;
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

	public Book update(Book newDataBook) {
		Book book = findById(newDataBook.getId());
		book.setTitle(newDataBook.getTitle());
		book.setDescription(newDataBook.getDescription());
		book.setEditor(newDataBook.getEditor());
		book.setNumberOfPages(newDataBook.getNumberOfPages());
		book.setReleaseDate(newDataBook.getReleaseDate());
		book.setPrice(newDataBook.getPrice());
		book.setQuantityInSupply(newDataBook.getQuantityInSupply());
		bookRepository.save(newDataBook);

		// Atualizando lista de livros do autor
		Optional<Author> author = authorService.findByNameAndGenrer(book.getAuthorDto().getName(),
				book.getAuthorDto().getGenrer());
		author.get().addBook(book);
		authorService.update(author.get());
		return newDataBook;
	}

	public void delete(String id) {
		Book book = findById(id);
		if (book.getQuantityInSupply() > 0) {
			throw new DataIntegrityViolationsException(
					"Não é possível excluir o livro, " + "pois possui exemplares em estoque.");
		}
		bookRepository.delete(book);
	}

	public Book fromDto(BookDTO bookDto) {
		return new Book(bookDto.getId(), bookDto.getTitle(), bookDto.getDescription(), 
				bookDto.getEditor(), bookDto.getNumberOfPages(), bookDto.getReleaseDate(),
				bookDto.getPrice(), bookDto.getQuantityInSupply(),
				bookDto.getAuthorDto());
	}

}

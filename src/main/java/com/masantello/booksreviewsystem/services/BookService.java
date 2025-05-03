package com.masantello.booksreviewsystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masantello.booksreviewsystem.domain.Author;
import com.masantello.booksreviewsystem.domain.Book;
import com.masantello.booksreviewsystem.dto.BookDTO;
import com.masantello.booksreviewsystem.repositories.BookRepository;
import com.masantello.booksreviewsystem.services.exception.BadRequestException;
import com.masantello.booksreviewsystem.services.exception.DataIntegrityViolationsException;
import com.masantello.booksreviewsystem.services.exception.ObjectNotFoundException;
import com.masantello.booksreviewsystem.utils.Constants;

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

		Optional<Author> author = authorService.findByNameAndGenrer(book.getAuthor().getName(),
				book.getAuthor().getGenrer());
		if (author.isEmpty()) {
			throw new DataIntegrityViolationsException(Constants.BOOK_AUTHOR_NOT_REGISTERED);
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
			throw new ObjectNotFoundException(Constants.BOOK_NOT_FOUND_ERROR);
		}

		return book.get();
	}

	public List<Book> findAllByAnAuthor(String authorName) {
		Optional<Author> author = authorService.findByName(authorName);
		if (author.isPresent()) {			
			Optional<List<Book>> booksByAnAuthor = bookRepository.findBooksByAnAuthor(authorName);
			return booksByAnAuthor.get();
		}
		return null;
	}

	public Book findByTitle(String title) {
		if (title == null) {
			throw new BadRequestException("Título nulo.");
		}
		Optional<Book> book = bookRepository.findByTitle(title);
		if (book.isEmpty()) {
			throw new ObjectNotFoundException(Constants.BOOK_NOT_FOUND_ERROR);
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
		Optional<Author> author = authorService.findByNameAndGenrer(book.getAuthor().getName(),
				book.getAuthor().getGenrer());
		if (author.isPresent()) {
			author.get().addBook(book);
			authorService.addNewBookOfAuthor(author.get());
		}
		return newDataBook;
	}

	public void delete(String id) {
		Book book = findById(id);
		if (book.getQuantityInSupply() > 0) {
			throw new DataIntegrityViolationsException(Constants.NOT_POSSIBLE_TO_DELETE_BOOK);
		}
		bookRepository.delete(book);
	}

	public Book fromDto(BookDTO bookDto) {

		return new Book(bookDto.getId(), bookDto.getTitle(), bookDto.getDescription(), bookDto.getEditor(),
				bookDto.getNumberOfPages(), bookDto.getReleaseDate(), bookDto.getPrice(), bookDto.getQuantityInSupply(),
				bookDto.getAuthor());
	}

	public void addOrUpdateReviewOfBook(Book book) {
		bookRepository.save(book);
	}

}
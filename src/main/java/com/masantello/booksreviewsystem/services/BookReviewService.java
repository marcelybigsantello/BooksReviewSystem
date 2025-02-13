package com.masantello.booksreviewsystem.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masantello.booksreviewsystem.domain.Book;
import com.masantello.booksreviewsystem.domain.BookReview;
import com.masantello.booksreviewsystem.dto.BookReviewDTO;
import com.masantello.booksreviewsystem.repositories.BookReviewRepository;
import com.masantello.booksreviewsystem.services.exception.BadRequestException;
import com.masantello.booksreviewsystem.services.exception.DataIntegrityViolationsException;
import com.masantello.booksreviewsystem.services.exception.ObjectNotFoundException;

@Service
public class BookReviewService {

	private final BookReviewRepository reviewsRepository;
	private final BookService bookService;
	
	@Autowired
	public BookReviewService(BookReviewRepository reviewsRepository, BookService bookService) {
		this.reviewsRepository = reviewsRepository;
		this.bookService = bookService;
	}
	
	public List<BookReview> findAll() {
		return reviewsRepository.findAll();
	}
	
	public BookReview insert(BookReview review) {
		Book book = bookService.findByTitle(review.getBook().getTitle());
		if (book == null) {
			throw new DataIntegrityViolationsException("Não foi possível inserir a avaliação. Favor cadastrar o livro!");
		}
		review.getBook().setId(book.getId());
		review.setDate(LocalDateTime.now());
		 
		var result = reviewsRepository.insert(review);
		book.addReview(review);
		bookService.addNewReviewOfBook(book);
		
		return result;
	}

	
	public BookReview update(BookReview newReview) {
		if (newReview.getRating() == null && newReview.getText() == null) {
			throw new BadRequestException("Número de estrelas e feedback nulos.");
		}
		BookReview review = findById(newReview.getId());
		review.setRating(newReview.getRating());
		review.setText(newReview.getText());
		review.setDate(LocalDateTime.now());
		reviewsRepository.save(review);
		
		return review;
	}

	private BookReview findById(String id) {
		Optional<BookReview> review = reviewsRepository.findById(id);
		if (review.isEmpty()) {
			throw new ObjectNotFoundException("Avaliação inexistente");
		}
		
		return review.get();
	}
	
	public BookReview fromDto(BookReviewDTO reviewDto) {
		return new BookReview(reviewDto.getRating(), 
				reviewDto.getText(), reviewDto.getDate(), reviewDto.getBook());
	}

}

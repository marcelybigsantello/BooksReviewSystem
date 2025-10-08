package com.masantello.booksreviewsystem.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masantello.booksreviewsystem.domain.Book;
import com.masantello.booksreviewsystem.domain.Review;
import com.masantello.booksreviewsystem.dto.ReviewDTO;
import com.masantello.booksreviewsystem.repositories.ReviewRepository;
import com.masantello.booksreviewsystem.services.exception.BadRequestException;
import com.masantello.booksreviewsystem.services.exception.DataIntegrityViolationsException;
import com.masantello.booksreviewsystem.services.exception.ObjectNotFoundException;
import com.masantello.booksreviewsystem.utils.Constants;

@Service
public class ReviewService {

	private final ReviewRepository reviewsRepository;
	private final BookService bookService;

	@Autowired
	public ReviewService(ReviewRepository reviewsRepository, BookService bookService) {
		this.reviewsRepository = reviewsRepository;
		this.bookService = bookService;
	}

	public List<Review> findAll() {
		return reviewsRepository.findAll();
	}

	public List<Review> findByBookTitle(String bookTitle) {

		Optional.ofNullable(bookService.findByTitle(bookTitle))
			.orElseThrow(
				() -> new ObjectNotFoundException(String.format(Constants.BOOK_NOT_FOUND_ERROR, bookTitle)));
				

		return reviewsRepository.findByBookTitleIgnoreCase(bookTitle)
				.filter(reviews -> !reviews.isEmpty())
				.orElseThrow(
				() -> new NoSuchElementException(String.format(Constants.NO_REVIEW_FOR_THAT_BOOK, bookTitle)));

	}

	public Review insert(Review review) {
		Book book = bookService.findByTitle(review.getBook().getTitle());
		if (book == null) {
			throw new DataIntegrityViolationsException(Constants.REVIEW_BOOK_NOT_REGISTERED);
		}
		
		review.setDate(LocalDateTime.now());
		review.setCount(Math.toIntExact(reviewsRepository.count()) + 1);
		review.getBook().setAuthorDto(book.getAuthor());

		var result = reviewsRepository.insert(review);
		book.addReview(review);
		bookService.addOrUpdateReviewOfBook(book);

		return result;
	}

	public Review update(Review newReview) {
		if (newReview.getRating() == null && newReview.getText() == null) {
			throw new BadRequestException(Constants.NULL_RATING_AND_FEEDBACK);
		}
		Review review = findByCountNumber(newReview.getCount());
		review.setRating(newReview.getRating());
		review.setText(newReview.getText());
		review.setDate(LocalDateTime.now());
		reviewsRepository.save(review);
		Book book = bookService.findByTitle(review.getBook().getTitle());
		book.addReview(review);
		bookService.addOrUpdateReviewOfBook(book);

		return review;
	}

	private Review findByCountNumber(Integer count) {
		Optional<Review> review = reviewsRepository.findByCount(count);
		if (review.isEmpty()) {
			throw new ObjectNotFoundException(Constants.UNKNOWN_REVIEW);
		}

		return review.get();
	}

	public Review fromDto(ReviewDTO reviewDto) {
		return new Review(reviewDto.getRating(), reviewDto.getText(), reviewDto.getDate(), reviewDto.getBook());
	}

}

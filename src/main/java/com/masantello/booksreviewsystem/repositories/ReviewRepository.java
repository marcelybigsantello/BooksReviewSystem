package com.masantello.booksreviewsystem.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.masantello.booksreviewsystem.domain.Review;

@Repository
public interface ReviewRepository extends MongoRepository<Review, String> {

	Optional<List<Review>> findByBookTitleIgnoreCase(String bookTitle);
	
	Optional<Review> findByCount(Integer count);

}

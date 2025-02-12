package com.masantello.booksreviewsystem.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.masantello.booksreviewsystem.domain.BookReview;

@Repository
public interface BookReviewRepository extends MongoRepository<BookReview, String> {

}

package com.masantello.booksreviewsystem.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.masantello.booksreviewsystem.models.Review;

@Repository
public interface ReviewRepository extends MongoRepository<Review, String> {

}

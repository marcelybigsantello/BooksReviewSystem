package com.masantello.booksreviewsystem.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.masantello.booksreviewsystem.domain.Author;

@Repository
public interface AuthorRepository extends MongoRepository<Author, String> {

}

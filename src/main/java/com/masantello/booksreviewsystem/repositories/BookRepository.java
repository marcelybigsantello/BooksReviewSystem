package com.masantello.booksreviewsystem.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.masantello.booksreviewsystem.domain.Book;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {

}

package com.masantello.booksreviewsystem.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.masantello.booksreviewsystem.domain.Book;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {

	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	Optional<Book> findByTitle(String title);
	
	@Query(" { 'author.name': { $regex: ?0 } }")
	Optional<List<Book>> findBooksByAnAuthor(String author);
	
}

package com.masantello.booksreviewsystem.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.masantello.booksreviewsystem.domain.Author;

@Repository
public interface AuthorRepository extends MongoRepository<Author, String> {
	
	@Query("{ 'name': { $regex: ?0, $options: 'i' } }, { 'genrer': { $regex: ?0, $options: 'i' } }")
	public Optional<Author> findByNameAndGenrer(@Param("name") String name, @Param("genrer") String genrer);

	public Optional<Author> findByName(@Param("name") String name);

	
}

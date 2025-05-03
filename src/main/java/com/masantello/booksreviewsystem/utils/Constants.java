package com.masantello.booksreviewsystem.utils;

public class Constants {
	
	private Constants() {
		
	}
	
	// Author
	public static final String AUTHOR_NOT_FOUND_ERROR = "Autor não encontrado";
	public static final String AUTHOR_DOES_NOT_HAVE_BOOKS = "O autor possui livros cadastrados. Não é possível excluí-lo";
	
	// Book
	public static final String BOOK_NOT_FOUND_ERROR = "Livro não encontrado";
	public static final String BOOK_AUTHOR_NOT_REGISTERED = "Não foi possível inserir o livro. Favor cadastrar o autor.";
	public static final String NOT_POSSIBLE_TO_DELETE_BOOK = "Não é possível excluir o livro, pois possui exemplares em estoque.";
	
	// Review
	public static final String REVIEW_BOOK_NOT_REGISTERED = "Não foi possível inserir a avaliação. Favor cadastrar o livro!";
	public static final String NULL_RATING_AND_FEEDBACK = "Número de estrelas e feedback nulos.";
	public static final String UNKNOWN_REVIEW = "Avaliação inexistente";
	
}

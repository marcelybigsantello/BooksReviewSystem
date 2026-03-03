package com.masantello.booksreviewsystem.mapper;

import com.masantello.booksreviewsystem.dto.BookDTO;
import com.masantello.booksreviewsystem.models.Book;

public class BookMapper {

    public Book convertToModel(BookDTO bookDto) {
        Book book = new Book();
        book.setId(bookDto.getId());
        book.setTitle(bookDto.getTitle());
        book.setDescription(bookDto.getDescription());
        book.setEditor(bookDto.getEditor());
        book.setNumberOfPages(bookDto.getNumberOfPages());
        book.setReleaseDate(bookDto.getReleaseDate());
        book.setPrice(bookDto.getPrice());
        book.setQuantityInSupply(bookDto.getQuantityInSupply());
        book.setAuthor(bookDto.getAuthor());

        return book;
    }
}

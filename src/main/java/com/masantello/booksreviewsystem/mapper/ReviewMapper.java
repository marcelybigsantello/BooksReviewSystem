package com.masantello.booksreviewsystem.mapper;

import com.masantello.booksreviewsystem.dto.ReviewDTO;
import com.masantello.booksreviewsystem.models.Review;

import java.time.LocalDateTime;

public class ReviewMapper {

    public Review convertToModel(ReviewDTO reviewDto) {
        Review review = new Review();
        review.setRating(reviewDto.getRating());
        review.setText(reviewDto.getText());
        review.setDate(LocalDateTime.parse(reviewDto.getDate()));
        review.setCount(reviewDto.getCount());
        review.setBook(reviewDto.getBook());

        return review;
    }
}

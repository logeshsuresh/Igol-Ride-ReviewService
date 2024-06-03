package com.example.IgolReviewService.services;

import com.example.IgolReviewService.models.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {

    public Optional<Review> findReviewById(Long id);

    public List<Review> findAllReviews();

    public Review publishReview(Review review);

    public boolean deleteReviewById(Long id);

    public Review updateReview(Long id, Review review);

}

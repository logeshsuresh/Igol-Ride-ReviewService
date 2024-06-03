package com.example.IgolReviewService.services;

import com.example.IgolReviewService.models.Review;
import com.example.IgolReviewService.repositories.ReviewRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.hibernate.FetchNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements  ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Optional<Review> findReviewById(Long id) throws EntityNotFoundException {
        Optional<Review> review;
        try {
            review = this.reviewRepository.findById(id);
            if (review.isEmpty()) {
                throw new EntityNotFoundException("Review with id" + id + "not found");
            }
            return review;
        } catch (Exception e) {
            e.printStackTrace();
            if (e.getClass() == EntityNotFoundException.class) {
                throw new FetchNotFoundException("Review with id" + id + "not found", id);
            }
            throw new FetchNotFoundException("Unable to fetch, please try again later!", id);
        }
    }

    @Override
    public List<Review> findAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    @Transactional
    public Review publishReview(Review review) { return reviewRepository.save(review); }

    @Override
    public boolean deleteReviewById(Long id) {
        try {
            Review review = this.reviewRepository.findById(id).orElseThrow(EntityNotFoundException::new);
            this.reviewRepository.delete(review);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Review updateReview(Long id, Review newReviewData) {
        Review review = this.reviewRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        if (newReviewData.getRating() != null) {
            review.setRating(newReviewData.getRating());
        }
        if (newReviewData.getContent() != null) {
            review.setContent(newReviewData.getContent());
        }
        return this.reviewRepository.save(review);
    }

}

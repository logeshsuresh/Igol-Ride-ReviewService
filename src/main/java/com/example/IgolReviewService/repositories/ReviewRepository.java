package com.example.IgolReviewService.repositories;

import com.example.IgolReviewService.models.Review;
import com.example.IgolReviewService.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    Integer countAllByRatingLessThanEqual(Integer givenRating);

    List<Review> findAllByRatingLessThanEqual(Integer givenRating);

    List<Review> findAllByCreatedAtBefore(Date date);

    @Query("SELECT r FROM Booking b INNER JOIN Review r WHERE b.id = :bookingId")
    Review findReviewByBookingId(Long bookingId);

}

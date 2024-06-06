package com.example.IgolReviewService;

import com.example.IgolReviewService.adaptors.CreateReviewDtoToReviewAdaptor;
import com.example.IgolReviewService.controllers.ReviewController;
import com.example.IgolReviewService.dtos.CreateReviewDto;
import com.example.IgolReviewService.dtos.ReviewDto;
import com.example.IgolReviewService.models.Booking;
import com.example.IgolReviewService.models.Review;
import com.example.IgolReviewService.services.ReviewService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ReviewControllerTest {

    @InjectMocks
    private ReviewController reviewController;

    @Mock
    private ReviewService reviewService;

    @Mock
    private CreateReviewDtoToReviewAdaptor createReviewDtoToReviewAdaptor;

    @BeforeEach
    public void setup() { MockitoAnnotations.initMocks(this); }

    @Test
    public void testGetReviewByID_Success() {
        Long reviewId = 1L;
        Review mockReview = Review.builder().build();
        mockReview.setId(reviewId);
        // mocking
        when(reviewService.findReviewById(reviewId)).thenReturn(Optional.of(mockReview));
        // perform the test
        ResponseEntity<?> response = reviewController.getReviewById(reviewId);
        // assertions
        assertEquals(HttpStatus.OK, response.getStatusCode());
        Optional<Review> returnedReview = (Optional<Review>) response.getBody();
        assertEquals(reviewId, returnedReview.get().getId());
    }

    @Test
    public void testPublishReview_Success() {
        CreateReviewDto requestDto = new CreateReviewDto();
        Booking booking = new Booking();
        booking.setId(1L);
        requestDto.setBookingId(booking.getId());
        requestDto.setRating(4.5);
        requestDto.setContent("Test review content");
        Review mockReview = Review
                            .builder()
                            .content("Test review content")
                            .rating(4.5)
                            .booking(booking)
                            .build();
        // mocking
        when(createReviewDtoToReviewAdaptor.reviewConvertDto(requestDto)).thenReturn(mockReview);
        Review savedReview = Review
                            .builder()
                            .content(mockReview.getContent())
                            .rating(mockReview.getRating())
                            .booking(mockReview.getBooking())
                            .build();
        when(reviewService.publishReview(mockReview)).thenReturn(savedReview);
        // perform the test
        ResponseEntity<?> response = reviewController.publishReview(requestDto);
        // assertions
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        ReviewDto reviewDto = (ReviewDto) response.getBody();
        assertEquals(mockReview.getContent(), reviewDto.getContent());
        assertEquals(mockReview.getRating(), reviewDto.getRating());
    }

}

package com.example.IgolReviewService.adaptors;

import com.example.IgolReviewService.dtos.CreateReviewDto;
import com.example.IgolReviewService.models.Booking;
import com.example.IgolReviewService.models.Review;
import com.example.IgolReviewService.repositories.BookingRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CreateReviewDtoToReviewAdaptorImpl implements  CreateReviewDtoToReviewAdaptor {

    private final BookingRepository bookingRepository;

    public CreateReviewDtoToReviewAdaptorImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public Review reviewConvertDto(CreateReviewDto createReviewDto) {
        Optional<Booking> booking = bookingRepository.findById(createReviewDto.getBookingId());
        return booking.map(
                value -> Review.builder()
                                .rating(createReviewDto.getRating())
                                .booking(value)
                                .content(createReviewDto.getContent())
                                .build()
                ).orElse(null);
    }

}

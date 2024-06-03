package com.example.IgolReviewService.adaptors;

import com.example.IgolReviewService.dtos.CreateReviewDto;
import com.example.IgolReviewService.models.Review;

public interface CreateReviewDtoToReviewAdaptor {

    public Review reviewConvertDto(CreateReviewDto createReviewDto);

}

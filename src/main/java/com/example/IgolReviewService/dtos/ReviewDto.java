package com.example.IgolReviewService.dtos;

import com.example.IgolReviewService.models.Booking;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDto {

    private Long id;

    private String content;

    private Double rating;

    private Long booking;

    private Date createdAt;

    private Date updatedAt;

}

package com.github.satwiksanand.uber_review_service.dtos;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class BookingReviewDto {
    private String content;
    private Double rating;
    private Long bookingId;
}

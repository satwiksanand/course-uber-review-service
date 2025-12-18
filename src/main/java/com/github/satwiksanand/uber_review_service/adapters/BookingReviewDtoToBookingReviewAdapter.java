package com.github.satwiksanand.uber_review_service.adapters;

import com.github.satwiksanand.uber_review_service.dtos.BookingReviewDto;
import com.github.satwiksanand.uber_review_service.models.BookingReview;

public class BookingReviewDtoToBookingReviewAdapter {
    public static BookingReviewDto toDto(BookingReview bookingReview){
        return BookingReviewDto.builder()
                .content(bookingReview.getContent())
                .rating(bookingReview.getRating())
                .bookingId(bookingReview.getBooking().getId()).build();
    }
}

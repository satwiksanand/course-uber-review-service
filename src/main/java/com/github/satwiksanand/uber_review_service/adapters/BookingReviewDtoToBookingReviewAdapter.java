package com.github.satwiksanand.uber_review_service.adapters;

import com.github.satwiksanand.uber_review_service.dtos.BookingReviewDto;
import com.github.satwiksanand.uber_review_service.models.Booking;
import com.github.satwiksanand.uber_review_service.models.BookingReview;
import com.github.satwiksanand.uber_review_service.repository.BookingRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BookingReviewDtoToBookingReviewAdapter {
    private static BookingRepository bookingRepository = null;

    public BookingReviewDtoToBookingReviewAdapter(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }


    public static BookingReviewDto toDto(BookingReview bookingReview){
        return BookingReviewDto.builder()
                .content(bookingReview.getContent())
                .rating(bookingReview.getRating())
                .bookingId(bookingReview.getBooking().getId()).build();
    }

    public static BookingReview toEntity(BookingReviewDto bookingReviewDto){
        Optional<Booking> booking = bookingRepository.findById(bookingReviewDto.getBookingId());
        return booking.map(value -> BookingReview.builder()
                .rating(bookingReviewDto.getRating())
                .content(bookingReviewDto.getContent())
                .booking(value)
                .build()).orElse(null);
    }
}

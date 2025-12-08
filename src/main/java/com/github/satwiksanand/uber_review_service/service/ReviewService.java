package com.github.satwiksanand.uber_review_service.service;

import com.github.satwiksanand.uber_review_service.models.Booking;
import com.github.satwiksanand.uber_review_service.models.BookingReview;
import com.github.satwiksanand.uber_review_service.models.BookingStatus;
import com.github.satwiksanand.uber_review_service.repository.BookingRepository;
import com.github.satwiksanand.uber_review_service.repository.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReviewService implements CommandLineRunner {

    private final ReviewRepository reviewRepository;
    private final BookingRepository bookingRepository;

    public ReviewService(ReviewRepository reviewRepository, BookingRepository bookingRepository) {
        this.reviewRepository = reviewRepository;
        this.bookingRepository = bookingRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("hihahahhaha");

        BookingReview bookingReview = BookingReview.builder().rating(4.0).content("this is the third review").build();
        Booking booking = Booking.builder()
                .startTime(LocalDateTime.now())
                .endTime(LocalDateTime.now())
                .totalDistance(10L)
                .bookingReview(bookingReview)
                .bookingStatus(BookingStatus.ARRIVED)
                .build();
        bookingRepository.save(booking);
        List<BookingReview> allBookingReview = reviewRepository.findAll();
        for(BookingReview curr : allBookingReview){
            System.out.println(curr.toString());
        }
    }
}

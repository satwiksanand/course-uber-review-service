package com.github.satwiksanand.uber_review_service.service;

import com.github.satwiksanand.uber_review_service.models.BookingReview;
import com.github.satwiksanand.uber_review_service.repository.BookingRepository;
import com.github.satwiksanand.uber_review_service.repository.DriverRepository;
import com.github.satwiksanand.uber_review_service.repository.ReviewRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ReviewService implements CommandLineRunner {

    private final ReviewRepository reviewRepository;
    private final BookingRepository bookingRepository;
    private final DriverRepository driverRepository;

    public ReviewService(ReviewRepository reviewRepository, BookingRepository bookingRepository,
                         DriverRepository driverRepository) {
        this.reviewRepository = reviewRepository;
        this.bookingRepository = bookingRepository;
        this.driverRepository = driverRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("running baby");
    }
}

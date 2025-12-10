package com.github.satwiksanand.uber_review_service.service;

import com.fasterxml.jackson.core.JsonToken;
import com.github.satwiksanand.uber_review_service.models.Booking;
import com.github.satwiksanand.uber_review_service.models.BookingReview;
import com.github.satwiksanand.uber_review_service.models.BookingStatus;
import com.github.satwiksanand.uber_review_service.models.Driver;
import com.github.satwiksanand.uber_review_service.repository.BookingRepository;
import com.github.satwiksanand.uber_review_service.repository.DriverRepository;
import com.github.satwiksanand.uber_review_service.repository.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
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
        List<Driver> drivers = driverRepository.hqlFindByName("raju");
        for(Driver driver : drivers){
            System.out.println(driver);
        }
    }
}

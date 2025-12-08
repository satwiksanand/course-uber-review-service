package com.github.satwiksanand.uber_review_service.service;

import com.github.satwiksanand.uber_review_service.models.Booking;
import com.github.satwiksanand.uber_review_service.models.BookingReview;
import com.github.satwiksanand.uber_review_service.models.BookingStatus;
import com.github.satwiksanand.uber_review_service.models.Driver;
import com.github.satwiksanand.uber_review_service.repository.BookingRepository;
import com.github.satwiksanand.uber_review_service.repository.DriverRepository;
import com.github.satwiksanand.uber_review_service.repository.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

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
//
//        BookingReview bookingReview = BookingReview.builder().rating(4.0).content("this is the third review").build();
//        Booking booking = Booking.builder()
//                .startTime(LocalDateTime.now())
//                .endTime(LocalDateTime.now())
//                .totalDistance(10L)
//                .bookingReview(bookingReview)
//                .bookingStatus(BookingStatus.ARRIVED)
//                .build();
//        bookingRepository.save(booking);
//        List<BookingReview> allBookingReview = reviewRepository.findAll();
//        for(BookingReview curr : allBookingReview){
//            System.out.println(curr.toString());
//        }
        Optional<Driver> driver = driverRepository.rawFindByIdAndLicenseNumber(1L, "BH12345");
        if(driver.isPresent()){
            System.out.println(driver.get().getName());
        }
        else{
            System.out.println("could not find the entity");
        }
    }
}

package com.github.satwiksanand.uber_review_service.service;

import com.github.satwiksanand.uber_review_service.models.Booking;
import com.github.satwiksanand.uber_review_service.models.Driver;
import com.github.satwiksanand.uber_review_service.repository.BookingRepository;
import com.github.satwiksanand.uber_review_service.repository.DriverRepository;
import com.github.satwiksanand.uber_review_service.repository.ReviewRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
        //we are trying to replicate the n + 1, problem

        //this is typically the first query that you made and that is to fetch all the drivers

        //let's say that the request was made for the driver with id 4, 5, 6, 7

//        The N+1 problem is not about CPU time or Java loops. It is specifically about issuing N separate SQL queries
//        instead of a single SQL query.
        List<Long> allIds = new ArrayList<>(Arrays.asList(4L, 5L, 6L, 7L));
        List<Driver> allDriver = driverRepository.findAllByIdIn(allIds);

        for(Driver driver : allDriver){
            System.out.println(driver.toString());
        }

        //here comes the n part where I will make n database calls to fetch all the booking for all n drivers.
//        List<Booking> bookingList = bookingRepository.findAllByDriverIn(allDriver);
//        for(Booking booking : bookingList){
//            System.out.println(booking.toString());
//        }

        for(Driver driver : allDriver){
            List<Booking> bookingList = driver.getBookings();
            for(Booking booking : bookingList){
                System.out.println(booking.toString());
            }
        }
    }
}

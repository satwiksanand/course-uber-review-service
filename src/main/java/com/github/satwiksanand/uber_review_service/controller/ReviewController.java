package com.github.satwiksanand.uber_review_service.controller;

import com.github.satwiksanand.uber_review_service.dtos.BookingReviewDto;
import com.github.satwiksanand.uber_review_service.dtos.ResponseDto;
import com.github.satwiksanand.uber_review_service.service.BookingReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class ReviewController {
    private final BookingReviewService bookingReviewService;

    public ReviewController(BookingReviewService bookingReviewService){
        this.bookingReviewService = bookingReviewService;
    }

    @GetMapping
    public ResponseEntity<List<BookingReviewDto>> getAllBookingReviews(){
        return ResponseEntity.ok().body(bookingReviewService.getAllBookings());
    }

    @GetMapping("{id}")
    public ResponseEntity<BookingReviewDto> getBookingReviewById(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok().body(bookingReviewService.getBookingReviewById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ResponseDto> deleteBookingById(@PathVariable Long id) throws Exception {
        bookingReviewService.deleteBookingReviewById(id);
        return ResponseEntity.ok().body(new ResponseDto("deleted successfully"));
    }

    @PostMapping
    public ResponseEntity<BookingReviewDto> createBookingReview(@RequestBody BookingReviewDto bookingReviewDto) throws Exception {
        return ResponseEntity.ok().body(bookingReviewService.createBookingReview(bookingReviewDto));
    }
}

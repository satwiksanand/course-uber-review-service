package com.github.satwiksanand.uber_review_service.service;

import com.github.satwiksanand.uber_review_service.adapters.BookingReviewDtoToBookingReviewAdapter;
import com.github.satwiksanand.uber_review_service.dtos.BookingReviewDto;
import com.github.satwiksanand.uber_review_service.models.Booking;
import com.github.satwiksanand.uber_review_service.models.BookingReview;
import com.github.satwiksanand.uber_review_service.repository.BookingRepository;
import com.github.satwiksanand.uber_review_service.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingReviewService {
    private final ReviewRepository reviewRepository;
    private final BookingRepository bookingRepository;


    public BookingReviewService(ReviewRepository reviewRepository,
                                BookingRepository bookingRepository) {
        this.reviewRepository = reviewRepository;
        this.bookingRepository = bookingRepository;
    }

    public List<BookingReviewDto> getAllBookings(){
//        List<BookingReview> bookingReviews = reviewRepository.findAll();
        return reviewRepository.findAll().stream().map(BookingReviewDtoToBookingReviewAdapter::toDto).toList();
    }

    public BookingReviewDto getBookingReviewById(Long id) throws Exception {
        Optional<BookingReview> bookingReview = reviewRepository.findById(id);
        if(bookingReview.isPresent()){
            return BookingReviewDtoToBookingReviewAdapter.toDto(bookingReview.get());
        }
        throw new Exception("review not found");
    }

    public void deleteBookingReviewById(Long id) throws Exception {
        try{
            reviewRepository.deleteById(id);
        }
        catch (Exception e){
            throw new Exception("review not found");
        }
    }

    public BookingReviewDto createBookingReview(BookingReviewDto bookingReviewDto) throws Exception {
        Optional<Booking> booking = bookingRepository.findById(bookingReviewDto.getBookingId());
        if(booking.isPresent()){
            BookingReview bookingReview = new BookingReview();
            bookingReview.setRating(bookingReviewDto.getRating());
            bookingReview.setContent(bookingReviewDto.getContent());
            bookingReview.setBooking(booking.get());
            BookingReview savedBookingReview = reviewRepository.save(bookingReview);
            return BookingReviewDtoToBookingReviewAdapter.toDto(savedBookingReview);
        }
        throw new Exception("relevant booking not found!");
    }
}

package com.github.satwiksanand.uber_review_service.service;

import com.github.satwiksanand.uber_review_service.adapters.BookingReviewDtoToBookingReviewAdapter;
import com.github.satwiksanand.uber_review_service.dtos.BookingReviewDto;
import com.github.satwiksanand.uber_review_service.models.BookingReview;
import com.github.satwiksanand.uber_review_service.repository.BookingRepository;
import com.github.satwiksanand.uber_review_service.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingReviewService {
    private final ReviewRepository reviewRepository;


    public BookingReviewService(ReviewRepository reviewRepository,
                                BookingRepository bookingRepository, BookingReviewDtoToBookingReviewAdapter bookingReviewDtoToBookingReviewAdapter) {
        this.reviewRepository = reviewRepository;
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
        BookingReview bookingReview = BookingReviewDtoToBookingReviewAdapter.toEntity(bookingReviewDto);
        if(bookingReview == null){
            throw new Exception("relevant booking not found!");
        }
        return  BookingReviewDtoToBookingReviewAdapter.toDto(reviewRepository.save(bookingReview));
    }
}

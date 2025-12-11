package com.github.satwiksanand.uber_review_service.repository;

import com.github.satwiksanand.uber_review_service.models.BookingReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ReviewRepository extends JpaRepository<BookingReview, Long> {
    Integer countAllByRatingLessThanEqual(Integer rating);
    List<BookingReview> findAllByRatingLessThanEqual(Integer rating);
    List<BookingReview> findAllByCreatedAtBefore(Date createdAt);

    @Query(nativeQuery = true,value = "select * from booking_review br where br.id in (select b.booking_review_id from booking b where b.id = :bookingId)")
    BookingReview findByBooking_Id(@Param("bookingId") Long bookingId);
}

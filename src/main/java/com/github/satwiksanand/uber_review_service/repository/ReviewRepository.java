package com.github.satwiksanand.uber_review_service.repository;

import com.github.satwiksanand.uber_review_service.models.BookingReview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<BookingReview, Long> {

}

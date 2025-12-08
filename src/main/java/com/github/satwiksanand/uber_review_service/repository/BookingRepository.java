package com.github.satwiksanand.uber_review_service.repository;

import com.github.satwiksanand.uber_review_service.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}

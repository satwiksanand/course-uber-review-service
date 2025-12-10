package com.github.satwiksanand.uber_review_service.repository;

import com.github.satwiksanand.uber_review_service.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findAllByDriver_IdIn(List<Long> ids);
}

package com.github.satwiksanand.uber_review_service.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Booking extends BaseModel{
    @Enumerated(value = EnumType.STRING)
    private BookingStatus bookingStatus;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private BookingReview bookingReview;

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Long totalDistance;

    @ManyToOne
    private Driver driver;

    @ManyToOne
    private Passenger passenger;
}

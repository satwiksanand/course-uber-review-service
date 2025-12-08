package com.github.satwiksanand.uber_review_service.models;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class PassengerReview extends BookingReview{
    private String passengerReview;
    private Double passengerRating;
}

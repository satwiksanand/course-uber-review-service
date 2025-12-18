package com.github.satwiksanand.uber_review_service.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class BookingReview extends BaseModel {

    @Column(nullable = false)
    private String content;
    private Double rating;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false)
    private Booking booking;

    @Override
    public String toString() {
        return "content:-> " + this.content +" rating:-> " + this.rating;
    }
}

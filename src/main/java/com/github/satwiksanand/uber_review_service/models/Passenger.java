package com.github.satwiksanand.uber_review_service.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Passenger extends BaseModel{
    private String name;

    @OneToMany(mappedBy = "passenger")
    private List<Booking> bookings;
}

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
public class Driver extends BaseModel{
    private String name;
    private String licenseNumber;

    @OneToMany(mappedBy = "driver")
    private List<Booking> bookings;

    @Override
    public String toString() {
        return "name of the driver:-> " + this.name + " license number is " + this.licenseNumber;
    }
}

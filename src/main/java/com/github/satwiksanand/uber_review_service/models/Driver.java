package com.github.satwiksanand.uber_review_service.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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

    @OneToMany(mappedBy = "driver", fetch = FetchType.LAZY)
    @Fetch(FetchMode.SELECT)
    @BatchSize(size = 2)
    //fetch mode can be select, subselect and join, for select it will make n calls, but you can also batch it in size x
    //so the total calls that will be made is n/x, for subselect it will make one additional call to fetch all the bookings
    //and finally for join it will make one call with join to fetch all the bookings along with drivers.
    private List<Booking> bookings;

    @Override
    public String toString() {
        return "name of the driver:-> " + this.name + " license number is " + this.licenseNumber + " id is " + this.id;
    }
}

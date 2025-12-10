package com.github.satwiksanand.uber_review_service.repository;

import com.github.satwiksanand.uber_review_service.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver, Long> {
    //we can execute queries in two different ways, using raw queries or by using hibernate queries

    //using raw queries.

    @Query(
            nativeQuery = true,
            value = "SELECT * FROM driver WHERE id = :id AND license_number = :ln"
    )
    Optional<Driver> rawFindByIdAndLicenseNumber(
            @Param("id") Long id,
            @Param("ln") String licenseNumber
    );

    //using hibernate query language

    @Query(value = "select d from Driver as d where d.name = :name")
    List<Driver> hqlFindByName(@Param("name") String name);
}

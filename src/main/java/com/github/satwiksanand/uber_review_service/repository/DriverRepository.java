package com.github.satwiksanand.uber_review_service.repository;

import com.github.satwiksanand.uber_review_service.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver, Long> {
    List<Driver> findAllByIdIn(List<Long> ids);
}

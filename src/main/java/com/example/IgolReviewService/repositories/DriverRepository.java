package com.example.IgolReviewService.repositories;

import com.example.IgolReviewService.models.Booking;
import com.example.IgolReviewService.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DriverRepository extends JpaRepository<Driver, Long> {

    List<Driver> findAllByIdIn(List<Long> driverIds);

}
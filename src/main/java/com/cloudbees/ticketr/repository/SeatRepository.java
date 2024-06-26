package com.cloudbees.ticketr.repository;

import com.cloudbees.ticketr.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {

    Seat findBySectionAndSeatNumber(String section, Integer seatNumber);
}

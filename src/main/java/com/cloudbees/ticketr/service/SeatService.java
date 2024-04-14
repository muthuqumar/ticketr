package com.cloudbees.ticketr.service;

import com.cloudbees.ticketr.model.Seat;
import com.cloudbees.ticketr.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeatService {
    private final SeatRepository seatRepository;

    @Autowired
    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    public List<Seat> getAllSeats() {
        return this.seatRepository.findAll();
    }

    public Optional<Seat> getSeatById(Long seatId) {
        return this.seatRepository.findById(seatId);
    }

    public Seat getSeatBySectionAndSeatNumber(String section, Integer seatNumber) {
        return this.seatRepository.findBySectionAndSeatNumber(section, seatNumber);
    }
}

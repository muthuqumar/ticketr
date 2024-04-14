package com.cloudbees.ticketr.service;

import com.cloudbees.ticketr.model.Allocation;
import com.cloudbees.ticketr.model.Seat;
import com.cloudbees.ticketr.model.Tariff;
import com.cloudbees.ticketr.model.User;
import com.cloudbees.ticketr.repository.AllocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Optional;

@Service
public class AllocationService {

    private final AllocationRepository allocationRepository;
    private final UserService userService;
    private final SeatService seatService;
    private final TariffService tariffService;

    @Autowired
    public AllocationService(AllocationRepository allocationRepository, UserService userService, SeatService seatService, TariffService tariffService){
        this.allocationRepository = allocationRepository;
        this.userService = userService;
        this.seatService = seatService;
        this.tariffService = tariffService;
    }

    public List<Allocation> getAllocationsBySection(String section) {
        return switch (section) {
            case "A" -> this.allocationRepository.findAllAllocationsInSectionA();
            case "B" -> this.allocationRepository.findAllAllocationsInSectionB();
            default -> throw new InvalidParameterException("Invalid section provided");
        };
    }

    public Allocation allocateUser(Long userId, Long seatId, Long tariffId) {
        User user = getUser(userId);
        Allocation allocationByUser = this.allocationRepository.findAllocationByUser(user.getId());
        if(allocationByUser == null) {
            Seat seat = getSeat(seatId);
            Allocation allocationBySeat = this.allocationRepository.findAllocationBySeat(seat.getId());
            if (allocationBySeat == null) {
                Tariff tariff = getTariff(tariffId);
                Allocation allocation = new Allocation(user, seat, tariff);
                return this.allocationRepository.save(allocation);
            } else {
                throw new InvalidParameterException("Seat is already allocated");
            }
        } else {
            throw new InvalidParameterException("User is already allocated");
        }
    }

    public void deallocateUser(Long userId) {
        User user = getUser(userId);
        this.allocationRepository.deleteAllocationsByUserId(user.getId());
    }

    public Allocation updateUserSeat(Long userId, Long seatId) {
        User user = getUser(userId);
        Seat newSeat = getSeat(seatId);
        this.allocationRepository.updateUserSeat(user.getId(), newSeat.getId());
        return this.allocationRepository.findAllocationBySeat(newSeat.getId());
    }

    private User getUser(Long userId) {
        Optional<User> userById = this.userService.getUserById(userId);
        if(userById.isEmpty()) {
            throw new InvalidParameterException("Invalid user");
        }
        return userById.get();
    }

    private Seat getSeat(Long seatId) {
        Optional<Seat> seat = this.seatService.getSeatById(seatId);
        if(seat.isEmpty()) {
            throw new InvalidParameterException("Invalid Seat");
        }
        return seat.get();
    }

    private Tariff getTariff(Long tariffId) {
        Optional<Tariff> tariff = this.tariffService.getTariffById(tariffId);
        if(tariff.isEmpty()) {
            throw new InvalidParameterException("Invalid Tariff");
        }
        return tariff.get();
    }

}

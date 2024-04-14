package com.cloudbees.ticketr.controller;

import com.cloudbees.ticketr.model.AllocateRequest;
import com.cloudbees.ticketr.model.Allocation;
import com.cloudbees.ticketr.model.Seat;
import com.cloudbees.ticketr.service.AllocationService;
import com.cloudbees.ticketr.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seats")
public class SeatController {
    private final SeatService seatService;
    private final AllocationService allocationService;

    @Autowired
    public SeatController(SeatService seatService, AllocationService allocationService){
        this.seatService = seatService;
        this.allocationService = allocationService;
    }

    @GetMapping()
    public List<Seat> getAllSeats(){
        return this.seatService.getAllSeats();
    }

    @PostMapping("/book")
    public Allocation bookSeat(@RequestBody AllocateRequest request) {
        return this.allocationService.allocateUser(request.getUserId(), request.getSeatId(), request.getTariffId());
    }

    @GetMapping("/cancel/{userID}")
    public ResponseEntity<String> cancelSeat(@PathVariable Long userID) {
        this.allocationService.deallocateUser(userID);
        return ResponseEntity.accepted().body("User deallocated seat");
    }

    @PostMapping("/change")
    public Allocation modifySeat(@RequestBody AllocateRequest request){
        return this.allocationService.updateUserSeat(request.getUserId(), request.getUserId());
    }

    @GetMapping("/section/{section}")
    public List<Allocation> getSeatsBySection(@PathVariable String section) {
        return this.allocationService.getAllocationsBySection(section);
    }
}

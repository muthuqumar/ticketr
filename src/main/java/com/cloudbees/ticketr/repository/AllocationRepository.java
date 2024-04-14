package com.cloudbees.ticketr.repository;

import com.cloudbees.ticketr.model.Allocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
public interface AllocationRepository extends JpaRepository<Allocation, Long> {

    @Query("SELECT a FROM Allocation a JOIN a.seat s WHERE s.section = 'A'")
    List<Allocation> findAllAllocationsInSectionA();

    @Query("SELECT a FROM Allocation a JOIN a.seat s WHERE s.section = 'B'")
    List<Allocation> findAllAllocationsInSectionB();

    @Query("SELECT a FROM Allocation a JOIN a.user u WHERE a.id=:userId")
    Allocation findAllocationByUser(Long userId);

    @Query("SELECT a FROM Allocation a JOIN a.seat s WHERE s.id=:seatId")
    Allocation findAllocationBySeat(Long seatId);

    @Modifying
    @Query("DELETE FROM Allocation a WHERE a.user.id = :userId")
    void deleteAllocationsByUserId(Long userId);

    @Modifying
    @Transactional
    @Query("UPDATE Allocation a SET a.seat.id = :seatId WHERE a.user.id = :userId")
    void updateUserSeat(Long userId, Long seatId);
}

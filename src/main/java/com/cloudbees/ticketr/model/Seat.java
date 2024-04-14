package com.cloudbees.ticketr.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Seat {

    @Id
    @SequenceGenerator(
            name = "seat-sequence",
            sequenceName = "seat-sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seat_sequence"
    )
    private Long id;
    @Column(nullable = false)
    private String section;
    @Column(unique = true, nullable = false)
    private Integer seatNumber;

    public Seat(String section, Integer seatNumber) {
        this.section = section;
        this.seatNumber = seatNumber;
    }
}

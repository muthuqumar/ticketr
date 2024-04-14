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
@AllArgsConstructor
@NoArgsConstructor
public class Tariff {
    @Id
    @SequenceGenerator(
            name = "tariff-sequence",
            sequenceName = "tariff-sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "tariff-sequence"
    )
    private Long id;
    @Column(nullable = false)
    private String source;
    @Column(nullable = false)
    private String destination;
    @Column(nullable = false)
    private Double price;

    public Tariff(String source, String destination, Double price) {
        this.source = source;
        this.destination = destination;
        this.price = price;
    }
}

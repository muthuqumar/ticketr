package com.cloudbees.ticketr.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Allocation {
    @Id
    @SequenceGenerator(
            name = "allocation-sequence",
            sequenceName = "allocation-sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "allocation-sequence"
    )
    private Long id;
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @OneToOne
    @JoinColumn(name = "seat_id", referencedColumnName = "id")
    private Seat seat;
    @ManyToOne
    @JoinColumn(name = "tariff_id", referencedColumnName = "id")
    private Tariff tariff;

    public Allocation(User user, Seat seat, Tariff tariff) {
        this.user = user;
        this.seat = seat;
        this.tariff = tariff;
    }

    @Override
    public String toString() {
        return "Allocation{" +
                "id=" + id +
                ", user=" + user +
                ", seat=" + seat +
                ", tariff=" + tariff +
                '}';
    }
}

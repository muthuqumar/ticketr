package com.cloudbees.ticketr.config;

import com.cloudbees.ticketr.model.Seat;
import com.cloudbees.ticketr.model.Tariff;
import com.cloudbees.ticketr.repository.SeatRepository;
import com.cloudbees.ticketr.repository.TariffRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class SeatConfiguration {

    @Bean
    CommandLineRunner commandLineRunnerForSeat(SeatRepository seatRepository) {
        return args -> {
            List<Seat> seats = new ArrayList<>();
            for (int i=1; i<=50; ++i) {
                Seat seatA = new Seat("A", i);
                Seat seatB = new Seat("B", i);
                seats.add(seatA);
                seats.add(seatB);
            }
            seatRepository.saveAll(seats);
        };
    }
}

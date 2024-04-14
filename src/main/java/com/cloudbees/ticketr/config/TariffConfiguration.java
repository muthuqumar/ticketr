package com.cloudbees.ticketr.config;

import com.cloudbees.ticketr.model.Tariff;
import com.cloudbees.ticketr.repository.TariffRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TariffConfiguration {

    @Bean
    CommandLineRunner commandLineRunnerForTariff(TariffRepository tariffRepository) {
        return args -> {
            Tariff tariff = new Tariff("London", "Paris", 5.0);
            tariffRepository.save(tariff);
        };
    }

}

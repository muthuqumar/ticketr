package com.cloudbees.ticketr.config;

import com.cloudbees.ticketr.model.User;
import com.cloudbees.ticketr.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfiguration {

    @Bean
    CommandLineRunner commandLineRunnerForUser(UserRepository userRepository) {
        return args -> {
            User sampleUser1 = new User("Muthu Qumar", "Subramanian", "muthuqumar.s@gmail.com");
            User sampleUser2 = new User("Another", "User", "another.user@gmail.com");
            userRepository.saveAll(List.of(sampleUser1, sampleUser2));
        };
    }
}

package com.cloudbees.ticketr.service;

import com.cloudbees.ticketr.model.User;
import com.cloudbees.ticketr.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User saveUser(User user) {
        this.userRepository.save(user);
        return this.userRepository.findUserByEmailAddress(user.getEmailAddress());
    }
}

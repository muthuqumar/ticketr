package com.cloudbees.ticketr.repository;

import com.cloudbees.ticketr.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmailAddress(String email);
}

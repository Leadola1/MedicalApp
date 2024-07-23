package com.ironhack.medicalapp.repository;

import com.ironhack.medicalapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String username);
}

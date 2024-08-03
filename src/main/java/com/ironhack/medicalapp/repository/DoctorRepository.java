package com.ironhack.medicalapp.repository;

import com.ironhack.medicalapp.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
    Optional<Doctor> findByEmail(String email);
    Optional<Doctor> findById(Long id);
}

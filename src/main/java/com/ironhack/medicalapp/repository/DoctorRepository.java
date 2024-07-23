package com.ironhack.medicalapp.repository;

import com.ironhack.medicalapp.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
}

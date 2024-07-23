package com.ironhack.medicalapp.repository;

import com.ironhack.medicalapp.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
}

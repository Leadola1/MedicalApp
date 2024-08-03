package com.ironhack.medicalapp.service.impl;

import com.ironhack.medicalapp.model.Patient;
import com.ironhack.medicalapp.repository.PatientRepository;
import com.ironhack.medicalapp.service.PatientService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Patient save(Patient patient) {
        log.info("saving new patient to database", patient.getEmail());
        patient.setPassword(passwordEncoder.encode(patient.getPassword()));
        return patientRepository.save(patient);

    }

    @Override
    public Patient getPatient(String email) {
        return null;
    }

    @Override
    public List<Patient> getPatients() {
        return List.of();
    }

    @Transactional
    @Override
    public Patient updatePatientAddress(Long id, String address) {
       var patientToUpdate = patientRepository.findById(id).orElseThrow();
       patientToUpdate.setAddress(address);
        return patientRepository.save(patientToUpdate);
    }
}

package com.ironhack.medicalapp.service.impl;

import com.ironhack.medicalapp.model.Doctor;
import com.ironhack.medicalapp.repository.DoctorRepository;
import com.ironhack.medicalapp.repository.UserRepository;
import com.ironhack.medicalapp.service.DoctorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepository doctorRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public Doctor saveDoctor(Doctor doctor) {
        log.info("saving new doctor to database", doctor.getEmail());
        doctor.setPassword(passwordEncoder.encode(doctor.getPassword()));
        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor getDoctor(String email) {
        return null;
    }

    @Override
    public List<Doctor> getDoctors() {
        return List.of();
    }
}

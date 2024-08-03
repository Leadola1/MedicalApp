package com.ironhack.medicalapp.service.impl;

import com.ironhack.medicalapp.dto.DoctorDto;
import com.ironhack.medicalapp.model.Doctor;
import com.ironhack.medicalapp.repository.DoctorRepository;
import com.ironhack.medicalapp.repository.UserRepository;
import com.ironhack.medicalapp.service.DoctorService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
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
    public Doctor getDoctorByEmail(String email) {

      return  doctorRepository.findByEmail(email).orElseThrow(()-> new RuntimeException("User not found"));

    }

    @Override
    public Doctor getDoctor() {
        return null;
    }

    @Override
    public List<Doctor> getDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor getDoctorById(Long id){
        return doctorRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found"));
    }

    @Transactional
    @Override
    public Doctor updateDoctor(Long id, DoctorDto doctor) {
        var doctorToUpdate = doctorRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found"));
       doctorToUpdate.setFirstName(doctor.getFirstName());
       doctorToUpdate.setLastName(doctor.getLastName());
       doctorToUpdate.setEmail(doctor.getEmail());
       doctorToUpdate.setPassword(passwordEncoder.encode(doctor.getPassword()));
       doctorToUpdate.setUsername(doctor.getUsername());
        doctorToUpdate.setSpecialization(doctor.getSpecialization());
        return doctorRepository.save(doctorToUpdate);
    }
}

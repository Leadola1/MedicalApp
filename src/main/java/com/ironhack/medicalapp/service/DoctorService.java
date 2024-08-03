package com.ironhack.medicalapp.service;

import com.ironhack.medicalapp.dto.DoctorDto;
import com.ironhack.medicalapp.model.Doctor;

import java.util.List;

public interface DoctorService {


    Doctor saveDoctor(Doctor doctor);

    Doctor getDoctorByEmail(String email);
    Doctor getDoctor();

    List<Doctor> getDoctors();


    Doctor getDoctorById(Long id);

    Doctor updateDoctor(Long id, DoctorDto doctor);
}

package com.ironhack.medicalapp.service;

import com.ironhack.medicalapp.model.Doctor;

import java.util.List;

public interface DoctorService {


    Doctor saveDoctor(Doctor doctor);

    Doctor getDoctor(String email);

    List<Doctor> getDoctors();
}

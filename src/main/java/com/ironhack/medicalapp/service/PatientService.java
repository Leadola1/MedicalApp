package com.ironhack.medicalapp.service;

import com.ironhack.medicalapp.model.Patient;

import java.util.List;

public interface PatientService {
    Patient save(Patient patient);

    Patient getPatient(String email);

    List<Patient> getPatients();
}

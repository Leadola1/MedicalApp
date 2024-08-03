package com.ironhack.medicalapp.controller;

import com.ironhack.medicalapp.model.Patient;
import com.ironhack.medicalapp.service.PatientService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;
    @PatchMapping("/{id}")
    public Patient updatePatientAddress(@PathVariable("id") Long id, @RequestBody  String address) {
        return patientService.updatePatientAddress(id, address);
    }
}

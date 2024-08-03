package com.ironhack.medicalapp.controller;

import com.ironhack.medicalapp.dto.DoctorDto;
import com.ironhack.medicalapp.model.Doctor;
import com.ironhack.medicalapp.service.DoctorService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/doctor")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;
    @GetMapping("/email/{email}")
    public ResponseEntity<Doctor> getDoctorByEmail(@PathVariable("email") String email) {
        try {
            Doctor doctor = doctorService.getDoctorByEmail(email);
            return new ResponseEntity<>(doctor, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)

    public List<Doctor> getAllDoctors() {
        return doctorService.getDoctors();
    }

    @GetMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)

    public ResponseEntity<Doctor> getDoctorById(@PathVariable("id") Long id) {
        try {
            Doctor doctor = doctorService.getDoctorById(id);
            return new ResponseEntity<>(doctor, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/id/update/{id}")
    public Doctor updateDoctor(@PathVariable("id") Long id, @RequestBody DoctorDto doctor) {
        return doctorService.updateDoctor(id, doctor);
    }
}

package com.ironhack.medicalapp.controller;

import com.ironhack.medicalapp.dto.AddAppointmentDTO;
import com.ironhack.medicalapp.model.Appointment;
import com.ironhack.medicalapp.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointment")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Appointment createAppointment(@RequestBody AddAppointmentDTO appointment) {
        return appointmentService.addAppointment(appointment);
    }

    @GetMapping("/patient")
    @ResponseStatus(HttpStatus.OK)

    public List<Appointment> getAppointmentsByPatientId(@RequestParam("patientId") Long patientId) {
        return appointmentService.getAppointmentByPatientId(patientId);
    }

    @GetMapping("/doctor")
    @ResponseStatus(HttpStatus.OK)

    public List<Appointment> getAppointmentsByDoctorId(@RequestParam("doctorId") Long doctorId) {
        return appointmentService.getAppointmentByDoctorId(doctorId);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAppointment(@RequestParam("appointmentId") Long appointmentId) {
        appointmentService.deleteAppointment(appointmentId);
    }




}

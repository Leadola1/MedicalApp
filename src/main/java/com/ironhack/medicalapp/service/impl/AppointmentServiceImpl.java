package com.ironhack.medicalapp.service.impl;

import com.ironhack.medicalapp.dto.AddAppointmentDTO;
import com.ironhack.medicalapp.model.Appointment;
import com.ironhack.medicalapp.model.Doctor;
import com.ironhack.medicalapp.model.Patient;
import com.ironhack.medicalapp.repository.AppointmentRepository;
import com.ironhack.medicalapp.repository.DoctorRepository;
import com.ironhack.medicalapp.repository.PatientRepository;
import com.ironhack.medicalapp.service.AppointmentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Override
    @Transactional
    public Appointment addAppointment(AddAppointmentDTO appointment) {



        LocalDateTime requestedDateTime = appointment.getDateTime();
        LocalDateTime start = requestedDateTime.minusMinutes(30);
        LocalDateTime end = requestedDateTime.plusMinutes(30);
        Doctor doctor = doctorRepository.findByEmail(appointment.getDoctorEmail())
                .orElseThrow(() -> new RuntimeException("Doctor not found"));
        Patient patient = patientRepository.findByEmail(appointment.getPatientEmail())
                .orElseThrow(() -> new RuntimeException("Patient not found"));
        List<Appointment> conflictingAppointments = appointmentRepository.findConflictingAppointments(start, end, doctor, patient);
        if (!conflictingAppointments.isEmpty()) {
            throw new RuntimeException("There is a conflicting appointment within 30 minutes of the requested time.");
        }



        Appointment appointmentToAdd = new Appointment();
        appointmentToAdd.setDoctor(doctor);
        appointmentToAdd.setPatient(patient);
        appointmentToAdd.setDateTime(requestedDateTime);  // Set the requested dateTime
        appointmentToAdd.setAppointmentType(appointment.getAppointmentType());
        appointmentToAdd.setNotes(appointment.getNotes());

        return appointmentRepository.save(appointmentToAdd);
    }

    @Override
    public List<Appointment> getAppointmentByPatientId(Long patientId) {


        return appointmentRepository.findByPatientId(patientId);
    }

    @Override
    public List<Appointment> getAppointmentByDoctorId(Long doctorId) {
        return appointmentRepository.findByDoctorId(doctorId);
    }

    @Override
    public void deleteAppointment(Long appointmentId) {
            appointmentRepository.deleteById(appointmentId);
    }
}

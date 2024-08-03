package com.ironhack.medicalapp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor

public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    private String appointmentType;
    private String notes;

    public Appointment(LocalDateTime dateTime, Doctor doctor, Patient patient, String appointmentType, String notes) {
        this.dateTime = dateTime;
        this.doctor = doctor;
        this.patient = patient;
        this.appointmentType = appointmentType;
        this.notes = notes;
    }
}

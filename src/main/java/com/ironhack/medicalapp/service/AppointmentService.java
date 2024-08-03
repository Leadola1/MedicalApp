package com.ironhack.medicalapp.service;

import com.ironhack.medicalapp.dto.AddAppointmentDTO;
import com.ironhack.medicalapp.model.Appointment;

import java.util.List;

public interface AppointmentService {

    Appointment addAppointment(AddAppointmentDTO appointment);

    List<Appointment> getAppointmentByPatientId(Long patientId);

    List<Appointment> getAppointmentByDoctorId(Long doctorId);

    void deleteAppointment(Long appointmentId);
}

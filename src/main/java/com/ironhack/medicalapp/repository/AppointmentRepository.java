package com.ironhack.medicalapp.repository;

import com.ironhack.medicalapp.model.Appointment;
import com.ironhack.medicalapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByPatientId(Long patientId);
    List<Appointment> findByDoctorId(Long doctorId);

    @Query("SELECT a FROM Appointment a " +
            "WHERE a.dateTime BETWEEN :start AND :end " +
            "AND (a.doctor = :doctor OR a.patient = :patient)")
    List<Appointment> findConflictingAppointments( @Param("start") LocalDateTime start,
                                                   @Param("end") LocalDateTime end,
                                                   @Param("doctor") User doctor,
                                                   @Param("patient") User patient);


}



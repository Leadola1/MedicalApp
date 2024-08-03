package com.ironhack.medicalapp.dto;

import com.ironhack.medicalapp.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddAppointmentDTO {
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dateTime;
    private String doctorEmail;
    private String patientEmail;
    private String appointmentType;
    private String notes;

}

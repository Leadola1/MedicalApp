package com.ironhack.medicalapp.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDto {
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String specialization;
}

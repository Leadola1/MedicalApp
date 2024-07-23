package com.ironhack.medicalapp.dto;

import lombok.Data;

@Data
public class RegisterDTO {
    private String email;
    private String password;
    private String roleName;
}

package com.ironhack.medicalapp.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@NoArgsConstructor
@Data
public class Patient extends User{
    private String address;

    public Patient(String email, String username, String password) {
        super(email, username, password);
    }
}

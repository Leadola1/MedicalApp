package com.ironhack.medicalapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Doctor extends User{
    private String specialization;

    public Doctor(String email, String username, String password) {
        super(email, username, password);
    }


}

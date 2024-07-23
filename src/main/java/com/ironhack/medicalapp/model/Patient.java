package com.ironhack.medicalapp.model;

import jakarta.persistence.Entity;

@Entity
public class Patient extends User{
    private String address;
}

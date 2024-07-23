package com.ironhack.medicalapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
public class Doctor extends User{
    private String specialization;
}

package com.ironhack.medicalapp.repository;

import com.ironhack.medicalapp.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository <Role,Long> {
}

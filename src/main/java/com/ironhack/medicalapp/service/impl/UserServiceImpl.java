package com.ironhack.medicalapp.service.impl;

import com.ironhack.medicalapp.dto.RegisterDTO;
import com.ironhack.medicalapp.model.Doctor;
import com.ironhack.medicalapp.model.Patient;
import com.ironhack.medicalapp.model.User;
import com.ironhack.medicalapp.repository.PatientRepository;
import com.ironhack.medicalapp.repository.UserRepository;
import com.ironhack.medicalapp.service.DoctorService;
import com.ironhack.medicalapp.service.PatientService;
import com.ironhack.medicalapp.service.RoleService;
import com.ironhack.medicalapp.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final DoctorService doctorService;
    private final PatientService patientService;
    private final RoleService roleService;
    /**
     * Injects a bean of type PasswordEncoder into this class.
     * The bean is used for encoding passwords before storing them.
     */
    private final PasswordEncoder passwordEncoder;
    /**
     * Loads the user by its username
     *
     * @param email the username to search for
     * @return the UserDetails object that matches the given username
     * @throws UsernameNotFoundException if the user with the given username is not found
     */


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Retrieve user with the given username
        User user = userRepository.findByEmail(email);
        // Check if user exists
        if (user == null) {

            log.error("User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        } else {
            log.info("User found in the database: {}", email);
            // Create a collection of SimpleGrantedAuthority objects from the user's roles
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            user.getRoles().forEach(role -> {
                authorities.add(new SimpleGrantedAuthority(role.getName()));
            });
            // Return the user details, including the username, password, and authorities
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
        }
    }
@Transactional
    @Override
    public User saveUser(RegisterDTO user) {
        if (Objects.equals(user.getRoleName(), "doctor")) {
            Doctor doctor = new Doctor(user.getUsername(), user.getEmail(), user.getPassword());
            Doctor doctorSaved =  doctorService.saveDoctor(doctor);
            roleService.addRoleToUser(doctorSaved.getEmail(), "ROLE_ADMIN");

            return   doctorSaved;
        }else if (Objects.equals(user.getRoleName(), "patient")) {
            log.info("saving new patient to data base", user.getEmail());
            Patient patient = new Patient(user.getUsername(), user.getEmail(), user.getPassword());
            Patient patientSaved = patientService.save(patient);
           roleService.addRoleToUser(patientSaved.getEmail(), "ROLE_USER");

            return patientSaved;
        }else{
            log.info("saving new usere to data base", user.getEmail());
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return userRepository.save(new User(user.getUsername(), user.getEmail(), user.getPassword()));
        }


    }

    @Override
    public User getUser(String username) {
        log.info("Fetching user {}", username);
        return userRepository.findByUsername(username);    }

    @Override
    public List<User> getUsers() {
        log.info("Fetching all users");
        return userRepository.findAll();
    }
@Transactional
    @Override
    public void deleteUser(Long id) {
        log.info("Request to delete user with id: {}", id);
        userRepository.deleteById(id);
    }


}
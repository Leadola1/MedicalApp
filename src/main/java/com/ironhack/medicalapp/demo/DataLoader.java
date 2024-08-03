package com.ironhack.medicalapp.demo;

import com.ironhack.medicalapp.dto.RegisterDTO;
import com.ironhack.medicalapp.model.Doctor;
import com.ironhack.medicalapp.model.Role;
import com.ironhack.medicalapp.model.User;
import com.ironhack.medicalapp.service.DoctorService;
import com.ironhack.medicalapp.service.RoleService;
import com.ironhack.medicalapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final UserService userService;
    private final RoleService roleService;
    private final DoctorService doctorService;

    @Override
    public void run(String... args) throws Exception {
        roleService.save(new Role("ROLE_USER"));
        roleService.save(new Role("ROLE_ADMIN"));

        userService.saveUser(new RegisterDTO("lawalbasit@gmail.com", "john", "1234", "patient"));
        userService.saveUser(new RegisterDTO("wilson@gmail.com", "wilson", "1234","doctor"));
        userService.saveUser(new RegisterDTO("george@gmail.com", "george", "1234","patient"));
        userService.saveUser(new RegisterDTO("blessing@gmail.com", "blessing", "1234","doctor"));






    }
}

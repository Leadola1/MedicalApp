package com.ironhack.medicalapp.controller;

import com.ironhack.medicalapp.dto.RegisterDTO;
import com.ironhack.medicalapp.model.User;
import com.ironhack.medicalapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@RequestBody RegisterDTO user) {

        return userService.saveUser(user);
    }

    @DeleteMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }




}

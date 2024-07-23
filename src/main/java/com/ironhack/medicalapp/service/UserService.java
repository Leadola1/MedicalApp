package com.ironhack.medicalapp.service;

import com.ironhack.medicalapp.model.User;

import java.util.List;

public interface UserService {

    /**
     * This method is used to save a User entity to the database.
     *
     * @param user the User entity to be saved.
     * @return the saved User entity.
     */
    User saveUser(User user);

    /**
     * This method is used to retrieve a User from the database by its username.
     *
     * @param username the username of the User to be retrieved.
     * @return the retrieved User entity.
     */
    User getUser(String username);

    /**
     * This method is used to retrieve all User entities from the database.
     *
     * @return a List of all User entities.
     */
    List<User> getUsers();
}

package com.ironhack.medicalapp.service.impl;


import com.ironhack.medicalapp.model.Role;
import com.ironhack.medicalapp.model.User;
import com.ironhack.medicalapp.repository.RoleRepository;
import com.ironhack.medicalapp.repository.UserRepository;
import com.ironhack.medicalapp.service.RoleService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoleServiceImpl implements RoleService {


    private final UserRepository userRepository;


    private final RoleRepository roleRepository;

    /**
     * Saves a new role to the database
     *
     * @param role the role to be saved
     * @return the saved role
     */
    @Override
    @Transactional
    public Role save(Role role) {
        log.info("Saving new role {} to the database", role.getName());
        return roleRepository.save(role);
    }

    /**
     * Adds a role to the user with the given username
     *
     * @param email the username of the user to add the role to
     * @param roleName the name of the role to be added
     */
    @Transactional
    @Override
    public void addRoleToUser(String email, String roleName) {
        log.info("Adding role {} to user {}", roleName, email);

        // Retrieve the user and role objects from the repository
        User user = userRepository.findByEmail(email);
        Role role = roleRepository.findByName(roleName);

        // Add the role to the user's role collection
        user.getRoles().add(role);

        // Save the user to persist the changes
        userRepository.save(user);
    }
}

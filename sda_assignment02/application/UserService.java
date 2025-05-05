package com.bsse1401.sda_assignment01.application;

import com.bsse1401.sda_assignment01.application.interfaces.RoleRepository;
import com.bsse1401.sda_assignment01.application.interfaces.UserRepository;
import com.bsse1401.sda_assignment01.domain.Role;
import com.bsse1401.sda_assignment01.domain.User;

import java.util.*;

public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public UUID createUser(String name, String email) {
        User user = new User(UUID.randomUUID(), name, email);
        return userRepository.save(user).getId();
    }

    public void assignRoleToUser(UUID userId, UUID roleId) {
        User user = userRepository.findById(userId).orElseThrow();
        Role role = roleRepository.findById(roleId).orElseThrow();
        user.addRole(role);
        userRepository.save(user);
    }

    public User getUser(UUID userId) {
        return userRepository.findById(userId).orElseThrow();
    }
}

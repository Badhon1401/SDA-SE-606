package com.bsse1401.sda_assignment01.application;

import com.bsse1401.sda_assignment01.application.interfaces.RoleRepository;
import com.bsse1401.sda_assignment01.domain.Role;

import java.util.UUID;

public class RoleService {
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public UUID createRole(String roleName) {
        Role role = new Role(UUID.randomUUID(), roleName);
        return roleRepository.save(role).getId();
    }
}


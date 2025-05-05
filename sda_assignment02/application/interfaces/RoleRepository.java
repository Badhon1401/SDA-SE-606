package com.bsse1401.sda_assignment01.application.interfaces;

import com.bsse1401.sda_assignment01.domain.Role;

import java.util.Optional;
import java.util.UUID;

public interface RoleRepository {
    Role save(Role role);
    Optional<Role> findById(UUID id);
}


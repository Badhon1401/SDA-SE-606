package com.bsse1401.sda_assignment01.domain;

import java.util.UUID;

public class Role {
    private final UUID id;
    private final String roleName;

    public Role(UUID id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public UUID getId() { return id; }
    public String getRoleName() { return roleName; }
}

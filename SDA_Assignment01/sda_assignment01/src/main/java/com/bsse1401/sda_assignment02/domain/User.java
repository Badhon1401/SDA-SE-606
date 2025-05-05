package com.bsse1401.sda_assignment01.domain;

import java.util.*;

public class User {
    private final UUID id;
    private String name;
    private String email;
    private final List<Role> roles = new ArrayList<>();

    public User(UUID id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public UUID getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public List<Role> getRoles() { return roles; }

    public void addRole(Role role) {
        roles.add(role);
    }
}


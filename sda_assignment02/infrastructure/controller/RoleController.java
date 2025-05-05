package com.bsse1401.sda_assignment01.infrastructure.controller;

import com.bsse1401.sda_assignment01.application.RoleService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/roles")
public class RoleController {
    private final RoleService roleService;
    record CreateRoleRequest(@NotBlank String roleName) {}

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public UUID createRole(@RequestBody @Valid CreateRoleRequest request) {
        return roleService.createRole(request.roleName);
    }
}
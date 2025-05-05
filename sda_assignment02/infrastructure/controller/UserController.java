package com.bsse1401.sda_assignment01.infrastructure.controller;

import com.bsse1401.sda_assignment01.application.UserService;
import com.bsse1401.sda_assignment01.domain.User;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    record CreateUserRequest(@NotBlank String name, @Email String email) {}

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UUID createUser(@RequestBody @Valid CreateUserRequest request) {
        return userService.createUser(request.name(), request.email());
    }

    @PostMapping("/{userId}/assign-role/{roleId}")
    public String assignRole(@PathVariable UUID userId, @PathVariable UUID roleId) {
        userService.assignRoleToUser(userId, roleId);
        return "Role assigned successfully";
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable UUID id) {
        return userService.getUser(id);
    }
}


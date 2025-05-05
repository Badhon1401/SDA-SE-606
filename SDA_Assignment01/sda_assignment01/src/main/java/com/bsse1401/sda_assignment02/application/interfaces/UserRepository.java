package com.bsse1401.sda_assignment01.application.interfaces;

import com.bsse1401.sda_assignment01.domain.User;

import java.util.*;

public interface UserRepository {
    User save(User user);
    Optional<User> findById(UUID id);
}

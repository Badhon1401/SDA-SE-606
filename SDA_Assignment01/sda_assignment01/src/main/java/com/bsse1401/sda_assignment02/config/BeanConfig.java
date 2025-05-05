package com.bsse1401.sda_assignment01.config;


import com.bsse1401.sda_assignment01.application.RoleService;
import com.bsse1401.sda_assignment01.application.UserService;
import com.bsse1401.sda_assignment01.application.interfaces.RoleRepository;
import com.bsse1401.sda_assignment01.application.interfaces.UserRepository;
import com.bsse1401.sda_assignment01.infrastructure.persistence.RoleJpaRepository;
import com.bsse1401.sda_assignment01.infrastructure.persistence.RoleRepositoryImpl;
import com.bsse1401.sda_assignment01.infrastructure.persistence.UserJpaRepository;
import com.bsse1401.sda_assignment01.infrastructure.persistence.UserRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    public UserService userService(UserRepository userRepository, RoleRepository roleRepository) {
        return new UserService(userRepository, roleRepository);
    }

    @Bean
    public RoleService roleService(RoleRepository roleRepository) {
        return new RoleService(roleRepository);
    }
    @Bean
    public UserRepository userRepository(UserJpaRepository repo) {
        return new UserRepositoryImpl(repo);
    }

    @Bean
    public RoleRepository roleRepository(RoleJpaRepository repo) {
        return new RoleRepositoryImpl(repo);
    }

}


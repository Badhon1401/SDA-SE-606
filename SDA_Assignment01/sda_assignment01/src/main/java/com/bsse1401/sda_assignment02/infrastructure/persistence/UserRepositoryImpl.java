package com.bsse1401.sda_assignment01.infrastructure.persistence;

import com.bsse1401.sda_assignment01.application.interfaces.UserRepository;
import com.bsse1401.sda_assignment01.domain.User;
import com.bsse1401.sda_assignment01.domain.Role;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final UserJpaRepository jpaRepository;

    public UserRepositoryImpl(UserJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public User save(User user) {
        UserJpaEntity entity = new UserJpaEntity();
        entity.setId(user.getId());
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());

        List<RoleJpaEntity> roleEntities = new ArrayList<>();
        for (var role : user.getRoles()) {
            RoleJpaEntity roleEntity = new RoleJpaEntity();
            roleEntity.setId(role.getId());
            roleEntity.setRoleName(role.getRoleName());
            roleEntities.add(roleEntity);
        }

        entity.setRoles(roleEntities);
        return mapToDomain(jpaRepository.save(entity));
    }

    @Override
    public Optional<User> findById(UUID id) {
        return jpaRepository.findById(id).map(this::mapToDomain);
    }

    private User mapToDomain(UserJpaEntity entity) {
        User user = new User(entity.getId(), entity.getName(), entity.getEmail());
        for (var roleEntity : entity.getRoles()) {
            user.addRole(new Role(roleEntity.getId(), roleEntity.getRoleName()));
        }
        return user;
    }
}

package com.bsse1401.sda_assignment01.infrastructure.persistence;

import com.bsse1401.sda_assignment01.application.interfaces.RoleRepository;
import com.bsse1401.sda_assignment01.domain.Role;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class RoleRepositoryImpl implements RoleRepository {
    private final RoleJpaRepository jpaRepository;

    public RoleRepositoryImpl(RoleJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Role save(Role role) {
        RoleJpaEntity entity = new RoleJpaEntity();
        entity.setId(role.getId());
        entity.setRoleName(role.getRoleName());
        return mapToDomain(jpaRepository.save(entity));
    }

    @Override
    public Optional<Role> findById(UUID id) {
        return jpaRepository.findById(id).map(this::mapToDomain);
    }

    private Role mapToDomain(RoleJpaEntity entity) {
        return new Role(entity.getId(), entity.getRoleName());
    }
}

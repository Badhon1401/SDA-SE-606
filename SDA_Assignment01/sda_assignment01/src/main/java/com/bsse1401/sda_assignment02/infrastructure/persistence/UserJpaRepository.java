package com.bsse1401.sda_assignment01.infrastructure.persistence;


import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface UserJpaRepository extends JpaRepository<UserJpaEntity, UUID> {}


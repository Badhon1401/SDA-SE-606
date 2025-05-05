package com.bsse1401.sda_assignment01.infrastructure.persistence;
import jakarta.persistence.*;
import lombok.Data;

import java.util.*;

@Entity
@Data
public class RoleJpaEntity {
    @Id
    private UUID id;
    private String roleName;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}


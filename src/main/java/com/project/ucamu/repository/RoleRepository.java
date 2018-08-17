package com.project.ucamu.repository;

import com.project.ucamu.base.JpaQueryDslPredicateRepository;
import com.project.ucamu.domain.Role;
import com.project.ucamu.domain.enums.RoleName;

public interface RoleRepository extends JpaQueryDslPredicateRepository<Role, Integer> {
    Role findRoleByRoleName(RoleName roleName);
}

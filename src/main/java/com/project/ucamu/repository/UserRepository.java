package com.project.ucamu.repository;

import com.project.ucamu.base.JpaQueryDslPredicateRepository;
import com.project.ucamu.domain.User;

public interface UserRepository extends JpaQueryDslPredicateRepository<User, Long> {
    User findUserByIdName(String idName);
}
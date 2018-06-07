package com.project.ucamu.service.impl;

import com.project.ucamu.domain.User;
import com.project.ucamu.repository.UserRepository;
import com.project.ucamu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User getUser(String idName) {
        return userRepository.findUserByIdName(idName);
    }
}

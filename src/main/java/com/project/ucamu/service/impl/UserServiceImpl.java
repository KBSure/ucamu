package com.project.ucamu.service.impl;

import com.project.ucamu.domain.User;
import com.project.ucamu.domain.enums.RoleName;
import com.project.ucamu.dto.UserFormDto;
import com.project.ucamu.repository.UserRepository;
import com.project.ucamu.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User getUser(String idName) {
        return userRepository.findUserByIdName(idName);
    }

    @Override
    public User addUser(UserFormDto userFormDto) {
        User user = new User();
        BeanUtils.copyProperties(userFormDto, user);
//        user.getRoleList().add();
//        userRepository.save(user);
//        return ;
        return null;
    }


}

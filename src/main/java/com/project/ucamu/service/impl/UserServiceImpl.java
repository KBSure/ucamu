package com.project.ucamu.service.impl;

import com.project.ucamu.domain.Role;
import com.project.ucamu.domain.User;
import com.project.ucamu.domain.UserSituation;
import com.project.ucamu.domain.embeddable.UserDate;
import com.project.ucamu.domain.enums.RoleName;
import com.project.ucamu.domain.enums.SituationState;
import com.project.ucamu.dto.UserFormDto;
import com.project.ucamu.repository.RoleRepository;
import com.project.ucamu.repository.UserRepository;
import com.project.ucamu.repository.UserSituationRepository;
import com.project.ucamu.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserSituationRepository userSituationRepository;

    @Override
    @Transactional(readOnly = true)
    public User getUser(String idName) {
        return userRepository.findUserByIdName(idName);
    }

    @Override
    @Transactional
    public User addUser(UserFormDto userFormDto) {
        User user = new User();
        BeanUtils.copyProperties(userFormDto, user);

        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Role role = roleRepository.findRoleByRoleName(RoleName.USER);
        UserSituation situation = userSituationRepository.findUserSituationByState(SituationState.NORMAL);
        UserDate userDate = new UserDate();
        userDate.setRegDate(LocalDateTime.now());
        userDate.setUpDate(LocalDateTime.now());
        user.addRole(role);
        user.setUserSituation(situation);
        user.setUserdate(userDate);
        User saveUser = userRepository.save(user);
        return saveUser;
    }

}

package com.project.ucamu.service;

import com.project.ucamu.domain.User;
import com.project.ucamu.dto.UserFormDto;

public interface UserService {
    User getUser(String idName);
    User addUser(UserFormDto userFormDto);
    User updateUser(String idName, UserFormDto userFormDto);
}

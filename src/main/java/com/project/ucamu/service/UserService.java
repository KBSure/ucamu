package com.project.ucamu.service;

import com.project.ucamu.domain.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User getUser(String idName);
}

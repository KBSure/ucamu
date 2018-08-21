package com.project.ucamu.security;

import com.project.ucamu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// Security에서 UserRole 조회할때 Lazy 로딩 해야되는데,
// @Transactional 안붙이면 DB에서 조회후에 커넥션 닫기기 때문에 오류 납니다.
@Transactional
@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new SecurityUser(userRepository.findUserByIdName(username));
    }
}

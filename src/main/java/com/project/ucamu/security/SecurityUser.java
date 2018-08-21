package com.project.ucamu.security;

import com.project.ucamu.domain.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SecurityUser extends User {

    public SecurityUser(com.project.ucamu.domain.User user){
        super(user.getIdName(), user.getPassword(), makeGrantedAuthority(user.getRoleList()));
    }

    private static List<GrantedAuthority> makeGrantedAuthority(List<Role> roles){
        List<GrantedAuthority> list = new ArrayList<>();
        roles.forEach(role -> list.add(new SimpleGrantedAuthority(role.getRoleName().toString()))); //저 list는 어떻게 포함되게 되지?
        return list;
    }

}

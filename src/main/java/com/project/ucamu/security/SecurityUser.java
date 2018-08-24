package com.project.ucamu.security;

import com.project.ucamu.domain.Role;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter @Setter
public class SecurityUser extends User {
    private String nickname;
    private Long id;

    public SecurityUser(com.project.ucamu.domain.User user){
        super(user.getIdName(), user.getPassword(), makeGrantedAuthority(user.getRoleList()));
    }

    private static List<GrantedAuthority> makeGrantedAuthority(List<Role> roles){
        List<GrantedAuthority> list = new ArrayList<>();
        roles.forEach(role -> list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName().toString()))); //저 list는 어떻게 포함되게 되지?
        return list;
    }

}

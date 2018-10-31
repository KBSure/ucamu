package com.project.ucamu.interceptor;

import com.project.ucamu.domain.User;
import com.project.ucamu.security.SecurityUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginCheckInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication != null && authentication.getPrincipal() instanceof SecurityUser){
            SecurityUser securityUser = (SecurityUser) authentication.getPrincipal();
            User user = new User();
            user.setNickname(securityUser.getNickname());
            user.setId(securityUser.getId());
            user.setIdName(securityUser.getUsername());
            request.setAttribute("loginUser", user);
        }

        return super.preHandle(request, response, handler);
    }
}

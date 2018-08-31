package com.project.ucamu.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class RefererCheckInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String referer = request.getHeader("referer");
        String uri = request.getRequestURI();
        if("/user/login".equals(uri)){
            uri = referer;
        }
        request.setAttribute("loginRedirect", uri);
        return super.preHandle(request, response, handler);
    }
}

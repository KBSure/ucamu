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
        System.out.println("testtest");
        System.out.println("getUri!! : " + uri);
        if("/user/login".equals(uri)){
            uri = referer;
            System.out.println("uri!! : " + uri);
        }
        request.setAttribute("loginRedirect", uri);
        System.out.println("testtest3");
        System.out.println((String)request.getAttribute("loginRedirect"));
        return super.preHandle(request, response, handler);
    }
}

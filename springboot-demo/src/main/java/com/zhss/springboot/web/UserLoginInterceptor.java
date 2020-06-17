package com.zhss.springboot.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class UserLoginInterceptor implements HandlerInterceptor {
    
    public boolean preHandle(HttpServletRequest request, 
                             HttpServletResponse response, Object handler) 
                             throws Exception {
    	Boolean result = Boolean.valueOf(request.getParameter("_login"));    
    	return result;
    }
    
    public void postHandle(HttpServletRequest request, 
                           HttpServletResponse response, 
                           Object handler, 
                           ModelAndView moodelAndView)
                           throws Exception {
    
    }
    
    public void afterCompletion(HttpServletRequest request, 
                                HttpServletResponse response, 
                                Object handler, 
                                Exception ex)
                                throws Exception {
    
    }
    
}
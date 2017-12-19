package com.doctorwork.union.common.interceptor;

import com.doctorwork.union.common.annotation.Auth;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor{
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        
        //判断当前handler是否为methodHandler
        if(!(handler instanceof HandlerMethod)) {
            return true;
        }
        
        HandlerMethod handlerMethod = (HandlerMethod) handler;

        Auth adminLogin = handlerMethod.getMethodAnnotation(Auth.class);
        
        if(null == adminLogin) {
            return true;
        }

        Object userInfo = request.getSession(true).getAttribute("login");
        if(userInfo ==null) {
            request.getRequestDispatcher("/login/error").forward(request, response);
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        
    }


}

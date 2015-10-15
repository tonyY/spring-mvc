package com.springmvc.controller.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
    
    private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {
        long startTime = System.currentTimeMillis();
        logger.info("请求URL::" + request.getRequestURL().toString()
                + ":: Start Time=" + System.currentTimeMillis());
        request.setAttribute("startTime", startTime);
        //if returned false, we need to make sure 'response' is sent
        return true;
    }
 
    @Override
    public void postHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        System.out.println("请求URL::" + request.getRequestURL().toString()
                + " Sent to Handler :: Current Time=" + System.currentTimeMillis());
        //we can add attributes in the modelAndView and use that in the view page
    }
 
    @Override
    public void afterCompletion(HttpServletRequest request,
            HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        long startTime = (Long) request.getAttribute("startTime");
        logger.info("请求URL::" + request.getRequestURL().toString()
                + ":: End Time=" + System.currentTimeMillis());
        logger.info("请求URL::" + request.getRequestURL().toString()
                + ":: Time Taken=" + (System.currentTimeMillis() - startTime));
    }
 
}

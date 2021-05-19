package com.dumbo.springboot.Filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
// method 1. global setting , all request do Filter
//@Component
// method 2. use WebFilter annotation, with ServletComponentScan (in SpringbootApplication)
//@WebFilter(filterName = "filter1", urlPatterns = {"/test/*"})
public class MyFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest=(HttpServletRequest)servletRequest;
        HttpServletResponse httpServletResponse=(HttpServletResponse)servletResponse;
        System.out.println("filter1----------"+httpServletResponse.getStatus());
        System.out.println("filter1=========="+httpServletRequest.getRequestURL());
        filterChain.doFilter(servletRequest,servletResponse);
    }
}

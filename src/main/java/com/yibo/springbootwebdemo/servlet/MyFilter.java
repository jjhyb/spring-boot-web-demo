package com.yibo.springbootwebdemo.servlet;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: wb-hyb441488
 * @Date: 2018/12/27 19:17
 * @Description:
 */

@WebFilter(servletNames = "myServlet")
public class MyFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        ServletContext servletContext = request.getServletContext();
        servletContext.log("/myServlet was filtered!");
        filterChain.doFilter(request,response);
    }
}

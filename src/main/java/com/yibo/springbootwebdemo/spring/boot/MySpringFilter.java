package com.yibo.springbootwebdemo.spring.boot;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: wb-hyb441488
 * @Date: 2018/12/27 20:04
 * @Description:
 */
public class MySpringFilter extends OncePerRequestFilter {

    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        /*ServletContext servletContext = request.getServletContext();
        StringBuffer requestURL = request.getRequestURL();
        servletContext.log(requestURL + " MySpringFilter was filtered!");*/

        //下面这行代码和上面的代码效果一样
        doSomething();
        filterChain.doFilter(request,response);
    }

    public void doSomething(){
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)requestAttributes;
        HttpServletRequest request = servletRequestAttributes.getRequest();
        ServletContext servletContext = request.getServletContext();
        StringBuffer requestURL = request.getRequestURL();
        servletContext.log(requestURL + " MySpringFilter was filtered!");
    }
}

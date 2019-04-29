package com.yibo.springbootwebdemo.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

/**
 * @author: wb-hyb441488
 * @Date: 2018/12/27 19:29
 * @Description:
 */

@WebListener
public class MyServletRequestListener implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        HttpServletRequest request = (HttpServletRequest)sre.getServletRequest();
        ServletContext servletContext = request.getServletContext();
        servletContext.log("request was Initialized!");

    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        HttpServletRequest request = (HttpServletRequest)sre.getServletRequest();
        ServletContext servletContext = request.getServletContext();
        servletContext.log("request was Destroyed!");
    }
}

package com.yibo.springbootwebdemo.spring.boot;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author: wb-hyb441488
 * @Date: 2018/12/27 19:53
 * @Description:
 *
 * 使用Spring Boot Api的方式
 */


public class MySpringServlet extends HttpServlet {

    private String value;

    @Override
    public void init(ServletConfig config) throws ServletException {
        value = config.getInitParameter("name");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        ServletContext servletContext = request.getServletContext();
        servletContext.log("MySpringServlet doGet......");
        printWriter.write("<html><body>Hello world, MySpringServlet " + value + "</body></html>");
    }
}

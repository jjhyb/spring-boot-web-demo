package com.yibo.springbootwebdemo.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author: wb-hyb441488
 * @Date: 2018/12/27 18:02
 * @Description:
 *
 * 使用Java 原生APi
 */

@WebServlet(name = "myServlet",urlPatterns = "/myServlet",
        initParams = {
            @WebInitParam(name = "myName", value = "myValue")
        })
public class MyServlet extends HttpServlet {

    private String value;

    @Override
    public void init(ServletConfig config) throws ServletException {
        value = config.getInitParameter("myName");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        ServletContext servletContext = request.getServletContext();
        servletContext.log("myServlet doGet......");
        printWriter.write("<html><body>Hello world, "+value+"</body></html>");
    }
}

package com.ql.datasharing;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author qilin.liu
 * @company: qishon
 * @date:20172017/12/13 0013下午 1:55
 * @Description:
 */
public class ServletContextDemo5 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        response.getOutputStream().write("ServletContextDemo5".getBytes());
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        doGet(request, response);
    }
}
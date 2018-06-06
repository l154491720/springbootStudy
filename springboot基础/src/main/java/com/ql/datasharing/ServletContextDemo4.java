package com.ql.datasharing;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author qilin.liu
 * @company: qishon
 * @date:20172017/12/13 0013下午 1:47
 * @Description:用servletContext实现请求转发
 */
public class ServletContextDemo4 extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
        String data = "<h1><font color='red'>abcdefghjkl</font></h1>";
        response.getOutputStream().write(data.getBytes());
        ServletContext context = this.getServletContext();//获取ServletContext对象
        RequestDispatcher rd = context.getRequestDispatcher("/servlet/ServletContextDemo5");//获取请求转发对象(RequestDispatcher)
        rd.forward(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
             }
}
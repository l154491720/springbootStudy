package com.ql.datasharing;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author qilin.liu
 * @company: qishon
 * @date:20172017/12/13 0013下午 1:45
 * @Description:获取Web应用的初始化参数
 */
public class ServletContextDemo3 extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
        ServletContext context = this.getServletContext();
        //获取整个web站点的初始化参数
        String contextInitParam = context.getInitParameter("url");
        response.getWriter().print(contextInitParam);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        doGet(request, response);
    }
}
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
 * @date:20172017/12/13 0013上午 11:22
 * @Description:
 */
public class ServletContextDemo2 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        ServletContext context = this.getServletContext();
        String data = (String) context.getAttribute("data");    //从ServletContent对象中取出数据
        response.getWriter().print("data="+data);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        doGet(request,response);
    }
}
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
 * @date:20172017/12/12 0012下午 1:43
 * @Description: ServletContextDemo1和ServletContextDemo2通过ServletContext对象实现数据共享
 */
public class ServletContextDemo1 extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        String data = "xdp_gacl";

        /**
         * ServletConfig对象中维护了ServletContext对象的引用，开发人员在编写Servlet时,可以通过
         * ServletConfig.getServletContext方法获取ServletContext对象。
         */
        ServletContext context = this.getServletConfig().getServletContext();  //获取ServletContext对象
        context.setAttribute("data",data);  //将data存储到ServletContext中
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        doGet(request,response);
    }
}
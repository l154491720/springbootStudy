package com.ql.springbootservlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author qilin.liu
 * @company: qishon
 * @date:20172017/12/13 0013下午 1:10
 * @Description:
 */
public class MyServlet extends HttpServlet {

    private static final long  serialVersionUID = 8031133938454140403L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)throws ServletException,IOException{
        resp.setContentType("test/html");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hello World</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>welcome this is my servlet!!!</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}
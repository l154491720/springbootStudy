package com.ql.datasharing;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Properties;

/**
 * @author qilin.liu
 * @company: qishon
 * @date:20172017/12/13 0013下午 1:59
 * @Description:
 */
public class ServletContextDemo6 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        response.setHeader("content-type","text/html;charset=UTF-8");
        readSrcDirPropCfgFile(response);//读取src目录下的properties配置文件
        response.getWriter().println("</hr>");
        readWebRootDirPropCfgFile(response);//读取WebRoot目录下的properties配置文件
        response.getWriter().println("<hr/>");
        readPropCfgFile(response);//读取src目录下的db.config包中的db3.properties配置文件
        response.getWriter().println("<hr/>");
        readPropCfgFile2(response);//读取src目录下的gacl.servlet.study包中的db4.properties配置文件
    }

    /**
     * 读取db4.properties文件
     * @param response
     * @throws IOException
     */
    private void readPropCfgFile2(HttpServletResponse response)throws IOException{
        InputStream in = this.getServletContext().getResourceAsStream("com/ql/datasharing/db4.properties");
        Properties prop = new Properties();
        prop.load(in);
        String driver = prop.getProperty("driver");
        String url = prop.getProperty("url");
        String username = prop.getProperty("userName");
        String password = prop.getProperty("password");
        response.getWriter().println("读取src目录下的db4.properties");
        response.getWriter().println(
                MessageFormat.format(
                        "driver={0},url={1},username={2},password={3}",
                        driver,url,username,password));
    }

    /**
     * 读取db3.properties配置文件
     * @param response
     * @throws FileNotFoundException
     * @throws IOException
     */
    private void readPropCfgFile(HttpServletResponse response)throws FileNotFoundException,IOException{
        //通过ServletContext获取Web资源的绝对路径
        String path = this.getServletContext().getRealPath("com/ql/db/config/db3.properties");
        InputStream in = new FileInputStream(path);
        Properties prop = new Properties();
        prop.load(in);
        String driver = prop.getProperty("driver");
        String url = prop.getProperty("url");
        String username = prop.getProperty("username");
        String password = prop.getProperty("password");
        response.getWriter().println("读取src目录下的db3.properties文件");
        response.getWriter().println(
                MessageFormat.format(
                        "driver={0},url={1},username={2},password={3}",
                        driver,url,username,password));
    }

    private void readWebRootDirPropCfgFile(HttpServletResponse response)throws IOException{

    }
}
package com.ql.springbootservlet;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * @author qilin.liu
 * @company: qishon
 * @date:20172017/12/13 0013上午 11:39
 * @Description: 手动注册Servlet
 */
public class ServletConfigure {

    /**
     * 代码注册servlet(不需要@ServletComponentScan注解)
     * @return
     */
    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        return new ServletRegistrationBean(new MyServlet1(),"\"/servlet/myServlet1");  //ServletNmae默认值为首字母小写
        //即myServlet1
    }

    /**
     * 多个servlet就注册多个Bean
     * @return
     */
//    @Bean
//    public ServletRegistrationBean servletRegistrationBean1(){
//        return new ServletRegistrationBean(new MyServlet(), "\"/servlet/myServlet"); //ServletName默认为首字母小写,即myServlet
//    }

}
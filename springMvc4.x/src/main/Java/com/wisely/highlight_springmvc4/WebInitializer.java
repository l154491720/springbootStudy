package com.wisely.highlight_springmvc4;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by qilin.liu on 2018/4/14.
 * web配置
 */
public class WebInitializer implements WebApplicationInitializer { //1
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(MyMvcConfig.class);
        ctx.setServletContext(servletContext); //2

        ServletRegistration.Dynamic servlet =
                servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));//3

        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);
    }
}
/*
    ①WebApplicationInitializer是Spring提供用来配置Servlet3.0+配置的接口从而实现代替了web.xml的位置。
    实现此接口将会自动被SpringServletContainerInitializer(用来启动Servlet3.0容器)获取到。

    ②新建WebApplicationContext，注解配置类，并将其和当前servletContext关联。

    ③注册Spring MVC到DispatcherServlet。
 */

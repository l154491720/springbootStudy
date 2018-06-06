package com.wisely.highlight_springmvc4;

import com.wisely.highlight_springmvc4.interceptor.DemoInterceptor;
import com.wisely.highlight_springmvc4.messageconverter.MyMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.List;

/**
 * Created by qilin.liu on 2018/4/14.
 */
@Configuration
@EnableWebMvc //开启SpringMvC支持，若无此句，重写WebMvcConfigurerAdapter方法无效。
@ComponentScan("com.wisely.highlight_springmvc4")
//继承WebMvcConfigurerAdapter，重写其方法可对其SpringMvc进行重新配置
public class MyMvcConfig extends WebMvcConfigurerAdapter{


    /*
    此处代码无任何特别，只是一个普通的spring配置类，这里我们配置了一个JSP的ViewResolver,
    用来映射路径和实际页面的位置，其中，@EnableWebMVC注解会开启一些默认配置，如一些ViewResolver
    或者MessageConverter。

    在此处特别解释一下Spring MVC的ViewResolver,这是Spring MVC视图(JSP下就是html)渲染的核心机制
    ;Spring MVC里有一个接口ViewResolver(我们的ViewResolver都实现该接口)，实现这个接口要重写
    resolverViewName()，这个方法的返回值是接口View，而View的职责就是使用model,request,
    response对象，并将渲染的视图返回给浏览器
 */
    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/classes/views/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }

    @Bean //MultipartResolver配置
    public MultipartResolver multipartResolver(){
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(1000000); //参数单位bytes
        return multipartResolver;
    }

    /*
    addResourceLocations指的是文件放置的目录，addResourceHandler指的是对外暴露的访问路径
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/assets/**").
                addResourceLocations("classpath:/asstes/"); //3
    }

    @Bean //配置拦截器的Bean
    public DemoInterceptor demoInterceptor(){
        return new DemoInterceptor();
    }

    @Override //重写addInterceptors方法，注册拦截器
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(demoInterceptor());
    }


    @Override//重写页面转向的ViewController
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("/index");
        registry.addViewController("/toUpload").setViewName("/upload");
        registry.addViewController("/converter").setViewName("/converter");
        registry.addViewController("/sse").setViewName("/sse");
    }

    /*
    仅添加一个自定义的HttpMessageConverter，不覆盖默认注册的HttpMessageConverter

     */
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(converter());
    }

    @Bean
    public MyMessageConverter converter(){
        return new MyMessageConverter();
    }
}


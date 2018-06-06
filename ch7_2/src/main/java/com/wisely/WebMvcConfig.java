package com.wisely;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by qilin.liu on 2018/4/21.
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    /*
    值得指出的是，在这里重写的addViewControllers方法，并不会覆盖WebMvcAutoConfiguration中的addViewControllers,
    这也意味着我们自己的配置和Spring Boot的配置同时有效，这也是我们推荐添加自己的MVC配置的方式。
     */
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry){
//        registry.addViewController("/xx").setViewName("/xx");
//    }
}

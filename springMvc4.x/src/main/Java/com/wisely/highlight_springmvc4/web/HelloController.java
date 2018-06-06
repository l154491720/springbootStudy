package com.wisely.highlight_springmvc4.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by qilin.liu on 2018/4/14.
 * 简单控制器
 */
@Controller //1 利用Controller注解声明一个控制器
public class HelloController {

    @RequestMapping("/index") //2 利用@RequestMapping配置URL和方法之间的映射
    public String hello(){
        System.out.println("aaaa");
        return "index"; //3 通过上面ViewResolver的Bean配置,返回index,说明我们的页面放置
        //路径为/WEB/classes/views/index.jsp。
    }
}

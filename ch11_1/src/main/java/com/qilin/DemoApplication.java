package com.qilin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.endpoint.Endpoint;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by qilin.liu on 2018/6/13.
 */
@SpringBootApplication
@RestController
public class DemoApplication {

    @Autowired
    StatusService statusService;

    public static void main(String[] args){
        SpringApplication.run(DemoApplication.class,args);
    }

    //1 注册端点的Bean
    @Bean
    public Endpoint<String> status(){
        Endpoint<String> status = new StatusEndpoint();
        return status;
    }

    //2 定义控制器方法来改变status
    @RequestMapping("/change")
    public String changeStatus(String status){
        statusService.setStatus(status);
        return "ok";
    }

}

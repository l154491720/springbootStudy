package com.qilin;

import org.springframework.beans.BeansException;
import org.springframework.boot.actuate.endpoint.AbstractEndpoint;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 自定义端点
 * Created by qilin.liu on 2018/6/13.
 */
//1 通过 @ConfigurationProperties 的设置，我们可以在application.properties中通过endpoints.status配置我们的端点
@ConfigurationProperties(prefix = "endpoint.status",ignoreUnknownFields = false)
/*
   2    继承AbstractEndpoint类，AbstractEndpoint是Endpoint接口的抽象实现，当前类一定要重写invoke方法
        实现ApplicationContextAware接口可以让当前类对spring容器有意识，即可以访问容器的资源
 */
public class StatusEndpoint extends AbstractEndpoint<String> implements ApplicationContextAware {

    ApplicationContext context;

    public StatusEndpoint(){
        super("status");
    }


    @Override
    //3 通过重写Invoke方法，返回我们要监控的内容
    public String invoke() {
        StatusService statusService = context.getBean(StatusService.class);
        return "The Current Status is:"+statusService.getStatus();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}

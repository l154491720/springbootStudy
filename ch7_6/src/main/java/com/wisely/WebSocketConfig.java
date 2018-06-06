package com.wisely;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * 配置WebSocket,需要在在配置类上使用@EnableWebSocketMessageBroker来开启WebSocket支持，并通过
 * 继承AbstractWebSocketMessageBrokerConfigurer类，重写其方法来配置WebSocket。
 * Created by qilin.liu on 2018/5/31.
 */
@Configuration
@EnableWebSocketMessageBroker //1
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer{

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry){ //2
        registry.addEndpoint("/endpointWisely").withSockJS(); //3

        //2.1 注册一个名为/endpointChat的endpoint
        registry.addEndpoint("/endpointChat").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry){ //4
        registry.enableSimpleBroker("/topic"); //5

        //点对点式增加一个/queue消息代理
        registry.enableSimpleBroker("/queue","/topic"); //2.2
    }


}

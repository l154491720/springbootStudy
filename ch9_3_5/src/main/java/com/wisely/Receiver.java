package com.wisely;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消息监听
 * Created by qilin.liu on 2018/6/10.
 */
@Component
public class Receiver {

    /*
    使用@RabbitListener来监听RabbitMQ的目的地发送的消息，通过queues属性指定要监听的目的地
     */
    @RabbitListener(queues = "my-queue")
    public void receiveMessage(String message){
        System.out.println("Receive<"+message+">");
    }
}

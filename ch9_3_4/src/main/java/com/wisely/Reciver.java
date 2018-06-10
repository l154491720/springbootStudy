package com.wisely;


import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * 消息监听
 * Created by qilin.liu on 2018/6/10.
 */
@Component
public class Reciver {

    @JmsListener(destination = "my-destination")
    public void receiveMessage(String message){
        System.out.println("接收到:<"+message+">");
    }

//    @JmsListener(destination = "my-destiination")
//    public void destiination(String message){
//        System.out.println("过期消息");
//    }
}

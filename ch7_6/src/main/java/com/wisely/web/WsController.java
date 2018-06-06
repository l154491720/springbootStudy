package com.wisely.web;

import com.wisely.domain.WiselyMessage;
import com.wisely.domain.WiselyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

/**
 * Created by qilin.liu on 2018/5/31.
 */
@Controller
public class WsController {

    //2.1 通过SimpMessagingTemplate向浏览器发送消息
    @Autowired
    private SimpMessagingTemplate messageTemple;

    //1 当浏览器向服务端发送请求时，通过Message映射/welcome这个地址，类似于@RequestMapping
    @MessageMapping("/welcome")
    //2 当服务端有消息时，会对订阅了@SendTo中的路径的浏览器发送消息
    @SendTo("/topic/getResponse") //2
    public WiselyResponse say(WiselyMessage message)throws Exception{
//        Thread.sleep(3000);
        return new WiselyResponse("Welcome, "+message.getName()+"!");
    }


    @MessageMapping("/chat")
    //2.2 在Spring MVC中，可以直接在参数中获得principal,principal中包含当前用户的信息。
    public void handleChat(Principal principal, String msg){
        //2.3 这里一段硬编码，如果发送人是wyf,则发送给wisely，如果发送人是wisely，则发送给wyf，读者可以根据项目实际需要改写此处代码
        if(principal.getName().equals("wfy")){
            //2.4 messageTemple.convertAndSendToUser向用户发送消息，第一个参数是接受消息的用户，第二个是浏览器订阅的地址，第三个是消息本身
            messageTemple.convertAndSendToUser("wisely","/queue/notifications",
                    principal.getName()+"-send:" + msg);
        }else{
            messageTemple.convertAndSendToUser("wfy","/queue/notifications",
                    principal.getName() + "-send:"+msg);
        }
    }
}

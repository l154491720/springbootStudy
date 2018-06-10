package com.wisely;


import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * 定义消息
 * Created by qilin.liu on 2018/6/10.
 */
public class Msg implements MessageCreator {


    /*
    定义JMS发送的消息需事先MessageCreator接口，并重写其createMessage方法
     */
    @Override
    public Message createMessage(Session session) throws JMSException {
        return session.createTextMessage("测试消息");
    }

}

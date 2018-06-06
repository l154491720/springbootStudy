package com.wisely.domain;

/**
 * 服务端向浏览器发送的此类的消息
 * Created by qilin.liu on 2018/5/31.
 */
public class WiselyResponse {

    private String responseMessage;

    public WiselyResponse(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    
}

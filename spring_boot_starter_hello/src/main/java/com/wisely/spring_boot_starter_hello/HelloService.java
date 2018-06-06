package com.wisely.spring_boot_starter_hello;

/**
 * Description: 本例根据此类的存在与否来创建这个Bean，这个类可以是第三方类库。
 * Created by qilin.liu on 2018/4/20.
 */
public class HelloService {

    private String msg;

    public String sayHello(){
        return "Hello " + msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

/*
 本例根据此类的存在与否来创建这个类的Bean，这个类可以是第三方类库的类。
 */
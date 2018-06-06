package ch2.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by qilin.liu on 2018/4/11.
 */
@Component
public class DemoPublisher {

    //1注入ApplicationContext用来发布事件
    @Autowired
    ApplicationContext applicationContext;

    public void publish(String msg){
        //2使用ApplicationContext的publishEvent()方法来发布
        applicationContext.publishEvent(new DemoEvent(this,msg));
    }
}

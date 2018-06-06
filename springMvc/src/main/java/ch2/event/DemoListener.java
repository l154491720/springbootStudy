package ch2.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by qilin.liu on 2018/4/11.
 */
@Component
public class DemoListener implements ApplicationListener<DemoEvent> { //1

    @Override
    public void onApplicationEvent(DemoEvent event) { //2
        String msg = event.getMsg();
        System.out.println("我(bean-demoListener)接收到了bean-demoPublisher发布的消息:" + msg);
    }
}

//①实现ApplicationListener接口，并指定监听的事件类型
//②使用onApplicationEvent方法对消息进行接受处理

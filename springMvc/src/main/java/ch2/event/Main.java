package ch2.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by qilin.liu on 2018/4/11.
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EventConfig.class);

        DemoPublisher demoPublisher = context.getBean(DemoPublisher.class);
        demoPublisher.publish("hello application event");

        context.close();
    }
}

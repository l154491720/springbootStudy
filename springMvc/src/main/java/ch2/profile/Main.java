package ch2.profile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by qilin.liu on 2018/4/11.
 */
public class Main {

    public static void main(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.getEnvironment().setActiveProfiles("prod"); //1
        context.register(ProfileConfig.class); //2
        context.refresh(); //3

        DemoBean demoBean = context.getBean(DemoBean.class);
        System.out.println(demoBean.getContent());
        context.close();
    }
}

//①先将活动的Profile设置为prod
//②后注册Bean的配置类，不然会报Bean未定义的错误
//③刷新容器
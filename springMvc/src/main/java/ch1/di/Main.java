package ch1.di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Administrator on 2018/4/10.
 */
public class Main {
    public static void main(String[] agrs){
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DiConfig.class); //1

        UseFunctionService useFunctionService = context.getBean(UseFunctionService.class);//2
        System.out.println(useFunctionService.SayHello("di"));
        context.close();
    }
}

//代码解释
//①AnnotationConfigApplicationContext作为Spring的容器，接收一个配置类作为参数
//②获得声明配置的UseFunctionService的Bean

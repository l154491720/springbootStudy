package ch1.aop;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Administrator on 2018/4/10.
 */
public class Main {
    public static void main(String[] agrs){
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AopConfig.class); //1

        DemoAnnotationService demoAnnotationService = context.getBean(DemoAnnotationService.class);

        DemoMethodService demoMethodService = context.getBean(DemoMethodService.class);//2

        demoAnnotationService.add();

        demoMethodService.add();
        context.close();
    }
}

//代码解释
//①AnnotationConfigApplicationContext作为Spring的容器，接收一个配置类作为参数
//②获得声明配置的UseFunctionService的Bean

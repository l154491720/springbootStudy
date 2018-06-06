package ch1.javaconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Administrator on 2018/4/10.
 */
public class Main {
    public static void main(String[] agrs){
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(JavaConfig.class); //1
        FunctionService functionService = context.getBean(FunctionService.class);
        UseFunctionService useFunctionService = context.getBean(ch1.javaconfig.UseFunctionService.class);//2
        useFunctionService.setFunctionService(functionService);
        System.out.println(useFunctionService.SayHello("java config"));
        context.close();
    }
}

//代码解释
//①AnnotationConfigApplicationContext作为Spring的容器，接收一个配置类作为参数
//②获得声明配置的UseFunctionService的Bean

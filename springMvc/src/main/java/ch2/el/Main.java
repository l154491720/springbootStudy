package ch2.el;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Administrator on 2018/4/10.
 */
public class Main {
    public static void main(String[] agrs){
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ResourceConfig.class); //1

        ElConfig resourceService= context.getBean(ElConfig.class);//2
        resourceService.outputResource();
        context.close();
    }
}

//代码解释
//①AnnotationConfigApplicationContext作为Spring的容器，接收一个配置类作为参数
//②获得声明配置的UseFunctionService的Bean

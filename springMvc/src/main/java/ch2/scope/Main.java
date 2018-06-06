package ch2.scope;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Administrator on 2018/4/10.
 */
public class Main {
    public static void main(String[] agrs){
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ScopeConfig.class);

        DemoSingletonService s1 = context.getBean(DemoSingletonService.class);
        DemoSingletonService s2 = context.getBean(DemoSingletonService.class);
        DemoPrototypeService p1 = context.getBean(DemoPrototypeService.class);
        DemoPrototypeService p2 = context.getBean(DemoPrototypeService.class);

        System.out.println("s1与s2是否相等:" + s1.equals(s2));
        System.out.println("p1与p2是否相等:" + p1.equals(p2));
        context.close();
    }
}

//代码解释
//①AnnotationConfigApplicationContext作为Spring的容器，接收一个配置类作为参数
//②获得声明配置的UseFunctionService的Bean

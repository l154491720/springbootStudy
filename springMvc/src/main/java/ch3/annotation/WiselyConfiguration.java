package ch3.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.lang.annotation.*;

/**
 * Created by qilin.liu on 2018/4/12.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Configuration //1 组合@Configuration元注解
@ComponentScan //2 组合@ComponentScan元注解
public @interface WiselyConfiguration {
    String[] value() default {}; //3 覆盖value参数
}

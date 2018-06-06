package ch2.prepost;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by lenovo on 2018/4/10.
 */
@Configuration
@ComponentScan("ch2.prepost")
public class PrePostConfig {
    @Bean(initMethod="init",destroyMethod="destory")//1
    BeanWayService beanWayService (){
        return new BeanWayService();
    } //1


    @Bean
    JSR250WayService jsr250WayService(){
        return new JSR250WayService();
    }
}
//①initMethod和destoryMethod指定BeanWayService类的init和destory方法在构造函数之后、Bean销毁之前执行。

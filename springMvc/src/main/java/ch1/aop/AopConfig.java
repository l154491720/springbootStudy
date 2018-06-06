package ch1.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by qilin.liu on 2018/4/10.
 */

@Configuration
@ComponentScan("ch1.aop")
@EnableAspectJAutoProxy //1使用@EnableAspectJAutoProxy注解开启Spring对AspectJ代理的支持
public class AopConfig {
}

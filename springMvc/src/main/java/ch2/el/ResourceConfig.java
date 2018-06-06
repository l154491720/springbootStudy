package ch2.el;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by qilin.liu on 2018/4/10.
 */
@Configuration //1
@ComponentScan("ch1.el") //2
public class ResourceConfig {
}

package ch1.di;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2018/4/10.
 */
@Configuration //1
@ComponentScan("ch1.di") //2
public class DiConfig {

}

//①@Configuration声明当前类是一个配置类
//②@ComponentScan("ch1.di")，自动扫描包名下所以使用@Service、@Component、@Repository、
//@Controller的类，并自动注册为bean

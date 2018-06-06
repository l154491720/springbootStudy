package ch2.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by qilin.liu on 2018/4/11.
 */
@Configuration
public class ProfileConfig {

    @Bean
    @Profile("dev") //1 profile为dev时实例化的Bean
    public DemoBean devDemoBean(){
        return new DemoBean("from development profile");
    }

    @Bean
    @Profile("prod")//2 profile为prod时实例化的Bean
    public DemoBean prodDemoBean(){
        return new DemoBean("from production profile");
    }

}

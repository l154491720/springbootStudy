package ch1.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2018/4/10.
 */
@Configuration //1
public class JavaConfig {

    @Bean //2
    public FunctionService functionService(){
        return new FunctionService();
    }

    @Bean
    public UseFunctionService useFunctionService(){
        return new UseFunctionService();
    }

}



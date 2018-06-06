package ch3.conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * Created by qilin.liu on 2018/4/12.
 */
@Configuration
public class ConditionConfig {

    @Bean
    @Conditional(WindowsCondition.class) //1
    public ListService windowsListService(){
        return new WindowsListService();
    }

    @Bean
    @Conditional(LinuxCondition.class) //2
    public ListService linuxListService(){
        return new LinuxListService();
    }
}

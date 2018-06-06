package ch3.tasksheduler;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by qilin.liu on 2018/4/12.
 */
@Configuration
@ComponentScan("ch3.tasksheduler")
@EnableScheduling //1通过@EnableScheduling注解开启对计划任务的支持
public class TaskSchedulerConfig {
}

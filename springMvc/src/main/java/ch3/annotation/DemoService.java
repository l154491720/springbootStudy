package ch3.annotation;

import org.springframework.stereotype.Service;

/**
 * Created by qilin.liu on 2018/4/12.
 */
@Service
public class DemoService {
    public void outputResult(){
        System.out.println("从组合注解配置照样照样获得的bean");
    }
}

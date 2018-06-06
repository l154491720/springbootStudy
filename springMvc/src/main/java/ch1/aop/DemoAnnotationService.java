package ch1.aop;

import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/4/10.
 */
@Service
public class DemoAnnotationService {

    @Action(name="注解拦截的add操作")
    public void add(){
        System.out.println("注解方法执行中......");
    }
}

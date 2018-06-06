package ch1.aop;

import org.springframework.stereotype.Service;

/**
 * Created by qilin.liu on 2018/4/10.
 */
@Service
public class DemoMethodService {
    public void add(){
        System.out.println("方法规则拦截的方法执行中......");
    }
}

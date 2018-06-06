package ch1.di;

import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/4/10.
 */


@Service //1
public class FunctionService {
    public String sayHelloService(String word){
        return "Hello" + word + "!";
    }
}

//代码解释:
//使用@Service注解声明当前FunctionService类是Spring管理类的一个Bean。

package ch1.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/4/10.
 */
@Service //1
public class UseFunctionService {
    @Autowired //2
    FunctionService functionService;

    public String SayHello(String word){
        return functionService.sayHelloService(word);
    }
}
//代码解释
//①使用@Service注解声明当前UseFunctionService类是Spring管理的一个Bean
//②使用Autowrited将FunctionService实体注入到UseFunctionService中，让UseFunctionService
//具备FunctionService的功能

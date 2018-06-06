package ch1.javaconfig;

/**
 * Created by Administrator on 2018/4/10.
 */


 //1
public class FunctionService {
    public String sayHelloService(String word){
        return "Hello" + word + "!";
    }
}

//代码解释:
//①此处没有使用@Service声明Bean

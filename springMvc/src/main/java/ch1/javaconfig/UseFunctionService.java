package ch1.javaconfig;



/**
 * Created by Administrator on 2018/4/10.
 */
 //1
public class UseFunctionService {
     //2
     FunctionService functionService;

    public String SayHello(String word){
        return functionService.sayHelloService(word);
    }

    public void setFunctionService(FunctionService functionService) {
        this.functionService = functionService;
    }
}
//代码解释
//①没有使用@Service注解声明
//②没有使用Autowrited注解声明

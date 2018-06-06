package ch2.prepost;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by lenovo on 2018/4/10.
 */
public class JSR250WayService {
    @PostConstruct //1在构造函数完成之后执行
    public void init(){
        System.out.println("jsr250-init-method");
    }

    public JSR250WayService(){
        super();
        System.out.println("初始化构造函数-JSR250WayService");
    }

    @PreDestroy //2 在Bean销毁之前执行
    public void destory(){
        System.out.println("jsr250-destory-method");
    }
}

package ch3.taskexecutor;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Created by qilin.liu on 2018/4/12.
 */
@Service
public class AsyncTaskService {

    //1 通过@Async注解表明该方法是一个异步方法，如果注解在类级别，则表明该类的所有方法都是异步方法
    //而这里的方法自动被注入使用ThreadPoolTaskExecutor作为TaskExecutor。
    @Async
    public void executeAsyncTask(Integer i){
        System.out.println("执行异步任务:"+i);
    }

    @Async
    public void executeAsyncTaskPlus(Integer i){
        System.out.println("执行异步任务+1:"+(i+1));
    }
}

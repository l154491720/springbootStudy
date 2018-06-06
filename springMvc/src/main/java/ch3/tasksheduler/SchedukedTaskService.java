package ch3.tasksheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by qilin.liu on 2018/4/12.
 * 计划任务执行类
 */
@Service
public class SchedukedTaskService {
    private static final SimpleDateFormat dataFormat = new SimpleDateFormat("HH:mm:ss");

    //1通过@Scheduled声明声明该方法是计划任务，使用fixedRate属性每隔固定时间执行。
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime(){
        System.out.println("每隔5秒执行一次" + dataFormat.format(new Date()));
    }

    //2使用cron属性可按照指定时间执行
    @Scheduled(cron = "0 32 18 ? * *")
    public void fixTimeExecution(){
        System.out.println("在指定时间" + dataFormat.format(new Date()) + "执行");
    }
}

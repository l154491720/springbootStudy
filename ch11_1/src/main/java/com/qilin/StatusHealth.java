package com.qilin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * HealthIndicator实现类
 * Created by qilin.liu on 2018/6/14.
 */

//1 实现HealthIndicator接口并重写health()方法
@Component
public class StatusHealth implements HealthIndicator {

    @Autowired
    StatusService statusService;

    @Override
    public Health health() {
        String status = statusService.getStatus();
        if(status == null || !status.equals("running")){
            //2 当status的值为非running时构造失败
            return Health.down().withDetail("Error","Not Running").build();
        }
        //3 其余情况运行成功
        return Health.up().build();
    }
}

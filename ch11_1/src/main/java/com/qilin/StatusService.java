package com.qilin;

import org.springframework.stereotype.Service;

/**
 * 状态服务(此类无任何特别，仅为改变status的值)
 * Created by qilin.liu on 2018/6/13.
 */
@Service
public class StatusService {


    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

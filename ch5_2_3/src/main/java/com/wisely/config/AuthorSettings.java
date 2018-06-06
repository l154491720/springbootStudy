package com.wisely.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by qilin.liu on 2018/4/20.
 */
@Component
@ConfigurationProperties(prefix = "author") //1
public class AuthorSettings {

    private String name;

    private Long age;

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
/*
通过@ConfigurationsProperties加载properties文件内的配置,通过prefix属性指定properties的配置
的前缀，通过localtions指定properties文件的位置
 */
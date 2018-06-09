package com.wisely.dao;

import com.wisely.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by qilin.liu on 2018/6/9.
 */
@Repository
public class PersonDao {

    //1 SpringBoot已为我们配置了StringRedisTemplate，再次可以直接注入。
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    //3 可以使用@Resource注解指定stringRedisTemplate,可以注入基于字符串的简单属性操作方法
    @Resource(name = "stringRedisTemplate")
    ValueOperations<String, String> valOpsStr;

    //2 SpringBoot已为我们配置了RedisTemplate,在此可以直接注入
    @Autowired
    RedisTemplate<Object,Object> redisTemplate;

    //4 可以使用@Resource注解指定redisTemplate，可以注入基于对象的简单属性操作方法
    @Resource(name = "redisTemplate")
    ValueOperations<Object,Object> valOps;

    //5 通过set方法，存储字符串类型
    public void stringRedisTemplateDemo(){
        valOpsStr.set("xx","yy");
    }

    //6 通过set方法，存储对象类型
    public void save(Person person){
        valOps.set(person.getId(),person);
    }

    //7 通过get方法，获得字符串类型
    public String getString(){
        return valOpsStr.get("xx");
    }
    //8 通过get方法，获得对象类型
    public Person getPerson(){
        return (Person) valOps.get("1");
    }

}

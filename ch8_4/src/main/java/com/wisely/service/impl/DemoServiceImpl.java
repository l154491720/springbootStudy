package com.wisely.service.impl;

import com.wisely.dao.PersonRepository;
import com.wisely.domain.Person;
import com.wisely.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by qilin.liu on 2018/6/8.
 */
@Service
public class DemoServiceImpl implements DemoService {

    //直接注入我们的PersonRepository
    @Autowired
    PersonRepository personRepository; //1

    //2 使用@Transactional注解的rollbackFor属性，指定特定异常时，数据回滚
    @Override
    @Transactional(rollbackFor = {IllegalArgumentException.class})
    public Person savePersonWithRollBack(Person person) {
        Person p = personRepository.save(person);
        if(person.getName().equals("汪云飞")){
            //3 硬编码手动触发异常
            throw new IllegalArgumentException("汪云飞已存在，数据将回滚!");
        }
        return p;
    }

    //4 使用@Transactional注解的noRollbackFor属性，指定特定异常时，数据回滚
    @Override
    @Transactional(noRollbackFor = {IllegalArgumentException.class})
    public Person savePersonWithouRollBack(Person person) {
        Person p = personRepository.save(person);
        if(p.getName().endsWith("汪云飞")){
            throw new IllegalArgumentException("汪云飞虽已存在，数据将会不回滚");
        }
        return p;
    }
}

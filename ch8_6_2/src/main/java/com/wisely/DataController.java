package com.wisely;

import com.wisely.dao.PersonDao;
import com.wisely.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by qilin.liu on 2018/6/9.
 */
@RestController
public class DataController {

    @Autowired
    PersonDao personDao;

    //1 演示设置字符串及对象
    @RequestMapping("/set")
    public void set(){
        Person person = new Person("1","wyf",32);
        personDao.save(person);
        personDao.stringRedisTemplateDemo();
    }

    //2 演示获得字符串
    @RequestMapping("/getStr")
    public String getStr(){
        return personDao.getString();
    }

    //3 演示获得对象
    @RequestMapping("/getPerson")
    public Person getPerson(){
        Person person = personDao.getPerson();
        System.out.println(person);
        return person;
    }
}

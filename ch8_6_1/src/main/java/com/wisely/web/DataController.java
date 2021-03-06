package com.wisely.web;

import com.wisely.dao.PersonRepository;
import com.wisely.domain.Location;
import com.wisely.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;


/**
 * Created by qilin.liu on 2018/6/9.
 */
@RestController
public class DataController {

    @Autowired
    PersonRepository personRepository;

    //1 测试保存数据
    @RequestMapping("/save")
    public Person save(){
        Person p = new Person("lql",32);
        Collection<Location> locations = new LinkedHashSet<>();
        Location loc1 = new Location("上海","2009");
        Location loc2 = new Location("合肥","2010");
        Location loc3 = new Location("广州","2011");
        Location loc4 = new Location("马鞍山","2012");
        locations.add(loc1);
        locations.add(loc2);
        locations.add(loc3);
        locations.add(loc4);
        p.setLocations(locations);
        return personRepository.save(p);
    }

    //2 测试方法名查询
    @RequestMapping("/q1")
    public Person q1(String name){
        return personRepository.findByName(name);
    }

    //3 测试@Query查询
    @RequestMapping("/q2")
    public List<Person> q2(Integer age){
        return personRepository.withQueryFindByAge(age);
    }
}

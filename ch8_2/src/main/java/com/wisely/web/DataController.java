package com.wisely.web;

import com.wisely.dao.PersonRepository;
import com.wisely.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * Created by qilin.liu on 2018/6/6.
 */
@RestController
public class DataController {

    //1 Spring Data JPA已自动为你注册bean,所以可以注入
    @Autowired
    PersonRepository personRepository;

    @RequestMapping("/save")
    public Person save(String name, String address, Integer age){
        Person p = personRepository.save(new Person(name,age,address));
        return p;
    }

    /**
     *测试findByAddress
     */
    @RequestMapping("/q1")
    public List<Person> q1(String address){
        List<Person> people = personRepository.findByAddress(address);
        return people;
    }

    /**
     *测试findByNameAndAddress
     */
    @RequestMapping("/q2")
    public Person q2(String name, String address){
        Person people = personRepository.findByNameAndAddress(name,address);
        return people;
    }

    /**
     *测试withNameAndAddressQuery
     */
    @RequestMapping("/q3")
    public Person q3(String name, String address){
        Person people = personRepository.withNameAndAddressQuery(name,address);
        return people;
    }

    /**
     *测试withNameAndAddressNameQuery
     */
    @RequestMapping("/q4")
    public Person q4(String name, String address){
        Person people = personRepository.withNameAndAddressNameQuery(name,address);
        return people;
    }

    /**
     *测试排序
     */
    @RequestMapping("/sort")
    public List<Person> sort(){
        List<Person> people = personRepository.findAll(new Sort(Sort.Direction.ASC,"age"));
        return people;
    }

    /**
     *测试分页
     */
    @RequestMapping("/page")
    public Page<Person> page(){
        Sort sort=new Sort(Sort.Direction.ASC,"age");
        PageRequest pageable=new PageRequest(1,2);
        Page<Person> pagePeople = personRepository.findAll(pageable);
        return pagePeople;
    }
}

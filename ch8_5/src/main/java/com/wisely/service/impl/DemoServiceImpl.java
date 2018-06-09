package com.wisely.service.impl;

import com.wisely.dao.PersonRepository;
import com.wisely.domain.Person;
import com.wisely.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by qilin.liu on 2018/6/8.
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    PersonRepository personRepository;

    /**
     * 如果没有指定key，则方法参数作为key保存到缓存中
     */

    //1@cachePut缓存新增的或更新的数据到缓存，其中缓存名称为people，数据的key是person的id
    @Override
    @CachePut(value = "people", key = "#person.id")
    public Person save(Person person) {
        Person p = personRepository.save(person);
        System.out.println("为id、key为:"+p.getId()+"数据做了缓存");
        return p;
    }

    //2 @CacheEvict从缓存中删除people中key为id的数据
    @Override
    @CacheEvict(value = "people")
    public void remove(Long id) {
        System.out.println("删除了id、key为"+id+"的数据缓存");
    }

    //3 @Cacheable 缓存key为person的id数据到缓存people中
    @Override
    @Cacheable(value = "people", key = "#person.id")
    public Person findOne(Person person) {
        Optional<Person> p = personRepository.findById(person.getId());
        System.out.println("为id、key为:"+p.get().getId()+"数据做了缓存");
        return p.get();
    }
}

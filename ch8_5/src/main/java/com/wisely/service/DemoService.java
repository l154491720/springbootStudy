package com.wisely.service;

import com.wisely.domain.Person;

/**
 * Created by qilin.liu on 2018/6/8.
 */
public interface DemoService {

    public Person save(Person person);

    public void remove(Long id);

    public Person findOne(Person person);
}

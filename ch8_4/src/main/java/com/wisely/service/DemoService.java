package com.wisely.service;

import com.wisely.domain.Person;

/**
 * Created by qilin.liu on 2018/6/8.
 */
public interface DemoService {

    public Person savePersonWithRollBack(Person person);

    public Person savePersonWithouRollBack(Person person);
}

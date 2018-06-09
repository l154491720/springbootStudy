package com.wisely.web;

import com.wisely.domain.Person;
import com.wisely.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by qilin.liu on 2018/6/8.
 */
@RestController
public class MyController {

    @Autowired
    DemoService demoService;

    @RequestMapping("/rollback")
    public Person rollback(Person person){ //1
        return demoService.savePersonWithRollBack(person);
    }

    @RequestMapping("/norollback")
    public Person noRollback(Person person){ //2
        return demoService.savePersonWithouRollBack(person);
    }
}

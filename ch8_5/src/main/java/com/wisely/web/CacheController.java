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
public class CacheController {

    @Autowired
    DemoService demoService;

    @RequestMapping("/put")
    public Person put(Person person){
        return demoService.save(person);
    }


    @RequestMapping("/able")
    public Person cacheable(Person person){
        return demoService.findOne(person);
    }


    @RequestMapping("/evit")
    public String evit(Long id){
        demoService.remove(id);
        return "ok";
    }
}

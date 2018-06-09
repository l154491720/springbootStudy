package com.wisely.dao;

import com.wisely.domain.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * Created by qilin.liu on 2018/6/9.
 */
public interface PersonRepository extends MongoRepository<Person,String > {

    //1 支持方法名查询
    Person findByName(String name);

    //2 支持@Query查询，查询参数构造JSON字符串即可
    @Query("{'age': ?0}")
    List<Person> withQueryFindByAge(Integer age);
}

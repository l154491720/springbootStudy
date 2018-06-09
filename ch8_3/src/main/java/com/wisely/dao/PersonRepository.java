package com.wisely.dao;

import com.wisely.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * Created by qilin.liu on 2018/6/8.
 */

@RepositoryRestResource(path = "people")
public interface PersonRepository extends JpaRepository<Person,Long> {
    @RestResource(path = "nameStartWith", rel = "nameStartWith")
    Person findByNameStartsWith(@Param("name") String name);
}

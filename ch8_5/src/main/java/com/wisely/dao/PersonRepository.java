package com.wisely.dao;

import com.wisely.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by qilin.liu on 2018/6/8.
 */
public interface PersonRepository extends JpaRepository<Person,Long> {

}

package com.wisely.dao;

import com.wisely.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by qilin.liu on 2018/6/6.
 */
public interface PersonRepository extends JpaRepository<Person, Long> {
    //1 使用方法名查询
    List<Person> findByAddress(String name);

    //2 借用方法名查询，接受name和address，返回值为单个对象。
    Person findByNameAndAddress(String name,String address);

    //3 使用@Query查询，参数按照名称绑定
    @Query("select p from Person p where p.name=:name and p.address=:address")
    Person withNameAndAddressQuery(@Param("name") String name, @Param("address") String address);

    //4 使用NamedQuery查询，请注意我们在实体类中做的@NamedQuery的定义
    Person withNameAndAddressNameQuery(String name, String address);
}

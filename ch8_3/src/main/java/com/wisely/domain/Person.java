package com.wisely.domain;

import javax.persistence.*;

/**
 * 实体类
 * Created by qilin.liu on 2018/6/8.
 */
@Entity
@Table(name = "PERSON")
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "NAME")
    private String name;
    @Column(name = "AGE")
    private Integer age;
    @Column(name = "ADDRESS")
    private String address;

    public Person() {
        super();
    }

    public Person(String name, Integer age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
}

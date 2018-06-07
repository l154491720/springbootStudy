package com.wisely.support.impl;

import com.wisely.support.CustomerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
//静态导入CustomerSpecs类
import static com.wisely.specs.CustomerSpecs.*;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * 此类继承了JpaRepository的实现类SimpleJpaRepository,让我们可以使用SimpleJpaRepository的方法；此类
 * 当然还要我们实现自定义的接口CustomRepository
 * Created by qilin.liu on 2018/6/7.
 */
public class CustomerRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T,ID>
        implements CustomerRepository<T,ID> {


    private final EntityManager entityManager;

    public CustomerRepositoryImpl(Class<T> domainClass, EntityManager entityManager){
        super(domainClass,entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public Page<T> findByAuto(T example, Pageable pageable) {
        return findAll(byAuto(entityManager,example),pageable);
    }
}

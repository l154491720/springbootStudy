package com.wisely.support;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

/**
 * 此例中的接口继承了JpaRepository,让我们具备了JpaRepository所提供的方法;继承了JpaSpecificationExecutor
 * 让我们具备了使用Specification的能力
 * Created by qilin.liu on 2018/6/7.
 */
public interface CustomerRepository<T,ID extends Serializable> extends JpaRepository<T,ID>, JpaSpecificationExecutor<T> {

    Page<T> findByAuto(T example, Pageable pageable);
}

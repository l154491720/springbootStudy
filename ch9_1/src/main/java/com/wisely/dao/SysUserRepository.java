package com.wisely.dao;

import com.wisely.domain.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * Created by qilin.liu on 2018/6/9.
 */
public interface SysUserRepository extends JpaRepository<SysUser,Long> {
    //这里只需一个根据用户名查出用户的方法
    SysUser findByUsername(String username);
}

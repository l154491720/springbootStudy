package com.wisely.security;


import com.wisely.dao.SysUserRepository;
import com.wisely.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by qilin.liu on 2018/6/9.
 */
//1 自定义需实现UserDetailsService接口
public class CustomUserService implements UserDetailsService {

    @Autowired
    SysUserRepository sysUserRepository;


    //2 重写loadUserByUsername
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = sysUserRepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        //我们当前的用户实现了UserDetails接口，可以直接返回给Spring Security使用。
        return user;
    }
}

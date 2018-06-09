package com.wisely;

import com.wisely.security.CustomUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;


/**
 * Created by qilin.liu on 2018/6/9.
 */
//1 扩展Spring Security配置需继承WebSecurityConfigurerAdapter。
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    //2 注册CustomUserService的Bean
    @Bean
    UserDetailsService customUserService(){
        return  new CustomUserService();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService()); //3 添加我们自定义的user detail service认证
    }

    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/css/**", "/js/**","/images/**", "/webjars/**", "**/favicon.ico", "/index").permitAll()
                //4 所有的请求需要认证即登录后才能访问
                .anyRequest().authenticated()
                .and()
                //5 定制登录行为，登录页面可以任意访问
                .formLogin().loginPage("/login")
                .failureForwardUrl("/login?error")
                .permitAll()
                .and()

                //6 定制注销行为，注销请求可以任意访问
                    .logout().permitAll();
    }

}

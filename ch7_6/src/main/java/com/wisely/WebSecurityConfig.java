package com.wisely;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

/**
 * spring security配置
 * Created by qilin.liu on 2018/6/2.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                authorizeRequests()
                .antMatchers("/","/login").permitAll()  //1 设置Spring Security对和"/login"路劲不拦截
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")//2 设置Spring Security的登录页面访问路径为/login
                .defaultSuccessUrl("/chat") //3 登录成功后转向/chat路径
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }


    //4 在内存中分别配置两个用户wfy和wisely，密码和用户名一致，角色是USER
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("wfy")
                .password("wfy")
                .roles("USER")
                .and()
                .withUser("wisely").password("wisely").roles("USER");
    }


    //5 /resource/static目录下的静态资源，Spring security不拦截
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resource/static/**");
    }

    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
}

package com.wisely.highlight_springmvc4.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by qilin.liu on 2018/4/15.
 */
//继承HandlerInterceptorAdapter类来实现自定义拦截器
public class DemoInterceptor extends HandlerInterceptorAdapter {//1
    //重写preHandle方法在请求发生前执行
    @Override
    public boolean preHandle(HttpServletRequest request, //2
                             HttpServletResponse response, Object handler)throws Exception{
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime",startTime);
        return true;
    }

    //重写postHandle方法在请求发生后执行
    @Override
    public void postHandle(HttpServletRequest request, //3
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView)throws Exception{
        long startTime = (Long) request.getAttribute("startTime");
        request.removeAttribute("startTime");
        long endTime = System.currentTimeMillis();
        System.out.println("本次处请求理时间为:" + new Long(endTime - startTime)+"ms");
        request.setAttribute("handlingTime", endTime - startTime);
    }
}

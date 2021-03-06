package com.wisely.highlight_springmvc4.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by qilin.liu on 2018/4/15.
 */
@ControllerAdvice //1
public class ExceptionHandlerAdvice {
    @ExceptionHandler(value = Exception.class) //2
    public ModelAndView exception(Exception exception, WebRequest request){
        ModelAndView modelAndView = new ModelAndView("error"); //error页面
        modelAndView.addObject("errorMessage",exception.getMessage());
        return modelAndView;
    }

    @ModelAttribute //3
    public void addModelAttributes(Model model){
        model.addAttribute("msg","额外信息"); //3
    }

    @InitBinder//4
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.setDisallowedFields("id");//5
    }

    /*
    ①@ControllerAdvice声明了一个控制建言，@ControllerAdvice组合了@Component注解
        所以自动注册为Spring的Bean。
    ②@ExceptionHandler在此处定义全局处理,通过@ExceptionHandler的Value属性可以过滤条件,
        在此处我们可以看出在此处我们拦截的是所有的Exception。
    ③此处使用@ModelAttribute注解将键值对添加到全局,所有注解的@RequestMapping的方法
        可获得此键值对
    ④通过InitBinder注解定制WebDataBinder。
    ⑤此处演示忽略request参数的id，
     */

}

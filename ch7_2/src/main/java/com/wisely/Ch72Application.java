package com.wisely;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@Controller
public class Ch72Application {

	@RequestMapping("/")
	public String index(Model model){
		Person single = new Person("aa" , 11);
		List<Person> people = new ArrayList<>();
		Person p1 = new Person("xx" , 11);
		Person p2 = new Person("yy" , 2);
		Person p3 = new Person("zz" , 33);
		people.add(p1);
		people.add(p2);
		people.add(p3);
		model.addAttribute("singlePerson",single);
		model.addAttribute("people",people);
		return "index";
	}

	//定义BeanNameViewResolver的Bean
	@Bean
	public BeanNameViewResolver beanNameViewResolver(){
		BeanNameViewResolver resolver = new BeanNameViewResolver();
		return resolver;
	}

	//定义一个View的Bean，名称为jsonView
	@Bean
	public MappingJackson2JsonView jsonView(){
		MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
		return jsonView;
	}

	//在控制器中，返回值为字符串jsonView,他会找Bean的名称为jsonView的视图来渲染:
	@RequestMapping(value = "/json",produces = {MediaType.APPLICATION_JSON_VALUE})
	public String json(Model model){
		Person single = new Person("aa",11);
		model.addAttribute("single", single);
		return "jsonView";
	}

	public static void main(String[] args) {
		SpringApplication.run(Ch72Application.class, args);
	}
}

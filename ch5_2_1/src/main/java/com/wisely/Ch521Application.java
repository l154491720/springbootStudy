package com.wisely;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Ch521Application {

	public static void main(String[] args) {
//		SpringApplication.run(Ch521Application.class, args);
		//第二种方法
//		SpringApplication app = new SpringApplication(Ch521Application.class);
//		app.run(args);
		//第三种方法
		new SpringApplication(Ch521Application.class).run(args);
	}

	@RequestMapping("")
	public String index(){
		return "Hello Spring boot";
	}
}

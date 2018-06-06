package com.wisely;

import com.wisely.config.AuthorSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Ch523Application {

	@Autowired
	private AuthorSettings authorSettings; //1

	@RequestMapping("/")
	String index(){
		return "author name is: " + authorSettings.getName() + " and author age is "+ authorSettings.getAge();
	}

	public static void main(String[] args) {
		SpringApplication.run(Ch523Application.class, args);
	}
}

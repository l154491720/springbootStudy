package com.wisely;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.core.JmsTemplate;

/**
 * 消息发送及目的地定义
 */
//1 Spring Boot为我们提供了CommandLineRunner接口，用于程序启动后执行的代码，通过重写run方法执行
@SpringBootApplication
public class Ch934Application implements CommandLineRunner {

	//2 注入SpringBoot为我们配置好的JmsTemplate的Bean
	@Autowired
	JmsTemplate jmsTemplate;

	public static void main(String[] args) {
		SpringApplication.run(Ch934Application.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		//3 通过jmsTemplate的send方法向my-destiination目的地发送Msg的消息，
		//这里也等于在消息上定义了一个目的地叫my-destiination
		jmsTemplate.send("my-destination",new Msg());
	}
}

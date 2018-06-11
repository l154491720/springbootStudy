package com.wisely;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class Ch935Application implements CommandLineRunner{

	//1 可以注入Spring Boot为我们配置好的RabbitTemplate
	@Autowired
	RabbitTemplate rabbitTemplate;

	public static void main(String[] args) {
		SpringApplication.run(Ch935Application.class, args);
	}

	@Bean //2 定义目的地队列，队列名称为my-queue
	public Queue wiselyQueue(){
		return new Queue("my-queue");
	}


	@Override
	public void run(String... args)throws Exception{
		//3 通过RabbitTemplate的convertAndSend方向队列my-queue的发送消息
		rabbitTemplate.convertAndSend("my-queue","来自Rabbitmq的问候1");
		rabbitTemplate.convertAndSend("my-queue","来自Rabbitmq的问候2");
		rabbitTemplate.convertAndSend("my-queue","来自Rabbitmq的问候3");
		rabbitTemplate.convertAndSend("my-queue","来自Rabbitmq的问候4");
		rabbitTemplate.convertAndSend("my-queue","来自Rabbitmq的问候5");
		rabbitTemplate.convertAndSend("my-queue","来自Rabbitmq的问候6");
		rabbitTemplate.convertAndSend("my-queue","来自Rabbitmq的问候7");
	}
}

package com.wisely;






import com.rometools.rome.feed.synd.SyndEntry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.channel.MessageChannels;
import org.springframework.integration.dsl.core.Pollers;
import org.springframework.integration.dsl.file.Files;
import org.springframework.integration.feed.inbound.FeedEntryMessageSource;
import org.springframework.integration.scheduling.PollerMetadata;

import java.io.File;
import java.io.IOException;

import static java.security.Security.getProperty;

@SpringBootApplication
public class Ch94Application {

/*-----------------------------------------读取流程开始-------------------------------------*/
	//1 通过@value注解自动获得https://spring.io/blog.atom
	@Value("http://spring.io/blog.atom")
	Resource resource;

	//2 使用Fluent API和 Pollers配置默认的轮询方式
	@Bean(name = PollerMetadata.DEFAULT_POLLER)
	public PollerMetadata poller(){
		return Pollers.fixedRate(500).get();
	}

	//3 FeedEntryMessageSource 实际为feed:inbound-channel-adapter,此处即构造feed的入站通道适配器作为数据输入
	@Bean
	public FeedEntryMessageSource feedMessageSource()throws IOException {
		FeedEntryMessageSource messageSource = new FeedEntryMessageSource(resource.getURL(),"news");
		return messageSource;
	}

	@Bean
	public IntegrationFlow myFlow()throws IOException{
		//4 流程从from方法开始
		return IntegrationFlows.from(feedMessageSource())
				/*
				5 通过路由方法route来选择路由，消息体(payload)的类型为SyndEntry,作为判断条件的类型为String
				  判断的值是通过payload获得的分类(Categroy)
				 */
		.<SyndEntry, String> route(payload -> payload.getCategories().get(0).getName(),
				/*
				6 通过不同的值转向不同的消息通道，
					若分类为 releases ,则转向 releasesChannel
					若分类为 engineering,则转向 engineeringChannel，
					若分类为 news ，则转向 newsChannel。
				 */
				mapping->mapping.channelMapping("releases","releasesChannel")
				.channelMapping("engineering","engineeringChannel")
						//7 通过get()方法获得IntegrationFlow实体，配置为Spring的Bean
				.channelMapping("news","newsChannel")).get();
	}
/*-----------------------------------------读取流程开始-------------------------------------*/

	@Bean
	public IntegrationFlow releasesFlow(){
		//1 从消息通道releasesChannel开始获取数据
		return IntegrationFlows.from(MessageChannels.queue("releasesChannel",10))
				//2 使用transfrom进行数据转换。payload类型为SyndEntry,将其转换为字符串类型,并自定义数据格式
				.<SyndEntry,String> transform(payload->"《"+payload.getTitle()+"》"+payload.getLink()
				+ getProperty("line.separator"))
				/*
				3 用handle方法处理file的出站适配器，Files类是由Spring Integration Java DSL
				的Fluent API用来构造文件输出的适配器
				 */

				.handle(Files.outboundAdapter(new File("e:/springblog"))
				.fileExistsMode(FileExistsMode.APPEND)
				.charset("UTF-8")
				.fileNameGenerator(message -> "releases.txt")
				.get()).get();
	}

	/**
	 * 与release流程相同
	 * @return
	 */
	@Bean
	public IntegrationFlow engineeringFlow(){
		return IntegrationFlows.from(MessageChannels.queue("engineeringChannel",10))
				.<SyndEntry,String> transform(payload->"《"+payload.getTitle()+"》"+payload.getLink()
						+ getProperty("line.separator"))
				.handle(Files.outboundAdapter(new File("e:/springblog"))
						.fileExistsMode(FileExistsMode.APPEND)
						.charset("UTF-8")
						.fileNameGenerator(message -> "engineering.txt").get())
				.get();
	}

	@Bean
	public IntegrationFlow newsFlow(){
		return IntegrationFlows.from(MessageChannels.queue("newsChannel",10))
				.<SyndEntry,String> transform(payload->"《"+payload.getTitle()+"》"+payload.getLink()
						//1 通过enrichHeaders来增强头部的信息
						+ getProperty("line.separator")).enrichHeaders(
						Mail.headers()
								.subject("来自spring的新闻")
						.to("keaiyuanming@vip.qq.com")
						.from("keaiyuanming@vip.qq.com"))
				//2 邮件发送的相关信息通过Spring Integration Java DSL提供的Mail的headers方法来构造
				//3 使用handle方法来定义邮件发送的出站适配器，使用Spring Integration Java DSL提供的
				//Mail.outboundAdapter方法来构造
				.handle(Mail.outboundAdapter("smtp.126.com")
				.port(25).protocol("smtp").credentials("keaiyuanming@vip.qq.com","*********")
				.javaMailProperties(p->p.put("mail.debug","false")),e->e.id("smtpOut")).get();
	}

	public static void main(String[] args) {
		SpringApplication.run(Ch94Application.class, args);
	}
}

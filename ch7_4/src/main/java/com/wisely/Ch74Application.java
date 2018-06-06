package com.wisely;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@SpringBootApplication
public class Ch74Application {

	public static void main(String[] args) {
		SpringApplication.run(Ch74Application.class, args);
	}

	@RequestMapping("/")
	public String index(){
		return "/index";

	}

	@Bean
	public TomcatServletWebServerFactory servletContainer(){
		TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory(){
			@Override
			protected void postProcessContext(Context context){
				//初始化安全性约束
				SecurityConstraint constraint = new SecurityConstraint();
				//用户安全性约束为机密的
				constraint.setUserConstraint("CONFIDENTIAL");
				//初始化安全集合
				SecurityCollection collection = new SecurityCollection();
				//匹配所有集合
				collection.addPattern("/*");
				//所有安全性集合放入安全性约束中
				constraint.addCollection(collection);
				//容器中添加安全性约束
				context.addConstraint(constraint);
			}
		};
		tomcat.addAdditionalTomcatConnectors(httpConnector());
		return  tomcat;
	}

	/**
	 * Http连接器
	 * @return
	 */
	@Bean
	public Connector httpConnector() {
		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
		connector.setScheme("http");
		//connector监听端口号
		connector.setPort(8080);
		connector.setSecure(false);
		//重定向到端口http连接8443
		connector.setRedirectPort(8443);
		return connector;
	}

}

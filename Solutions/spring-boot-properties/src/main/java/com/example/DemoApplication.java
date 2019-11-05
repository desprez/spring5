package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.service.HelloProperties;
import com.example.service.HelloService;

@SpringBootApplication
@EnableConfigurationProperties(HelloProperties.class)
public class DemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		HelloService helloService = context.getBean(HelloService.class);
		helloService.sayHello(" Spring Boot");
	}
}

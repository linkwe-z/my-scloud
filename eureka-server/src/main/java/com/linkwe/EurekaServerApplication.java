package com.linkwe;
/**
 * 启动一个服务注册中心，只需要一个注解@EnableEurekaServer，这个注解需要在springboot工程的启动application类上加
 * 在默认情况下erureka server也是一个eureka client ,必须要指定一个 server
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {
	//
	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApplication.class, args);
	}
}

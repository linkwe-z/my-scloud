package com.linkwe;
/**
 * @EnableEurekaClient 表明自己是一个eurekaclient
 */

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController    //一定要加这个否则访问不了路径
@EnableHystrix  //加上@EnableHystrix注解开启断路器
@EnableHystrixDashboard
public class EurekaClientApplication {

	public static void main(String[] args) {

		SpringApplication.run(EurekaClientApplication.class, args);
	}

	@Value("${server.port}")
	String port;

	@RequestMapping("/hi")
	@HystrixCommand(fallbackMethod = "hierror")  //声明断路点
	public String home(@RequestParam String name){
		return "hi "+name+",i am from port:" +port;
	}


	public String hierror(String name){
		return "hi,"+name+",访问错误";
	}
}

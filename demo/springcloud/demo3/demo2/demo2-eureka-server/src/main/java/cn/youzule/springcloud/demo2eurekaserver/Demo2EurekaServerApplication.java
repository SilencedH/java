package cn.youzule.springcloud.demo2eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class Demo2EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Demo2EurekaServerApplication.class, args);
		System.out.println("server 启动成功...");
	}
}

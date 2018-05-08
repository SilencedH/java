package cn.youzule.springcloud.demo2configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class Demo2ConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Demo2ConfigServerApplication.class, args);
		System.out.println("demo2ConfigServer启动成功...");
	}
}

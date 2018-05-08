package cn.youzule.springcloud.demo2configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class Demo2ConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(Demo2ConfigClientApplication.class, args);
		System.out.println("client 启动成功");
	}

	@Value("${foo}")
	String foo;

	@GetMapping("/hi")
	public String hi(){
		return foo;
	}
}

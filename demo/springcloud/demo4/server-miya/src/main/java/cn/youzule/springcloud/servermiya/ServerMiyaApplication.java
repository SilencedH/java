package cn.youzule.springcloud.servermiya;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class ServerMiyaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerMiyaApplication.class, args);
		System.out.println("server-miya 启动成功");
	}

	@Autowired
	private RestTemplate restTemplate;

	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

	@RequestMapping("/miya")
	public String home(){
		return "i am miya!";
	}

	@RequestMapping("/miya/hi")
	public String info(){
		return restTemplate.getForObject("http://localhost:8082/hi",String.class);
	}


	@Bean
	public AlwaysSampler defaultSampler(){
		return new AlwaysSampler();
	}
}

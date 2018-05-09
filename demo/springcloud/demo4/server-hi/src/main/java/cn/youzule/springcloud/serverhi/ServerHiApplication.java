package cn.youzule.springcloud.serverhi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class ServerHiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerHiApplication.class, args);
		System.out.println("server hi 启动");
	}

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/hi/miya")
	public String hiMiya(){
		return restTemplate.getForObject("http://localhost:8083/miya",String.class);
	}
	@GetMapping("/hi")
	public String hi(){
		return "i am server-hi";
	}

	@Bean
	public AlwaysSampler alwaysSampler(){
		return new AlwaysSampler();
	}
}

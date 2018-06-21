package net.youzule.youzule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class YouzuleServiceApplication {
	private static Logger logger = LoggerFactory.getLogger(YouzuleServiceApplication.class);
		/*@Bean
        public HttpMessageConverters fastJsonHttpMessageConverters(){
            // 1.定义一个converters转换消息的对象
            FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
            // 2.添加fastjson的配置信息，比如: 是否需要格式化返回的json数据
            FastJsonConfig fastJsonConfig = new FastJsonConfig();
            fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
            // 3.在converter中添加配置信息
            fastConverter.setFastJsonConfig(fastJsonConfig);
            // 4.将converter赋值给HttpMessageConverter
            HttpMessageConverter<?> converter = fastConverter;
            // 5.返回HttpMessageConverters对象
            return new HttpMessageConverters(converter);
        }*/
	public static void main(String[] args) {
		SpringApplication.run(YouzuleServiceApplication.class, args);
		logger.info("youzule-service 启动成功");
	}
}

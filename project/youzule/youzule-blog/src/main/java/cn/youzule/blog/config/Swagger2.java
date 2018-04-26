package cn.youzule.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @title:blog
 * @description:swagger2配置
 * @company:
 * @author:zhaodahai
 * @date:2018/4/9 16:38
 **/

@Configuration
@EnableSwagger2
public class Swagger2 {

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.youzule.blog.module.controller"))
                .paths(PathSelectors.any())
                .build();
    }


    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("spring boot中使用swagger2构建RESTful风格api")
                .description("有足乐")
                .termsOfServiceUrl("http://www.youzule.net")
                .version("1.0")
                .build();
    }
}

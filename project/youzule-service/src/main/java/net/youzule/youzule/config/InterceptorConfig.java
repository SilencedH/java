package net.youzule.youzule.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @title:
 * @description:
 * @company:
 * @author:zhaodahai
 * @date:2018/5/10 15:43
 **/

@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {

    @Autowired
    private MyInterceptor myInterceptor;

    /*添加自定义拦截器*/
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor)
                .addPathPatterns("/**");
        super.addInterceptors(registry);
    }

    /*静态资源处理，主要解决swagger与拦截器冲突问题*/
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /*增加静态资源路径，可以访问到指定路径的静态文件*/
        registry.addResourceHandler("/*.html")
                .addResourceLocations("classpath:/static/");
        /*指定swagger-ui的路径*/
        registry.addResourceHandler("/swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }


}

package cn.youzule.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @title:
 * @description:webMvc配置
 * @company:
 * @author:zhaodahai
 * @date:2018/4/9 16:48
 **/

@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new BlogInterceptor())
                .addPathPatterns("/**");
        super.addInterceptors(registry);
    }

    /*静态资源处理，主要解决swagger与拦截器冲突问题*/
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/*.html")
                .addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}

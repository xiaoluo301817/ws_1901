package cn.xiaoluo.ws.ws_1901.config;

import cn.xiaoluo.ws.ws_1901.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.Arrays;

/**
 * @author luowenqin
 * @create 2019-03-02 9:40
 */
@Configuration
public class WXConfig extends WebMvcConfigurationSupport {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).excludePathPatterns(
                "/",
                "/login.html",
                "/login",
                "/gt/startCaptcha",
                "/login/verifyLogin"
        ).excludePathPatterns(
                "/js/**",
                "/css/**",
                "/images/**",
                "font/**"
        );
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").
                addResourceLocations("classpath:/static/");

        registry.addResourceHandler("/user/**").
                addResourceLocations("classpath:/static/");
    }

}

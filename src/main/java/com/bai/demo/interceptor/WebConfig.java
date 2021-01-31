package com.bai.demo.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author BAI
 * @Description 添加拦截器 可以添加多个拦截器
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        MyLocaleChangeInterceptor myLocaleChangeInterceptor = new MyLocaleChangeInterceptor();
        registry.addInterceptor(myLocaleChangeInterceptor);
    }
}

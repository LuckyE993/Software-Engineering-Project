package com.example.demo.config;

import com.example.demo.intercreptor.loginIntercreptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class webConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(org.springframework.web.servlet.config.annotation.InterceptorRegistry registry) {
        registry.addInterceptor(new loginIntercreptor()).addPathPatterns("hello/**");
    }
}

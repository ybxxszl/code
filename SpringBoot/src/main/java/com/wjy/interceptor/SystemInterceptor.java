package com.wjy.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.wjy.interceptor.UserInterceptor;

@Configuration
public class SystemInterceptor implements WebMvcConfigurer {

	@Autowired
	private UserInterceptor userInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		registry.addInterceptor(userInterceptor).addPathPatterns("/**");

		registry.addInterceptor(userInterceptor).addPathPatterns("/user/**");

	}

}

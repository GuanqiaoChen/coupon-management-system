package com.imooc.passbook;

import com.imooc.passbook.security.AuthCheckInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;

@SpringBootApplication
public class MerchantsApplication extends WebMvcConfigurerAdapter {

	// Inject the intercepter
	@Resource
	private AuthCheckInterceptor authCheckInterceptor;

	// Main function
	public static void main(String[] args) {
		SpringApplication.run(MerchantsApplication.class, args);
	}

	// Configure the intercepter
	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		registry.addInterceptor(authCheckInterceptor)
				.addPathPatterns("/merchants/**");
		super.addInterceptors(registry);
	}
}
